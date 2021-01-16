package com.udacity.shoestore.destinations.shoeListing

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.destinations.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoelistFragmentBinding

class ShoeList : Fragment(){

    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: ShoelistFragmentBinding
    private lateinit var listContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoelist_fragment,
            container,
            false
        )

        listContainer = binding.shoeContainer
        setHasOptionsMenu(true)
        viewModel.loadShoes()
        observeViewModel()

        (activity as MainActivity).supportActionBar?.title = "List of shoes"

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener
                    (R.id.action_shoeDetails_to_addShoe)
            )

        }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.login_fragment -> {

                viewModel.clearList()
                return NavigationUI.onNavDestinationSelected(
                    item,
                    requireView().findNavController()
                )
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun observeViewModel () {
        viewModel.shoeList.observe(viewLifecycleOwner) { shoesList ->
            shoesList.forEach { shoe ->
                val oneShoe = OneShoe(activity as FragmentActivity, listContainer, shoe)
                oneShoe.bindItem()
            }
        }
    }
}