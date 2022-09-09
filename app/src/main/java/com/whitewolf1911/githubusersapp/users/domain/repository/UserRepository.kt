package com.whitewolf1911.githubusersapp.users.domain.repository

import com.whitewolf1911.githubusersapp.userdetails.data.model.UserDetailsResponse
import com.whitewolf1911.githubusersapp.userdetails.data.model.UserReposResponse
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserDetails
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserRepositoryItem
import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUserList(): Flow<List<UserDTO>>

    suspend fun insertUser(userDTO: UserDTO)

    suspend fun checkUserExist(githubUsername: String): Boolean

    suspend fun getUserRepositories(userName: String): Flow<List<UserRepositoryItem>>

    suspend fun getUserDetails(userName: String): Flow<UserDetails>

    companion object {
        const val INJECTION_NAME = "userRepoInjectionName"
    }
}
