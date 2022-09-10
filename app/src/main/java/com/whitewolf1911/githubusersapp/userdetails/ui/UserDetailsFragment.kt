package com.whitewolf1911.githubusersapp.userdetails.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.BaseFragment
import com.whitewolf1911.githubusersapp.core.fragment.FragmentConfiguration
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.databinding.FragmentUserDetailBinding
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserDetailsPreview
import com.whitewolf1911.githubusersapp.userdetails.ui.model.UserRepositoriesPreview
import com.whitewolf1911.githubusersapp.utils.lifecycle.observe
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailsFragment : BaseFragment(R.layout.fragment_user_detail) {

    private val binding by viewBinding(FragmentUserDetailBinding::bind)

    private val toolbarConfiguration = ToolbarConfiguration(
        titleResId = R.string.user_details,
        startIconResId = R.drawable.ic_arrow_back,
        startIconClick = ::navBack
    )

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val userDetailsViewModel by viewModels<UserDetailsViewModel>()

    private val userDetailsAdapter = UserDetailsAdapter()

    private val userDetailsPreviewCollector = FlowCollector<UserDetailsPreview> {
        initUserDetailPreview(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObservers()
        lifecycleScope.launch {
        }
    }

    private fun initUI() {
        binding.userReposRecyclerView.adapter = userDetailsAdapter
        getToolbar()?.setTitle(userDetailsViewModel.getUserName())
    }

    private fun initUserRepositoriesPreview(userRepositoriesPreview: UserRepositoriesPreview) {
        userDetailsAdapter.submitList(userRepositoriesPreview.userRepositoryItems.toMutableList())
        userDetailsAdapter.notifyDataSetChanged()
    }

    private fun initUserDetailPreview(userDetailsPreview: UserDetailsPreview) {
        with(binding) {
            nameTextView.text = userDetailsPreview.name
            followersTextView.text = userDetailsPreview.followers
            followingTextView.text = userDetailsPreview.following
            publicReposTextView.text = userDetailsPreview.public_repos
            context?.let {
                Glide.with(it).load(userDetailsPreview.avatar_url).into(avatarImageView)
            }
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.observe {
            userDetailsViewModel.userDetailsPreviewFlow.collect(userDetailsPreviewCollector)
        }
        viewLifecycleOwner.observe {
            initUserRepositoriesPreview(userDetailsViewModel.getUserRepositories())
        }
    }
}
