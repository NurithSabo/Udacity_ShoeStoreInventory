package com.udacity.shoestore.Destinations.ShoeListing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }
}