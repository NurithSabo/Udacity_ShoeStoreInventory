package com.udacity.shoestore.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.destinations.shoeListing.ShoeListViewModel


class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_fragment,
            container,
            false
        )

        binding.shoelistViewmodel = viewModel
        (activity as MainActivity).supportActionBar?.title = "How to use?"

        return binding.root
    }
}