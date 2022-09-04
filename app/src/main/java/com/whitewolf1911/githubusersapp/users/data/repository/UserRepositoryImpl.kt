package com.whitewolf1911.githubusersapp.users.data.repository

import com.whitewolf1911.githubusersapp.users.data.dao.UserDao
import com.whitewolf1911.githubusersapp.users.data.mapper.UserDTOMapper
import com.whitewolf1911.githubusersapp.users.domain.model.UserDTO
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val userDTOMapper: UserDTOMapper
) : UserRepository {

    override suspend fun getUserList(): Flow<List<UserDTO>> = withContext(Dispatchers.IO) {
        userDao.getUsers().map { userEntityList ->
            userEntityList.map { userEntity ->
                userDTOMapper.mapToUserDTO(userEntity)
            }
        }
    }

    override suspend fun insertUser(userDTO: UserDTO) {
        TODO("Not yet implemented")
    }

    override suspend fun checkUserExist(githubUsername: String): Boolean {
        TODO("Not yet implemented")
    }
}
