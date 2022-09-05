package com.whitewolf1911.githubusersapp.addnewuser.domain.usecase

import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Named

class NewUserUseCase @Inject constructor(
    @Named(UserRepository.INJECTION_NAME)
    private val userRepository: UserRepository
) {

    suspend fun insertUser(
        name: String,
        position: String,
        age: Int,
        githubUsername: String
    ) {
        val userDTO = UserDTO(name = name, position = position, age = age, githubUsername = githubUsername)
        userRepository.insertUser(userDTO)
    }

    suspend fun checkUserExists(githubUsername: String): Boolean {
        return userRepository.checkUserExist(githubUsername)
    }
}
