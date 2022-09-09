package com.whitewolf1911.githubusersapp.userdetails.ui.model

import com.whitewolf1911.githubusersapp.utils.list.RecyclerListItem


data class UserRepositoriesListItemPreview(
    val repositoryName: String,
    val language: String?,
    val stars: Int,
    val createDate: String
) : RecyclerListItem {
    override fun areItemsTheSame(other: RecyclerListItem): Boolean {
        return other is UserRepositoriesListItemPreview && other.repositoryName == repositoryName
    }

    override fun areContentsTheSame(other: RecyclerListItem): Boolean {
        return other is UserRepositoriesListItemPreview && other == this
    }
}
