package com.grimco.recyclergroup.recycler.data.provider.diff

import androidx.recyclerview.widget.DiffUtil
import com.grimco.recyclergroup.recycler.data.Product

class ProductDiff(private val oldList: List<Product>, private val newList: List<Product>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == newList[newItemPosition].name &&
                oldList[oldItemPosition].presentation == newList[newItemPosition].presentation &&
                oldList[oldItemPosition].img == newList[newItemPosition].img


}