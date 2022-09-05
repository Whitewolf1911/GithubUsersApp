package com.whitewolf1911.githubusersapp.addnewuser.ui

import androidx.lifecycle.viewModelScope
import com.whitewolf1911.githubusersapp.addnewuser.domain.usecase.NewUserUseCase
import com.whitewolf1911.githubusersapp.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AddNewUserViewModel @Inject constructor(
    private val newUserUseCase: NewUserUseCase
) : BaseViewModel() {


    private val _isInsertSuccessfulFlow = MutableStateFlow<Boolean?>(null)
    val isInsertSuccessfulFlow: StateFlow<Boolean?>
        get() = _isInsertSuccessfulFlow


    fun insertUser(
        name: String,
        position: String,
        age: Int,
        githubUsername: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (newUserUseCase.checkUserExists(githubUsername)) {
                _isInsertSuccessfulFlow.emit(false)
            } else {
                newUserUseCase.insertUser(name = name, position = position, age = age, githubUsername = githubUsername)
                _isInsertSuccessfulFlow.emit(true)
            }
        }
    }

}
