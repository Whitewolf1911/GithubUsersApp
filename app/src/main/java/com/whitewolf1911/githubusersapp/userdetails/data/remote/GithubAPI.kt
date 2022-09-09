package com.whitewolf1911.githubusersapp.userdetails.data.remote

import com.whitewolf1911.githubusersapp.userdetails.data.model.UserDetailsResponse
import com.whitewolf1911.githubusersapp.userdetails.data.model.UserReposResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {

    @GET("/users/{userName}")
    suspend fun getUserDetails(
        @Path("userName") userName: String
    ): Response<UserDetailsResponse>

    @GET("/users/{userName}/repos")
    suspend fun getUserRepositories(
        @Path("userName") userName: String
    ): Response<UserReposResponse>
}
