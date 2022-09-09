package com.whitewolf1911.githubusersapp.userdetails.domain.model

data class UserRepositoryItem(
    val repositoryName: String,
    val language: String?,
    val stars: Int,
    val createDate: String
)
