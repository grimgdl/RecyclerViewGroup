package com.grimco.recyclergroup

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request

import com.android.volley.toolbox.JsonObjectRequest

import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.grimco.recyclergroup.recycler.adapter.ProductAdapter
import com.grimco.recyclergroup.recycler.data.Group
import com.grimco.recyclergroup.recycler.data.Product

import com.grimco.recyclergroup.recycler.data.provider.Data
import com.grimco.recyclergroup.recycler.view.RecyclerGroupGrim


class MainActivity : AppCompatActivity(), ProductAdapter.ProductListener {

    private lateinit var recyclerGrim: RecyclerGroupGrim


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        recyclerGrim = findViewById(R.id.recycler)

        recyclerGrim.addListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu);

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.refresh -> {
                loadData()
                true
            }
            else -> true
        }
    }

    private fun loadData(){

        val volley = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(Request.Method.GET, "http://10.0.2.2/test", null,
            {


                val gson = Gson()
                val dataObject = gson.fromJson(it.toString(), Data::class.java)

                val list = ArrayList<Group>()

                dataObject.data.asIterable().forEach { pr -> list.add(Group(pr.brand, pr.products)) }

                recyclerGrim.setData(list)

            }, {

            })

        volley.add(request)

    }

    override fun onProductClick(product: Product) {

        Log.d("Main Click", product.name)

    }
}