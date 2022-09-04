package com.whitewolf1911.githubusersapp.users.domain.repository

import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUserList(): Flow<List<UserDTO>>

    suspend fun insertUser(userDTO: UserDTO)

    suspend fun checkUserExist(githubUsername: String): Boolean

    companion object {
        const val INJECTION_NAME = "userRepoInjectionName"
    }
}
