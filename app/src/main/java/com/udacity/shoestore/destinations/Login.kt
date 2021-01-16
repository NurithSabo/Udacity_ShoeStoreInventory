package com.udacity.shoestore.destinations

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.destinations.shoeListing.ShoeListViewModel


class Login : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

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

        (activity as MainActivity).supportActionBar?.title = "Login"
        binding.shoelistViewmodel = viewModel

        return binding.root
    }
}