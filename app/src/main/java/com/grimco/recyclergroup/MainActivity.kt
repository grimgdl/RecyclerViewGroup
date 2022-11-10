package com.grimco.recyclergroup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grimco.recyclergroup.recycler.RecyclerGroupAdapter
import com.grimco.recyclergroup.recycler.data.Group
import com.grimco.recyclergroup.recycler.data.Product

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)


        val recycler: RecyclerView = findViewById(R.id.recycler)

        val list = ArrayList<Group>()

        val prod1 = ArrayList<Product>()
        prod1.add(Product(1, "pro1", "3L"))
        prod1.add(Product(2, "pro2", "4L"))
        prod1.add(Product(3, "pro3", "6L"))

        val prod2 = ArrayList<Product>()
        prod2.add(Product(4, "pro4", "5g"))
        prod2.add(Product(5, "pro5", "5g"))
        prod2.add(Product(6, "pro6", "6g"))
        prod2.add(Product(7, "pro7", "10g"))


        val group1 = Group("uno", prod1)
        val group2 = Group("dos", prod2)
        list.add(group1)
        list.add(group2)

        val adapter = RecyclerGroupAdapter(list)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)

    }
}