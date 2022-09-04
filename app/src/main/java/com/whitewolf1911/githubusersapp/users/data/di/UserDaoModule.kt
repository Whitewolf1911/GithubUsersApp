package com.whitewolf1911.githubusersapp.users.data.di

import com.whitewolf1911.githubusersapp.core.database.GithubUsersAppDatabase
import com.whitewolf1911.githubusersapp.users.data.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserDaoModule {

    @Provides
    fun provideUserDao(database: GithubUsersAppDatabase): UserDao {
        return database.userDao()
    }
}
