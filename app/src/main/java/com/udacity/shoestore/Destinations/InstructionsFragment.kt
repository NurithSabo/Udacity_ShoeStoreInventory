package com.udacity.shoestore.Destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding


class InstructionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instructions_fragment, container, false)
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeDetails()
        binding.shoeList.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(action) }

        (activity as MainActivity).supportActionBar?.title = "How to use?"

        return binding.root
    }
}