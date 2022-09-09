package com.whitewolf1911.githubusersapp.userdetails.ui.usecase

import android.util.Log
import com.whitewolf1911.githubusersapp.userdetails.domain.usecase.UserDetailsUseCase
import com.whitewolf1911.githubusersapp.userdetails.ui.mapper.UserDetailsPreviewMapper
import com.whitewolf1911.githubusersapp.userdetails.ui.mapper.UserRepositoriesListItemMapper
import com.whitewolf1911.githubusersapp.userdetails.ui.mapper.UserRepositoriesPreviewMapper
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserDetailsPreview
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesPreview
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

class UserDetailsPreviewUseCase @Inject constructor(
    private val userDetailsUseCase: UserDetailsUseCase,
    private val userRepositoriesListItemMapper: UserRepositoriesListItemMapper,
    private val userDetailsPreviewMapper: UserDetailsPreviewMapper,
    private val userRepositoriesPreviewMapper: UserRepositoriesPreviewMapper
) {

    fun getInitialUserRepositoriesPreview(): UserRepositoriesPreview =
        userRepositoriesPreviewMapper.createInitialPreview()

    suspend fun getUserRepositoriesPreview(githubUsername: String): UserRepositoriesPreview {
        val userReposPreview =
            UserRepositoriesPreview(userDetailsUseCase.getUserRepositories(githubUsername).map { userRepositoryItem ->
                userRepositoriesListItemMapper.mapToUserRepoListItemPreview(userRepositoryItem)
            })
        return userReposPreview
    }

    suspend fun getUserDetailsPreview(githubUsername: String): Flow<UserDetailsPreview> {
        return userDetailsUseCase.getUserDetails(githubUsername).map { userDetails ->
            userDetailsPreviewMapper.mapToUserDetailPreview(userDetails)
        }
    }
}
