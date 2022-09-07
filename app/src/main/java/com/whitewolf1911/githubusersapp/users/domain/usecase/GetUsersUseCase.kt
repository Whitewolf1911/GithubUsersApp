package com.whitewolf1911.githubusersapp.users.domain.usecase

import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase @Inject constructor(
    @Named(UserRepository.INJECTION_NAME)
    private val userRepository: UserRepository
) {

    suspend fun getUsers(): Flow<List<UserDTO>> {
        return userRepository.getUserList()
    }
}
