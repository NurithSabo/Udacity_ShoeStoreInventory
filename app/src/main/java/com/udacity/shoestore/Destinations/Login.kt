package com.udacity.shoestore.Destinations

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        val action = LoginDirections.actionLoginToWelcome()

        binding.loginButton.setOnClickListener {
            NavHostFragment.findNavController (this).navigate(action)}

        binding.registerButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(action) }

        return binding.root
    }
}