package com.whitewolf1911.githubusersapp.users.ui.mapper

import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import com.whitewolf1911.githubusersapp.users.ui.model.UsersPreview
import javax.inject.Inject

class UsersPreviewMapper @Inject constructor() {

    fun createInitialPreview() = UsersPreview(emptyList())

    fun mapToUsersPreview(userListItems: List<UserListItem>): UsersPreview {
        return UsersPreview(userListItems)
    }
}
