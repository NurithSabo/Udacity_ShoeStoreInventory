package com.udacity.shoestore.models

import android.os.Parcelable
import android.util.Log
import androidx.core.content.ContextCompat
import com.udacity.shoestore.R
import kotlinx.android.parcel.Parcelize
import java.lang.Exception

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {
}

