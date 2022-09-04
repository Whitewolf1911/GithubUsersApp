package com.whitewolf1911.githubusersapp.users.data.mapper

import com.whitewolf1911.githubusersapp.users.data.model.entity.UserEntity
import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import javax.inject.Inject

class UserDTOMapper @Inject constructor() {

    fun mapToUserDTO(
        userEntity: UserEntity
    ): UserDTO {
        return with(userEntity) {
            UserDTO(
                name = name,
                age = age,
                position = position,
                githubUsername = githubUsername
            )
        }
    }

    fun mapToUserEntity(userDTO: UserDTO): UserEntity {
        return with(userDTO) {
            UserEntity(
                name = name,
                age = age,
                position = position,
                githubUsername = githubUsername
            )
        }
    }
}
