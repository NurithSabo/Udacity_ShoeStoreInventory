package com.udacity.shoestore.Destinations.ShoeListing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.Destinations.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.AddShoeFragmentBinding
import com.udacity.shoestore.models.Shoe

class AddShoe : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding : AddShoeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.add_shoe_fragment,
            container,
            false)

        val action = AddShoeDirections.actionAddShoeToShoeDetails()
        binding.cancelButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(action) }

        binding.saveButton.setOnClickListener{
            try {
                val newShoe = Shoe(
                        binding.shoeNameEdit?.text.toString(),
                        binding.sizeEdit.text.toString().toDouble(),
                        binding.companyNameEdit.text.toString(),
                        binding.descriptionEdit.text.toString()
                )
                viewModel.addShoe(newShoe)
                NavHostFragment.findNavController(this).navigate(action)
            } catch (e: Exception) {
                val snackBar = Snackbar.make(
                        it, "Fill all blank spaces.",
                        Snackbar.LENGTH_SHORT
                )
                val snackBarView = snackBar.view
                snackBarView.setBackgroundColor(ContextCompat.getColor(this.requireContext() , R.color.colorPrimary))
                snackBar.show()
            }
        }

        (activity as MainActivity).supportActionBar?.title = "Add shoe"

        return binding.root
    }
}