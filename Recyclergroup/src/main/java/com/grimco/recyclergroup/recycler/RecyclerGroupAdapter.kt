package com.grimco.recyclergroup.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grimco.recyclergroup.recycler.data.Group

class RecyclerGroupAdapter(private val dataSet: List<Group>) : RecyclerView.Adapter<RecyclerGroupAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val text1 : TextView
        val recycler: RecyclerView

        init {
            text1 = view.findViewById(R.id.text1)
            recycler = view.findViewById(R.id.recycler)
        }

        fun bind(result: Group){
            text1.text = result.text1
            recycler.adapter = ProductAdapter(result.product)
            recycler.layoutManager = GridLayoutManager(text1.context, 2)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size


}