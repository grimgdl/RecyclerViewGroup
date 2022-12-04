package com.grimco.recyclergroup.recycler.view


import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.grimco.recyclergroup.recycler.R
import com.grimco.recyclergroup.recycler.adapter.ProductAdapter
import com.grimco.recyclergroup.recycler.adapter.RecyclerGroupAdapter
import com.grimco.recyclergroup.recycler.data.Brand
import com.grimco.recyclergroup.recycler.data.Group


class RecyclerGroupGrim: ConstraintLayout {

    private val recycler: RecyclerView
    private val adapter : RecyclerGroupAdapter

    init {
        LayoutInflater.from(context).inflate(R.layout.recycler_grim, this, true)

        recycler = findViewById(R.id.recycler_parent)

        adapter = RecyclerGroupAdapter()
        recycler.adapter = adapter

        recycler.layoutManager = LinearLayoutManager(context)

    }


    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attr: AttributeSet) : super(context, attr){

        //setupAttributes(attr)

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){

    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){

    }

    fun setData(data: List<Brand>){
        adapter.setData(data)
    }

    private fun setupAttributes(attrs: AttributeSet?){
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.RecyclerGroupGrim, 0, 0)
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
        val bgColor = a.getColor(R.styleable.RecyclerGroupGrim_bgColor, typedValue.data)

        recycler.setBackgroundColor(bgColor)
    }

    fun addListener(l0: ProductAdapter.ProductListener ){
        adapter.addListener(l0)
    }

}

