package com.example.projetkotlin.Details

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlin.R
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
/*
    var txtDetail: TextView? = null
    var txtDetailFictional: TextView? = null
    var txtDetailId: TextView? = null
    var txtDetailAffiliation: TextView? = null
    var txtDetailDob: TextView? = null
    var txtDetailDod: TextView? = null
    var txtDetailIndex: TextView? = null
    var txtDetailNote: TextView? = null
    var txtDetailSex: TextView? = null
    var txtDetailSpecies: TextView? = null
    var txtDetailWikilink: TextView? = null
    var ImageDetail: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        txtDetail = findViewById<TextView>(R.id.detail_name)
        txtDetailFictional = findViewById<TextView>(R.id.detail_fictional)
        txtDetailId = findViewById<TextView>(R.id.detail_id)
        txtDetailAffiliation = findViewById<TextView>(R.id.detail_affiliation)
        txtDetailDob = findViewById<TextView>(R.id.detail_dob)
        txtDetailDod = findViewById<TextView>(R.id.detail_dod)
        txtDetailFictional = findViewById<TextView>(R.id.detail_fictional)
        txtDetailIndex = findViewById<TextView>(R.id.detail_index)
        txtDetailNote = findViewById<TextView>(R.id.detail_note)
        txtDetailSex = findViewById<TextView>(R.id.detail_sex)
        txtDetailSpecies = findViewById<TextView>(R.id.detail_species)
        txtDetailWikilink = findViewById<TextView>(R.id.detail_wikilink)
        ImageDetail = findViewById<ImageView>(R.id.icon)
        val intent: Intent = getIntent()
        val elephantJson = intent.getStringExtra("elephantKey")
        val elephant: Elephant = getGson().fromJson(elephantJson, Elephant::class.java)
        showDetail(elephant)
    }

    open fun showDetail(elephant: Elephant): Unit {
        txtDetail.setText(elephant.getName())
        txtDetailFictional!!.text = "Fictional : " + elephant.getFictional()
        txtDetailId!!.text = "Id : " + elephant.getId()
        txtDetailAffiliation!!.text = "Affiliation : " + elephant.getAffiliation()
        txtDetailDod!!.text = "Date of birth : " + elephant.getDob()
        txtDetailDob!!.text = "Date of death : " + elephant.getDod()
        txtDetailIndex!!.text = "Index : " + elephant.getIndex()
        txtDetailNote!!.text = "Note : " + elephant.getNote()
        txtDetailSex!!.text = "Sex : " + elephant.getSex()
        txtDetailSpecies!!.text = "Spices : " + elephant.getSpecies()
        txtDetailWikilink!!.text = "Wikilink : " + elephant.getWikilink()
        Picasso.get().load(elephant.getImage()).into(ImageDetail)
    }

 */
}