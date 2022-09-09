package com.whitewolf1911.githubusersapp.users.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.BaseFragment
import com.whitewolf1911.githubusersapp.core.fragment.FragmentConfiguration
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.databinding.FragmentUsersBinding
import com.whitewolf1911.githubusersapp.users.ui.model.UserListItem
import com.whitewolf1911.githubusersapp.users.ui.model.UsersPreview
import com.whitewolf1911.githubusersapp.utils.lifecycle.observe
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class UsersFragment : BaseFragment(R.layout.fragment_users) {

    private val toolbarConfiguration = ToolbarConfiguration(titleResId = R.string.users)

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val binding by viewBinding(FragmentUsersBinding::bind)

    private val usersViewModel by viewModels<UsersViewModel>()

    private val usersPreviewCollector = FlowCollector<UsersPreview> { usersPreview ->
        initUsersPreview(usersPreview)
    }

    private val userAdapterListener = object : UsersAdapter.UserAdapterListener {
        override fun onUserClick(userListItem: UserListItem) {
            navToUserDetailsFragment(userListItem)
        }
    }

    private val usersAdapter = UsersAdapter(userAdapterListener)

    private fun initUsersPreview(usersPreview: UsersPreview) {
        usersAdapter.submitList(usersPreview.userListItems)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObservers()
    }

    private fun initUi() {

        with(binding) {
            addNewUserButton.setOnClickListener {
                navToAddNewUserFragment()
            }
            usersRecyclerView.adapter = usersAdapter
            usersRecyclerView.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.observe {
            usersViewModel.usersPreviewFlow.collect(usersPreviewCollector)
        }
    }

    private fun navToAddNewUserFragment() {
        nav(UsersFragmentDirections.actionUsersFragmentToAddNewUserFragment())
    }

    private fun navToUserDetailsFragment(userListItem: UserListItem) {
        nav(UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment(userListItem))
    }
}
