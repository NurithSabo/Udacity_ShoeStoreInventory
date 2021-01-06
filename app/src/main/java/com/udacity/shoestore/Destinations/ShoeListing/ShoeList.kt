package com.udacity.shoestore.Destinations.ShoeListing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding

class ShoeList : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {

        binding = DataBindingUtil.inflate(
        inflater,
        R.layout.shoelist_fragment,
        container,
        false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.lifecycleOwner = this

        binding.fab.setOnClickListener( Navigation.createNavigateOnClickListener(
            R.id.action_shoeDetails_to_addShoe2
        ))
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, { list ->
            binding.shoes.adapter = ShoeAdapter(list)

        })
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_list)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.lifecycleOwner = this
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu,inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.login_fragment -> {
                return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}