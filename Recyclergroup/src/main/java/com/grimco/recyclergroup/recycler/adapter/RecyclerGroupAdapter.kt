package com.grimco.recyclergroup.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grimco.recyclergroup.recycler.R
import com.grimco.recyclergroup.recycler.data.Brand
import com.grimco.recyclergroup.recycler.data.Product

class RecyclerGroupAdapter(private var dataSet: List<Brand> = ArrayList()) : RecyclerView.Adapter<RecyclerGroupAdapter.ViewHolder>(){

    private var listener: ProductAdapter.ProductListener? = null

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val text1 : TextView
        private val recycler: RecyclerView
        private val img: ImageView

        init {
            text1 = view.findViewById(R.id.text1)
            recycler = view.findViewById(R.id.recycler)
            img = view.findViewById(R.id.img)
        }

        fun bind(result: Brand){
            text1.text = result.name

            val adapter = ProductAdapter()
            listener?.let { adapter.addListener(it) }
            adapter.loadData(result.products)

            recycler.adapter = adapter

            recycler.layoutManager = GridLayoutManager(text1.context, 2)
            if (result.img != null) {
                Glide.with(text1.context)
                    .load(result.img)
                    .optionalCircleCrop()
                    .centerInside()
                    .into(img)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size


    fun setData(data: List<Brand>){
        val result = DiffUtil.calculateDiff(DataDiff(dataSet, data))
        dataSet = data
        result.dispatchUpdatesTo(this)

    }

    inner class DataDiff(private val oldList: List<Brand>, private val newList: List<Brand>) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].name == newList[newItemPosition].name

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].name == newList[newItemPosition].name &&
            productList(oldList[oldItemPosition].products, newList[newItemPosition].products )

        private fun productList(oldListPro: List<Product>, newListProd: List<Product> ): Boolean  =
            oldListPro == newListProd

    }

    fun addListener(l0: ProductAdapter.ProductListener ){
        listener = l0
    }



}