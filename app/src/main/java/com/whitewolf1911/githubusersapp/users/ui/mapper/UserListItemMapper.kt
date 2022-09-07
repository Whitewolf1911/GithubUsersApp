package com.whitewolf1911.githubusersapp.users.ui.mapper

import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import javax.inject.Inject

class UserListItemMapper @Inject constructor() {

    fun mapToUserListItem(userDTO: UserDTO): UserListItem {
        return UserListItem(
            githubUsername = userDTO.githubUsername,
            name = userDTO.name,
            position = userDTO.position
        )
    }
}
