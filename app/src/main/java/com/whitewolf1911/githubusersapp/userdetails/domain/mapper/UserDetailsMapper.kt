package com.whitewolf1911.githubusersapp.userdetails.domain.mapper

import com.whitewolf1911.githubusersapp.userdetails.data.model.UserDetailsResponse
import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserDetails
import javax.inject.Inject

class UserDetailsMapper @Inject constructor(){

    fun mapToUserDetails(userDetailsResponse: UserDetailsResponse): UserDetails {
        return with(userDetailsResponse) {
            UserDetails(
                name = name,
                followers = followers,
                following = following,
                public_repos = public_repos,
                avatar_url = avatar_url
            )
        }
    }
}
