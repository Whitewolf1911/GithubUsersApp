package com.whitewolf1911.githubusersapp.userdetails.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesListItemPreview
import com.whitewolf1911.githubusersapp.utils.list.BaseDiffUtil

class UserDetailsAdapter : ListAdapter<UserRepositoriesListItemPreview, UserRepositoriesViewHolder>(BaseDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepositoriesViewHolder {
        return UserRepositoriesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserRepositoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
