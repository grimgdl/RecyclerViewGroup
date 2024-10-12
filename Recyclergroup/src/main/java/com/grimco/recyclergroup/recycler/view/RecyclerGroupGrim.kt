package com.grimco.recyclergroup.recycler.view


import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.google.android.material.textfield.TextInputLayout

import com.grimco.recyclergroup.recycler.R
import com.grimco.recyclergroup.recycler.adapter.ProductAdapter
import com.grimco.recyclergroup.recycler.adapter.RecyclerGroupAdapter
import com.grimco.recyclergroup.recycler.data.Brand
import com.grimco.recyclergroup.recycler.data.Group


class RecyclerGroupGrim: ConstraintLayout {

    private val recycler: RecyclerView
    private val adapter : RecyclerGroupAdapter
    private var editFilter: EditText
    private var textInputLayout: TextInputLayout

    init {
        LayoutInflater.from(context).inflate(R.layout.recycler_grim, this, true)

        recycler = findViewById(R.id.recycler_parent)
        editFilter = findViewById(R.id.input_filter)
        textInputLayout = findViewById(R.id.textInputLayout)
        adapter = RecyclerGroupAdapter()

        val animator = recycler.itemAnimator as SimpleItemAnimator
        animator.supportsChangeAnimations = false

        recycler.adapter = adapter

        recycler.layoutManager = LinearLayoutManager(context)

    }


    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attr: AttributeSet) : super(context, attr){

        setupAttributes(attr)

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


    private fun filter(filter: String){
        adapter.filter(filter)
    }

    private fun setupFilter() {

        textInputLayout.visibility = VISIBLE
        editFilter.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filter(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }



    private fun setupAttributes(attrs: AttributeSet?){
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.RecyclerGroupGrim, 0, 0)
        val typedValue = TypedValue()
        context.theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
        val bgColor = a.getColor(R.styleable.RecyclerGroupGrim_bgColor, typedValue.data)

        val groupColor = a.getColor(R.styleable.RecyclerGroupGrim_groupTextColor, typedValue.data)
        val filterWidget = a.getBoolean(R.styleable.RecyclerGroupGrim_filter, false)


        if (filterWidget) {
            setupFilter()
        }

        adapter.setGroupColor(groupColor)

        recycler.setBackgroundColor(bgColor)
    }

    fun addListener(l0: ProductAdapter.ProductListener ){
        adapter.addListener(l0)
    }

}

