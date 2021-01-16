package com.udacity.shoestore.destinations.shoeListing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.destinations.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.AddShoeFragmentBinding
class AddShoe : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: AddShoeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.add_shoe_fragment,
            container,
            false
        )

        binding.shoelistViewmodel = viewModel
/*
        viewModel.name.value = "Winflo"
        viewModel.company.value = "NIKE"
        viewModel.size.value = 4.5.toString()
        viewModel.description.value = "running shoes"*/

        (activity as MainActivity).supportActionBar?.title = "Add shoe"

        return binding.root
    }
}