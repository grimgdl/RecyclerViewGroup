package com.grimco.recyclergroup

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.grimco.recyclergroup.recycler.RecyclerGroupAdapter
import com.grimco.recyclergroup.recycler.data.Group
import com.grimco.recyclergroup.recycler.data.Product
import com.grimco.recyclergroup.recycler.data.provider.Data
import com.grimco.recyclergroup.recycler.data.provider.ProductJson

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)


        val recycler: RecyclerView = findViewById(R.id.recycler)


        val json = "{" +
                " 'data': [ " +
                "{'brand':'uno', products:[ {'id':1, 'name':'prod1', 'presentation':'3l'},{'id':2, 'name':'prod2', 'presentation':'4L'}," +
                "                 {'id':8, 'name':'prod8', 'presentation':'10l', 'img':'https://picsum.photos/200'} ]}," +
                "{'brand':'dos', products:[ {'id':3, 'name':'prod3', 'presentation':'6l'},{'id':4, 'name':'prod4', 'presentation':'1l'}]}," +
                "{'brand':'dos', products:[ {'id':6, 'name':'prod3', 'presentation':'6l'},{'id':7, 'name':'prod4', 'presentation':'1l'}]}," +
                "{'brand':'dos', products:[ {'id':8, 'name':'prod3', 'presentation':'6l'},{'id':9, 'name':'prod4', 'presentation':'1l'},{'id':10, 'name':'prod4', 'presentation':'1l'} ]}" +
                "] " +
                "}"


        val gson = Gson()

        val dataObject = gson.fromJson(json, Data::class.java)

        val list = ArrayList<Group>()

        dataObject.data.asIterable().forEach {
            list.add(Group(it.brand, it.products))
        }

        val adapter = RecyclerGroupAdapter()
        adapter.setData(list)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

    }
}