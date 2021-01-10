package com.udacity.shoestore.Destinations

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class Login : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        binding.loginButton.setOnClickListener {
            val action = LoginDirections.actionLoginToWelcome()
            NavHostFragment.findNavController (this).navigate(action)}

        binding.registerButton.setOnClickListener {
            val action = LoginDirections.actionLoginToWelcome()
            NavHostFragment.findNavController(this).navigate(action) }

        (activity as MainActivity).supportActionBar?.title = "Login"

        return binding.root
    }
}