package com.whitewolf1911.githubusersapp.userdetails.domain.mapper

import com.whitewolf1911.githubusersapp.userdetails.data.model.UserReposResponseItem
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserRepositoryItem
import javax.inject.Inject

class UserReposMapper @Inject constructor() {

    fun mapToUserRepositoryItem(userReposResponseItem: UserReposResponseItem): UserRepositoryItem {
        return with(userReposResponseItem) {
            UserRepositoryItem(
                repositoryName = name,
                language = language,
                stars = stargazers_count,
                createDate = created_at
            )
        }
    }
}
