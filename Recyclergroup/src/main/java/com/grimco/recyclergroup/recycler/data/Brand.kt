package com.grimco.recyclergroup.recycler.data

data class Brand( val name: String, var products: List<Product> = ArrayList(), val img: String? = null, val id:Int = 0)
