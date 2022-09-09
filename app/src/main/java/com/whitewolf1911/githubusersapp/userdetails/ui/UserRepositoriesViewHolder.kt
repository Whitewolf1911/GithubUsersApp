package com.whitewolf1911.githubusersapp.userdetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.whitewolf1911.githubusersapp.databinding.ItemUserRepositoryBinding
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesListItemPreview

class UserRepositoriesViewHolder(
    private val binding: ItemUserRepositoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userRepositoriesListItemPreview: UserRepositoriesListItemPreview) {
        with(binding) {
            repoNameTextView.text = userRepositoriesListItemPreview.repositoryName
            repoStarsTextView.text = userRepositoriesListItemPreview.stars.toString()
            createDateTextView.text = userRepositoriesListItemPreview.createDate.dropLast(10)
            repoLanguageTextView.text = userRepositoriesListItemPreview.language
        }
    }

    companion object {
        fun create(parent: ViewGroup): UserRepositoriesViewHolder {
            val binding = ItemUserRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserRepositoriesViewHolder(binding)
        }
    }
}
