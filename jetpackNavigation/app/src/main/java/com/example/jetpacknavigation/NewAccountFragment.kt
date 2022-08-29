package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputLayout


class NewAccountFragment : Fragment(R.layout.fragment_new_account) {
    private lateinit var inputLayoutEmail: TextInputLayout
    private lateinit var buttonCreateAccount: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputLayoutEmail = view.findViewById(R.id.editText_newAccountFragment_email)
        buttonCreateAccount = view.findViewById(R.id.button_newAccountFragment_createCount)

        setListeners()

    }

    private fun setListeners(){
        buttonCreateAccount.setOnClickListener{
            val action = NewAccountFragmentDirections.actionNewAccountFragmentToHomeFragment(
                email = inputLayoutEmail.editText!!.text.toString()
            )
            requireView().findNavController().navigate(action)
        }
    }
}