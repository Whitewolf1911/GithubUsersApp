package com.whitewolf1911.githubusersapp.utils.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun LifecycleOwner.observe(state: Lifecycle.State = Lifecycle.State.RESUMED, action: suspend () -> Unit) {
    lifecycleScope.launch {
        this@observe.repeatOnLifecycle(state) {
            action()
        }
    }
}
