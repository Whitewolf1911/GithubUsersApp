package com.whitewolf1911.githubusersapp.userdetails.data.remote

import com.whitewolf1911.githubusersapp.utils.Constants.Companion.GITHUB_API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: GithubAPI by lazy {
        Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPI::class.java)
    }
}
