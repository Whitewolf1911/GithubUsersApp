package com.whitewolf1911.githubusersapp.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.customviews.CustomToolbar
import com.whitewolf1911.githubusersapp.databinding.ActivityMainBinding
import com.whitewolf1911.githubusersapp.utils.navigateSafe
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController =
            (supportFragmentManager.findFragmentById(binding.navigationHostFragment.id) as NavHostFragment).navController
    }

    fun navBack() {
        navController.navigateUp()
    }

    fun nav(directions: NavDirections, onError: (() -> Unit)? = null) {
        navController.navigateSafe(directions, onError)
    }

    fun configureToolbar(toolbarConfiguration: ToolbarConfiguration?) {
        binding.toolbar.configure(toolbarConfiguration)
    }

    fun getToolbar(): CustomToolbar = binding.toolbar
}
