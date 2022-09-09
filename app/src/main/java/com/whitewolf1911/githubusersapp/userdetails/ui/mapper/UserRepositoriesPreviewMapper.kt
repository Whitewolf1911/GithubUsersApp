package com.whitewolf1911.githubusersapp.userdetails.ui.mapper

import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesListItemPreview
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesPreview
import javax.inject.Inject

class UserRepositoriesPreviewMapper @Inject constructor() {

    fun createInitialPreview() = UserRepositoriesPreview(emptyList())

    fun mapToUserRepositoriesPreview(userRepositoriesListItemPreview: List<UserRepositoriesListItemPreview>): UserRepositoriesPreview {
        return UserRepositoriesPreview(userRepositoriesListItemPreview)
    }
}
