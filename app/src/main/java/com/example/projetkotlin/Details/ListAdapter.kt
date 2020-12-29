package com.example.projetkotlin.Details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.R

class ListAdapter // Provide a suitable constructor (depends on the kind of dataset)
/*
internal constructor(
    private val values: MutableList<String>,
    private val listner: OnItemClickListner
) */
    (private val values: MutableList<String> ):
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    interface OnItemClickListner {
        fun onItemClick(item: Elephant?)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // each data item is just a string in this case
        var mImage = itemView.findViewById<ImageView>(R.id.icon)
        var txtHeader: TextView
        var txtFooter: TextView

        init {
            txtHeader = view.findViewById<View>(R.id.firstLine) as TextView
            txtFooter = view.findViewById<View>(R.id.secondLine) as TextView
        }
    }

    fun add(position: Int, item: String) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    private fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.list_object, parent, false)
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val name = values[position]
        holder.txtHeader.text = name
        holder.txtHeader.setOnClickListener(View.OnClickListener() {
            fun onClick(v: View?) {
                remove(position)
            }
        })
        holder.txtFooter.text = "Footer: $name"
       /* val currentElephant = values[position]
        //Picasso.get().load(currentElephant.Image()).resize(300, 300).into(holder.mImage)
        holder.txtHeader.setText(currentElephant.getName())
        holder.txtFooter.setText(currentElephant.getSex())
        holder.itemView.setOnClickListener { listner.onItemClick(currentElephant) }

        */
    }




    override fun getItemCount(): Int {
        return values.size
    }

}