package com.example.jetpacknavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var textMessage: TextView
    private lateinit var buttonUpdateProfile: Button
    private val args: HomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textMessage = view.findViewById(R.id.text_homeFragment_message)
        buttonUpdateProfile = view.findViewById(R.id.button_homeFragment_update)

        textMessage.text = "Hola " + args.email + ", necesitamos que actualices tu perfil!"

        setListeners()

    }

    private fun setListeners(){
        buttonUpdateProfile.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment(
                email = args.email
            )
            requireView().findNavController().navigate(action)
        }
    }
}