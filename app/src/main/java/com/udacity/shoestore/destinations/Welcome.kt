package com.udacity.shoestore.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding
import com.udacity.shoestore.destinations.shoeListing.ShoeListViewModel

class Welcome : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        (activity as MainActivity).supportActionBar?.title = "Welcome"
        binding.shoelistViewmodel = viewModel

        return binding.root
    }
}