package com.whitewolf1911.githubusersapp.users.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import com.whitewolf1911.githubusersapp.utils.list.BaseDiffUtil

class UsersAdapter(
    private val listener: UserAdapterListener
) : ListAdapter<UserListItem, UserViewHolder>(BaseDiffUtil()) {

    private val userClickListItem = UserViewHolder.UserClickListener { userListItem ->
        listener.onUserClick(userListItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent, userClickListItem)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface UserAdapterListener {
        fun onUserClick(userListItem: UserListItem)
    }
}
