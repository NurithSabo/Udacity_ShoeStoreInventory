package com.udacity.shoestore.Destinations.ShoeListing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeAdapter(private var shoeList: MutableList<Shoe>) : RecyclerView.Adapter<ShoeAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_shoe, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.shoeName.text =shoe.name
        holder.company.text = shoe.company
        holder.shoeSize.text = shoe.size.toString()
        holder.description.text = shoe.description
    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val shoeName: TextView = item.findViewById(R.id.shoe_name)
        val shoeSize: TextView = item.findViewById(R.id.size )
        val company: TextView = item.findViewById(R.id.company)
        val description: TextView = item.findViewById(R.id.description)
    }
}