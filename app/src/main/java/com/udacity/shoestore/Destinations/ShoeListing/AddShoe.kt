package com.udacity.shoestore.Destinations.ShoeListing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.AddShoeFragmentBinding
import com.udacity.shoestore.models.Shoe


class AddShoe : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        val binding = DataBindingUtil.inflate<AddShoeFragmentBinding>(
            inflater,
            R.layout.add_shoe_fragment,
            container,
            false)

        val action = AddShoeDirections.actionAddShoeToShoeDetails()
        binding.cancelButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(action) }

        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.saveButton.setOnClickListener{
            binding.addNewShoe = Shoe(
                binding.shoeNameEdit.text.toString(),
                binding.sizeEdit.text.toString().toDouble(),
                binding.companyNameEdit.text.toString(),
                binding.descriptionEdit.text.toString()
            )
            viewModel.saveCurrentDetail(binding.addNewShoe)

            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }
}