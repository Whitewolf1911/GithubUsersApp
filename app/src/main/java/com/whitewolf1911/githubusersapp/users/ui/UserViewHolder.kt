package com.whitewolf1911.githubusersapp.users.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whitewolf1911.githubusersapp.databinding.ItemUserBinding
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem

class UserViewHolder(
    private val binding: ItemUserBinding,
    private val listener: UserClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userListItem: UserListItem) {
        with(binding) {
            root.setOnClickListener { listener.onClick(userListItem) }
            nameTextView.text = userListItem.name
            positionTextView.text = userListItem.position
        }
    }

    fun interface UserClickListener {
        fun onClick(user: UserListItem)
    }

    companion object {
        fun create(parent: ViewGroup, listener: UserClickListener): UserViewHolder {
            val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserViewHolder(binding, listener)
        }
    }
}
