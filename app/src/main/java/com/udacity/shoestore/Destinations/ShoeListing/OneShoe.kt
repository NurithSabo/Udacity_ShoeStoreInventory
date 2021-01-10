package com.udacity.shoestore.Destinations.ShoeListing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.udacity.shoestore.databinding.OneShoeBinding
import com.udacity.shoestore.models.Shoe

class OneShoe (context: Context, val root: LinearLayout, val shoe: Shoe): View(context) {
    fun bindItem() {
        val binding: OneShoeBinding =
            OneShoeBinding.inflate(LayoutInflater.from(context), root, true)
        binding.shoe =shoe
    }
}