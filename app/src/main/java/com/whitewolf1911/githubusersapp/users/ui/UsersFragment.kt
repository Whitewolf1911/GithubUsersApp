package com.whitewolf1911.githubusersapp.users.ui

import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.BaseFragment
import com.whitewolf1911.githubusersapp.core.fragment.FragmentConfiguration
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.databinding.FragmentUsersBinding
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding

class UsersFragment : BaseFragment(R.layout.fragment_users) {

    private val toolbarConfiguration = ToolbarConfiguration(titleResId = R.string.users)

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val binding by viewBinding(FragmentUsersBinding::bind)

}
