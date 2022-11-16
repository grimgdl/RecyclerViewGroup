package com.grimco.recyclergroup.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grimco.recyclergroup.recycler.data.Group

class RecyclerGroupAdapter(private var dataSet: List<Group> = ArrayList()) : RecyclerView.Adapter<RecyclerGroupAdapter.ViewHolder>(){

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val text1 : TextView
        val recycler: RecyclerView

        init {
            text1 = view.findViewById(R.id.text1)
            recycler = view.findViewById(R.id.recycler)
        }

        fun bind(result: Group){
            text1.text = result.text1

            val adapter = ProductAdapter()
            adapter.loadData(result.product)

            recycler.adapter = adapter


            recycler.layoutManager = GridLayoutManager(text1.context, 2)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size


    fun setData(data: List<Group>){
        val result = DiffUtil.calculateDiff(DataDiff(dataSet, data))
        dataSet = data
        result.dispatchUpdatesTo(this)
    }

    inner class DataDiff(private val oldList: List<Group>, private val newList: List<Group>) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].text1 == newList[newItemPosition].text1

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].text1 == newList[newItemPosition].text1

    }


}