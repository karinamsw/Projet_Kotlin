package com.example.projetkotlin.Details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.R

public class DetailsMainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var mAdapter: ListAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

   // private var controller: MainController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView!!.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        val input: MutableList<String> = ArrayList()
        for (i in 1..10) {
            input.add("Test$i")
        } // define an adapter

        mAdapter = ListAdapter(input)
        recyclerView!!.setAdapter(mAdapter)

       /* controller = MainController(
            this,
            GsonBuilder().setLenient().create(),
            getSharedPreferences("application_elephant", Context.MODE_PRIVATE)
        )
        controller!!.onStart()

        */
    }

/*
    fun showList(elephantList: List<Elephant?>?) {
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView?
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager
        mAdapter = ListAdapter(elephantList as List<Elephant>, object : ListAdapter.OnItemClickListner() {
            override fun onItemClick(item: Elephant?) {
                controller!!.onItemClick(item)
            }
        })
        recyclerView!!.adapter = mAdapter
    }


    fun showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show()
    }

    fun navigateToDetails(elephant: Elephant?) {
        val myIntent = Intent(this.DetaislViewModel, DetailActivity::class.java)
        myIntent.putExtra("elephantKey", Singletons.getGson().toJson(elephant))
        this.DetailsViewModel.startActivity(myIntent)
    }

 */
}