package com.whitewolf1911.githubusersapp.userdetails.ui.mapper

import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserRepositoryItem
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesListItemPreview
import javax.inject.Inject

class UserRepositoriesListItemMapper @Inject constructor() {

    fun mapToUserRepoListItemPreview(userRepositoryItem: UserRepositoryItem):UserRepositoriesListItemPreview{
        return with(userRepositoryItem){
            UserRepositoriesListItemPreview(
                repositoryName = repositoryName,
                stars = stars,
                language = language,
                createDate = createDate,
            )
        }
    }
}
