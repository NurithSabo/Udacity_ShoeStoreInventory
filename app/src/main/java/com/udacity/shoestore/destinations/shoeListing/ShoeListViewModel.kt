package com.udacity.shoestore.destinations.shoeListing

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.destinations.InstructionsFragmentDirections
import com.udacity.shoestore.destinations.LoginDirections
import com.udacity.shoestore.destinations.WelcomeDirections
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    val shoeList : MutableLiveData<List<Shoe>> = MutableLiveData(emptyList())
    //val _shoeList: LiveData<List<Shoe>>
      //  get() = shoeList

    init {
        shoeList.value?.plus(Shoe("Winflo",45.0,"NIKE", "running shoes"))
    }

    fun loadShoes() {
        shoeList
    }

    fun clearList() {
        shoeList.value = mutableListOf()
    }

    fun onCancelClick(view : View){
        view.findNavController().navigateUp()
    }

    val name = MutableLiveData("")
    val size = MutableLiveData("")
    val company = MutableLiveData("")
    val description = MutableLiveData("")

    fun onSaveClick(view:View) {

        val allBlankFilled : Boolean = listOf(
            name.value.orEmpty(),
            size.value.toString(),
            company.value.orEmpty(),
            description.value.orEmpty()
        )
            .none { it.isEmpty() }

        if (allBlankFilled && name.value?.trim()?.length!! > 0 &&
            company.value?.trim()?.length!! > 0  && description.value?.trim()?.length!! > 0) {

            try {
                size.value?.toDouble()
            }
            catch ( e : Exception){
                WrongData(view)
            }

            shoeList.value = shoeList.value?.plus(
          //  shoeList.value = _shoeList.value?.plus(
                Shoe(
                    name.value.orEmpty().trim(),
                    size.value?.toDoubleOrNull() ?: 0.0,
                    company.value.orEmpty().trim(),
                    description.value.orEmpty().trim()
                )
            )
            //shoeList.value = _shoeList.value
            view.findNavController().navigateUp()

            name.value = ""
            company.value = ""
            size.value = ""
            description.value = ""


        }

        else {
            WrongData(view)
        }
    }

    private fun WrongData (view : View){
        val snackBar = Snackbar.make(
            view.rootView, "Fill all blank spaces.",
            Snackbar.LENGTH_SHORT
        )
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(view.context , R.color.colorPrimary))
        snackBar.show()
    }

    fun instructionsClick(view : View){
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeDetails()
            view.findNavController().navigate(action)
    }

    fun welcomeClick(view : View){
        val action = WelcomeDirections.actionWelcomeToInstructionsFragment()
        view.findNavController().navigate(action)
    }

    fun loginOrRegister(view : View) {
        val action = LoginDirections.actionLoginToWelcome()
        view.findNavController().navigate(action)
    }
}