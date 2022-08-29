package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var inputLayoutEmail: TextInputLayout
    private lateinit var buttonNewAccount: Button
    private lateinit var buttonLogin: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputLayoutEmail = view.findViewById(R.id.editText_loginFragment_email)
        buttonNewAccount = view.findViewById(R.id.button_loginFragment_goToNewAccount)
        buttonLogin = view.findViewById(R.id.button_loginFragment_login)

        setListeners()

    }

    private fun setListeners(){
        buttonNewAccount.setOnClickListener{

            requireView().findNavController().navigate(R.id.action_loginFragment_to_newAccountFragment)
        }
        buttonLogin.setOnClickListener {
            val email = inputLayoutEmail.editText!!.text.toString()
            if (email == "jcdurini@uvg.edu.gt"){
                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                    email
                )
                requireView().findNavController().navigate(action)
            }
            else {
                Toast.makeText(requireContext(), getString(R.string.errorEmail), Toast.LENGTH_LONG).show()
            }


        }
    }
}