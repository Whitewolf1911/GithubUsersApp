package com.whitewolf1911.githubusersapp.userdetails.domain.model

data class UserDetails(
    val avatar_url:String,
    val followers: Int,
    val following: Int,
    val name: String,
    val public_repos: Int,
)
