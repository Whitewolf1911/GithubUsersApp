package com.whitewolf1911.githubusersapp.users.ui.model

import android.os.Parcelable
import com.whitewolf1911.githubusersapp.utils.list.RecyclerListItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserListItem(
    val githubUsername: String,
    val name: String,
    val position: String
) : RecyclerListItem, Parcelable {
    override fun areItemsTheSame(other: RecyclerListItem): Boolean {
        return other is UserListItem && other.githubUsername == githubUsername
    }

    override fun areContentsTheSame(other: RecyclerListItem): Boolean {
        return other is UserListItem && other == this
    }
}
