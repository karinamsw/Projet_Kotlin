package com.example.projetkotlin.Presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetkotlin.Presentation.Details.DetailsMainActivity
import com.example.projetkotlin.Presentation.Register.RegisterActivity
import com.example.projetkotlin.Presentation.Register.createError
import com.example.projetkotlin.Presentation.Register.createSuccess
import com.example.projetkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer as Observer1

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer1 {
            when(it){
                is LoginSuccess ->{
                    navigateUserDetails()
                }
                LoginErrorUser -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Utilisateur inexisatnt. Veuillez en creer un")
                        .setPositiveButton("OK"){ dialog, which ->  dialog.dismiss()}
                        .show()
                }
            }
        })

        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString() )
        }
/*
        mainViewModel.createData.observe(this, androidx.lifecycle.Observer {
            when(it){
                is createSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("success")
                        .setMessage("Creation nouveau utilisateur")
                        .setPositiveButton("OK"){ dialog, which ->  dialog.dismiss()}
                        .show()
                }
                createError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Utilisateur déjà existant")
                        .setPositiveButton("OK"){ dialog, which ->  dialog.dismiss()}
                        .show()
                }
            }
        })

 */


        create_account_button.setOnClickListener{
            //mainViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }



    }



    private fun navigateUserDetails() {
        val intent = Intent(this@MainActivity, DetailsMainActivity::class.java)
        startActivity(intent)

    }

}