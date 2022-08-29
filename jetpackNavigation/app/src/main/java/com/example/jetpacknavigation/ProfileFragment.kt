package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputLayout


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var inputLayoutEmail: TextInputLayout
    private lateinit var buttonUpdate: Button
    private val args: ProfileFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputLayoutEmail = view.findViewById(R.id.editText_profileFragment_email)
        buttonUpdate = view.findViewById(R.id.button_profileFragment_update)

        inputLayoutEmail.editText!!.setText(args.email)

        setListeners()

    }

    private fun setListeners(){
        buttonUpdate.setOnClickListener{
            requireView().findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
    }
}