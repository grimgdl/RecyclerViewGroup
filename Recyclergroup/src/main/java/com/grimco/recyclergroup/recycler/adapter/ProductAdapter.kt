package com.grimco.recyclergroup.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grimco.recyclergroup.recycler.R
import com.grimco.recyclergroup.recycler.data.Product
import com.grimco.recyclergroup.recycler.data.provider.diff.ProductDiff

class ProductAdapter(private var dataSet: List<Product> = ArrayList()) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    private var listener: ProductListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val name: TextView
        private val presen: TextView
        private val img: ImageView

        init {
            name = itemView.findViewById(R.id.txt_name)
            presen = itemView.findViewById(R.id.txt_presentaton)
            img = itemView.findViewById(R.id.img)
        }

        fun bind(result: Product){
            name.text = result.name
            presen.text = result.presentation

            Glide.with(img.context).load(result.img)
                .centerInside()
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(img)

            itemView.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            listener?.onProductClick(dataSet[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun loadData(data: List<Product>){
        val result = DiffUtil.calculateDiff(ProductDiff(dataSet, data))
        dataSet = data
        result.dispatchUpdatesTo(this)

    }

    fun addListener(l0: ProductListener){
        listener = l0
    }


    interface ProductListener{
        fun onProductClick(product: Product)
    }

}