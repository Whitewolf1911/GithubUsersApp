package com.whitewolf1911.githubusersapp.userdetails.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.whitewolf1911.githubusersapp.core.BaseViewModel
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserDetailsPreview
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesPreview
import com.whitewolf1911.githubusersapp.userdetails.ui.usecase.UserDetailsPreviewUseCase
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import com.whitewolf1911.githubusersapp.utils.getOrThrow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userDetailsPreviewUseCase: UserDetailsPreviewUseCase
) : BaseViewModel() {

    private val userListItem = savedStateHandle.getOrThrow<UserListItem>(USER_ITEM_KEY)
    private val userUsername = savedStateHandle.getOrThrow<UserListItem>(USER_ITEM_KEY).githubUsername

    private val _userDetailsPreviewFlow = MutableStateFlow<UserDetailsPreview>(createInitialUserDetailsPreview())
    val userDetailsPreviewFlow: StateFlow<UserDetailsPreview>
        get() = _userDetailsPreviewFlow

    init {
        initializeUserDetailsFlow()
    }

    fun getUserName() = userListItem.name

    private fun createInitialUserDetailsPreview(): UserDetailsPreview {
        return UserDetailsPreview("", "", "", "", "")
    }

    private fun initializeUserDetailsFlow() {
        viewModelScope.launch {
            userDetailsPreviewUseCase.getUserDetailsPreview(userUsername).collectLatest { userDetailPreview ->
                _userDetailsPreviewFlow.value = userDetailPreview
            }
        }
    }

    fun getUserRepositories(): UserRepositoriesPreview {
        var userRepositoriesPreview = UserRepositoriesPreview(emptyList())
        runBlocking {
            userRepositoriesPreview = userDetailsPreviewUseCase.getUserRepositoriesPreview(userUsername)
        }
        return userRepositoriesPreview
    }

    companion object {
        private const val USER_ITEM_KEY = "userListItem"
    }
}
