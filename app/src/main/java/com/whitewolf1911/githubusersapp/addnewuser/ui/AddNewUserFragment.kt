package com.whitewolf1911.githubusersapp.addnewuser.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.whitewolf1911.githubusersapp.R
import com.whitewolf1911.githubusersapp.core.fragment.BaseFragment
import com.whitewolf1911.githubusersapp.core.fragment.FragmentConfiguration
import com.whitewolf1911.githubusersapp.core.fragment.ToolbarConfiguration
import com.whitewolf1911.githubusersapp.databinding.FragmentAddNewUserBinding
import com.whitewolf1911.githubusersapp.utils.lifecycle.observe
import com.whitewolf1911.githubusersapp.utils.viewbinding.viewBinding
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collectLatest

class AddNewUserFragment : BaseFragment(R.layout.fragment_add_new_user) {

    private val toolbarConfiguration: ToolbarConfiguration = ToolbarConfiguration(R.string.new_user)

    private val binding by viewBinding(FragmentAddNewUserBinding::bind)

    override val fragmentConfiguration: FragmentConfiguration = FragmentConfiguration(toolbarConfiguration)

    private val addNewUserViewModel by viewModels<AddNewUserViewModel>()

    private var textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            checkInputValidation()
        }

        override fun afterTextChanged(s: Editable?) = Unit
    }

    private val isInsertSuccessfulFlowCollector = FlowCollector<Boolean?> {}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObservers()
    }

    private fun checkInputValidation() {
        with(binding) {
            setButtonVisibility(
                name = nameEditText.text?.trim().toString(),
                position = positionEditText.text?.trim().toString(),
                age = ageEditText.text?.trim().toString(),
                githubUsername = githubEditText.text?.trim().toString()
            )
        }
    }

    private fun setButtonVisibility(
        name: String?,
        position: String?,
        age: String?,
        githubUsername: String?
    ) {
        val nameLength = name?.length
        val positionLength = position?.length
        val ageLength = age?.length
        val githubUsernameLength = githubUsername?.length

        if (nameLength != null && positionLength != null && ageLength != null && githubUsernameLength != null) {
            val isButtonVisible =
                nameLength > 0 && positionLength > 0 && ageLength > 0 && githubUsernameLength > 0
            binding.saveButton.isEnabled = isButtonVisible
        }
    }

    private fun insertUser(
        name: String,
        position: String,
        age: String,
        githubUsername: String,
    ) {
        addNewUserViewModel.insertUser(
            name = name,
            position = position,
            age = age.toInt(),
            githubUsername = githubUsername
        )
    }

    private fun addTextWatcher() {
        with(binding) {
            apply {
                nameEditText.addTextChangedListener(textWatcher)
                positionEditText.addTextChangedListener(textWatcher)
                ageEditText.addTextChangedListener(textWatcher)
                githubEditText.addTextChangedListener(textWatcher)

            }
        }
    }

    private fun initUI() {
        addTextWatcher()
        with(binding) {
            saveButton.setOnClickListener {
                insertUser(
                    name = nameEditText.text.toString(),
                    position = positionEditText.text.toString(),
                    age = ageEditText.text.toString(),
                    githubUsername = githubEditText.text.toString()
                )
            }
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.observe {
            addNewUserViewModel.isInsertSuccessfulFlow.collectLatest { isInsertSuccessfulFlowCollector }
        }
    }
}
