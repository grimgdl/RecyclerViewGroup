package com.grimco.recyclergroup

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request

import com.android.volley.toolbox.JsonObjectRequest

import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.grimco.recyclergroup.databinding.MainActivityBinding
import com.grimco.recyclergroup.recycler.adapter.ProductAdapter
import com.grimco.recyclergroup.recycler.data.Brand
import com.grimco.recyclergroup.recycler.data.Group
import com.grimco.recyclergroup.recycler.data.Product

import com.grimco.recyclergroup.recycler.data.provider.Data
import com.grimco.recyclergroup.recycler.view.RecyclerGroupGrim
import java.text.FieldPosition


class MainActivity : AppCompatActivity(), ProductAdapter.ProductListener {

    private lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.addListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu);

        return true;
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.refresh -> {
                loadData()
                true
            }

            else -> true
        }
    }

    private fun loadData() {

        val brands = mutableListOf<Brand>()
        val brand1 = Brand(
            id = 1,
            name = "Brand 1",
            img = "https://img.freepik.com/fotos-premium/botella-suero-vidrio-blanco-tarro-crema-bano-flores-orquideas-fondo-productos-cosmeticos-marca-maqueta-marca-productos-cosmeticos-spa_294132-1096.jpg?w=900",
            products = mutableListOf(
                Product(
                    id = 1,
                    name = "Product 1",
                    presentation = "20g",
                    img = "https://img.freepik.com/fotos-premium/botella-suero-vidrio-blanco-tarro-crema-bano-flores-orquideas-fondo-productos-cosmeticos-marca-maqueta-marca-productos-cosmeticos-spa_294132-1096.jpg?w=900"
                ),

                Product(
                    id = 2,
                    name = "Product 2",
                    presentation = "20g",
                    img = "https://img.freepik.com/fotos-premium/maqueta-botella-suero-o-aceite-esencial-flores-orquideas-fondo-productos-cosmeticos-piel-belleza-natural-spa-casa-frasco-gotero_294132-1072.jpg"
                ),

                )
        )

        val brand2 = Brand(
            id = 2,
            name = "Brand 2",
            img = "https://img.freepik.com/fotos-premium/renderizacion-ilustracion-icono-aislado-refrescos-3d_541443-4708.jpg?semt=ais_hybrid",
            products = mutableListOf(
                Product(
                    id = 3,
                    name = "Product 3",
                    presentation = "20g",
                    img = "https://img.freepik.com/foto-gratis/refrescante-lata-refresco-frio-gotas-agua_53876-145620.jpg?semt=ais_hybrid"
                ),

                Product(
                    id = 4,
                    name = "Product 4",
                    presentation = "20g",
                    img = "https://img.freepik.com/foto-gratis/recogida-pajitas-plastico-lata_23-2148877870.jpg?semt=ais_hybrid"
                ),

                )
        )

        brands.add(brand1)
        brands.add(brand2)


        binding.recycler.setData(brands)


    }

    override fun onProductClick(product: Product, position: Int, view: View) {

        Log.d("Main Click", product.name)

    }
}