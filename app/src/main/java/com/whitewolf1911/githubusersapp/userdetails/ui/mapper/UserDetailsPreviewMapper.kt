package com.whitewolf1911.githubusersapp.userdetails.ui.mapper

import com.whitewolf1911.githubusersapp.userdetails.domain.model.UserDetails
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserDetailsPreview
import javax.inject.Inject

class UserDetailsPreviewMapper @Inject constructor() {

    fun mapToUserDetailPreview(userDetails: UserDetails): UserDetailsPreview {
        return with(userDetails) {
            UserDetailsPreview(
                name = name,
                following = following.toString(),
                followers = followers.toString(),
                public_repos = public_repos.toString(),
                avatar_url = avatar_url
            )
        }
    }
}
