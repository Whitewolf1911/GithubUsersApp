package com.whitewolf1911.githubusersapp.users.data.repository

import com.whitewolf1911.githubusersapp.userdetails.data.remote.RetrofitInstance
import com.whitewolf1911.githubusersapp.userdetails.domain.mapper.UserDetailsMapper
import com.whitewolf1911.githubusersapp.userdetails.domain.mapper.UserReposMapper
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserDetails
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserRepositoryItem
import com.whitewolf1911.githubusersapp.users.data.dao.UserDao
import com.whitewolf1911.githubusersapp.users.data.mapper.UserDTOMapper
import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val userDTOMapper: UserDTOMapper,
    private val userDetailsMapper: UserDetailsMapper,
    private val userReposMapper: UserReposMapper
) : UserRepository {

    override suspend fun getUserList(): Flow<List<UserDTO>> = withContext(Dispatchers.IO) {
        userDao.getUsers().map { userEntityList ->
            userEntityList.map { userEntity ->
                userDTOMapper.mapToUserDTO(userEntity)
            }
        }
    }

    override suspend fun insertUser(userDTO: UserDTO) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(userDTOMapper.mapToUserEntity(userDTO))
        }
    }

    override suspend fun checkUserExist(githubUsername: String): Boolean =
        withContext(Dispatchers.IO) {
            userDao.checkUserExists(githubUsername)
        }

    override suspend fun getUserRepositories(userName: String): List<UserRepositoryItem> {
        val userRepositories = mutableListOf<UserRepositoryItem>()
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getUserRepositories(userName)
            if (response.isSuccessful && response.body() != null) {
                response.body()?.forEach {
                    userRepositories.add(userReposMapper.mapToUserRepositoryItem(it))
                }
            }
        }
        return userRepositories
    }

    override suspend fun getUserDetails(userName: String): Flow<UserDetails> {
        lateinit var userDetails: UserDetails
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getUserDetails(userName)
            userDetails = if (response.isSuccessful && response.body() != null) {
                userDetailsMapper.mapToUserDetails(response.body()!!)
            } else {
                UserDetails("", 0, 0, "error", 0)
            }
        }
        return flowOf(userDetails)
    }
}
