package com.whitewolf1911.githubusersapp.userdetails.domain.usecase

import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserDetails
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserRepositoryItem
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.Flow

class UserDetailsUseCase @Inject constructor(
    @Named(UserRepository.INJECTION_NAME)
    private val userRepository: UserRepository
) {

    suspend fun getUserDetails(githubUsername: String): Flow<UserDetails> {
        return userRepository.getUserDetails(githubUsername)
    }

    suspend fun getUserRepositories(githubUsername: String): Flow<List<UserRepositoryItem>> {
        return userRepository.getUserRepositories(githubUsername)
    }
}
