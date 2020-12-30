package com.example.projetkotlin.Details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject

class DetailsMainActivity : AppCompatActivity() {
    val elephantViewModel : ElephantViewModel by inject()



   // private var controller: MainController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        elephantViewModel.onStart(this)
        fun showList() {
            var recyclerView: RecyclerView = findViewById(R.id.recycler_view)
            var layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = layoutManager
            elephantViewModel.showList(elephantViewModel.eleph.value!!, recyclerView, layoutManager)

        }

        elephantViewModel.dataStatus.observe(this, Observer {
            when (it) {
                DataIsEmpty -> {
                    elephantViewModel.makeApiCall()
                }
                DataSetIsNotEmpty -> {
                    showList()
                }
            }
        })


        elephantViewModel.apiCallResul.observe(this, Observer {
            when (it) {
                ApiCallSuccess -> {
                    elephantViewModel.saveList(elephantViewModel.eleph.value!!, applicationContext)
                    showList()
                }
                ApiCallError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Erreur appelle API")
                        .setPositiveButton("OK"){ dialog, which ->  dialog.dismiss()}
                        .show()
                }
            }
        })

    }
}