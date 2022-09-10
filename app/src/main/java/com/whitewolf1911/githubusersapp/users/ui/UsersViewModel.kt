package com.whitewolf1911.githubusersapp.users.ui

import androidx.lifecycle.viewModelScope
import com.whitewolf1911.githubusersapp.core.BaseViewModel
import com.whitewolf1911.githubusersapp.users.ui.model.UsersPreview
import com.whitewolf1911.githubusersapp.users.ui.usecase.UsersPreviewUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersPreviewUseCase: UsersPreviewUseCase
) : BaseViewModel() {

    private val _usersPreviewFlow = MutableStateFlow(usersPreviewUseCase.getInitialPreview())
    val usersPreviewFlow: StateFlow<UsersPreview>
        get() = _usersPreviewFlow

    init {
        initializeUsersPreviewFlow()
    }

    private fun initializeUsersPreviewFlow() {
        viewModelScope.launch {
            usersPreviewUseCase.getUserListItems().collectLatest { userPreview ->
                _usersPreviewFlow.value = userPreview
            }
        }
    }

    fun sortUsersPreviewFlow() {
        viewModelScope.launch {
            usersPreviewUseCase.getUserListItemsSorted().collectLatest { userPreview ->
                _usersPreviewFlow.value = userPreview
            }
        }
    }
}
