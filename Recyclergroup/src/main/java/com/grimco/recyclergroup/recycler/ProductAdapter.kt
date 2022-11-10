package com.grimco.recyclergroup.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grimco.recyclergroup.recycler.data.Product

class ProductAdapter(private val dataSet: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView
        val presen: TextView

        init {
            name = itemView.findViewById(R.id.txt_name)
            presen = itemView.findViewById(R.id.txt_presentaton)
        }

        fun bind(result: Product){
            name.text = result.name
            presen.text = result.presentation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}