package com.example.projetkotlin.Details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetkotlin.Domain.entity.Elephant
import com.example.projetkotlin.R
import okio.Utf8.size
import java.nio.file.Files.size

class ListAdapter (private val list: List<Elephant>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    // Provide a suitable constructor (depends on the kind of dataset)
/*
internal constructor(
    private val values: MutableList<String>,
    private val listner: OnItemClickListner
) (private val values: List<Elephant>):
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    interface OnItemClickListner {
        fun onItemClick(item: Elephant?)
    }


 */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // each data item is just a string in this case
        val mImage : ImageView
        val txtHeader: TextView
        val txtFooter: TextView

        init {
            txtHeader = view.findViewById(R.id.firstLine)
            txtFooter = view.findViewById(R.id.secondLine)
            mImage = itemView.findViewById(R.id.icon)
        }
    }
/*
    fun add(position: Int, item: String) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    private fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

 */

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

        val elephant : Elephant = list.get(position)
        //Picasso.get().load(currentElephant.Image()).resize(300, 300).into(holder.mImage)
        holder.txtHeader.text = elephant.name
        holder.txtFooter.text = elephant.sex
        holder.mImage.setImageResource(getCustomedIdentifier(holder, elephant.name!!))

    }


    override fun getItemCount(): Int {
        return list.size
    }

    fun getCustomedIdentifier(viewHolder: ViewHolder, title : String) : Int {

        val context : Context = viewHolder.itemView.context
        val namePoster : String? = "poster_"+title?.toLowerCase()?.replace(" ", "_")?.replace("'", "_")
        return context.resources.getIdentifier("drawable/"+namePoster, null, context.packageName);
    }




}