package com.whitewolf1911.githubusersapp.addnewuser.ui

import android.os.Bundle
import android.view.View
import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.BaseFragment
import com.whitewolf1911.githubusersapp.core.fragment.FragmentConfiguration
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.databinding.FragmentAddNewUserBinding
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding

class AddNewUserFragment : BaseFragment(R.layout.fragment_add_new_user) {

    private val toolbarConfiguration: ToolbarConfiguration = ToolbarConfiguration(R.string.new_user)

    private val binding by viewBinding(FragmentAddNewUserBinding::bind)

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
