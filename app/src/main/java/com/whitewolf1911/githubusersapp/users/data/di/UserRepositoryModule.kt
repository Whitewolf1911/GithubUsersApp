package com.whitewolf1911.githubusersapp.users.data.di

import com.whitewolf1911.githubusersapp.users.data.dao.UserDao
import com.whitewolf1911.githubusersapp.users.data.mapper.UserDTOMapper
import com.whitewolf1911.githubusersapp.users.data.repository.UserRepositoryImpl
import com.whitewolf1911.githubusersapp.users.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    @Provides
    @Named(UserRepository.INJECTION_NAME)
    fun provideUserRepository(
        userDao: UserDao,
        userDTOMapper: UserDTOMapper
    ): UserRepository {
        return UserRepositoryImpl(
            userDao = userDao,
            userDTOMapper = userDTOMapper
        )
    }
}
