package com.grimco.recyclergroup

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request

import com.android.volley.toolbox.JsonObjectRequest

import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.grimco.recyclergroup.recycler.RecyclerGroupAdapter
import com.grimco.recyclergroup.recycler.data.Group

import com.grimco.recyclergroup.recycler.data.provider.Data


class MainActivity : AppCompatActivity() {

    private val adapter: RecyclerGroupAdapter = RecyclerGroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val recycler: RecyclerView = findViewById(R.id.recycler)


        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)



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

                dataObject.data.asIterable().forEach {
                    list.add(Group(it.brand, it.products))
                }

                adapter.setData(list)

            }, {

            })

        volley.add(request)

    }
}