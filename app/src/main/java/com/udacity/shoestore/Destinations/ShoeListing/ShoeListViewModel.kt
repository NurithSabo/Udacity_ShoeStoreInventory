package com.udacity.shoestore.Destinations.ShoeListing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>()
    private val _shoeList = mutableListOf<Shoe>()

/*    init {
     shoeList.value =ArrayList()
      addShoe(Shoe ("Sooray", 38.0, "Adidas", "running shoes"))
    }*/

    fun loadShoes() {
        shoeList.value =_shoeList
    }

    fun addShoe(addedshoe: Shoe) {
        _shoeList.add(addedshoe)
        shoeList.value = shoeList.value
    }

    fun clearList(){
        _shoeList.clear()
    }

 }