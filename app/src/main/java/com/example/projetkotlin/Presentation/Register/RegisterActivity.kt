package com.example.projetkotlin.Presentation.Register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.projetkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject
import java.util.Observer

class RegisterActivity : AppCompatActivity() {
    val registerViewModel: RegisterViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel.createData.observe(this, androidx.lifecycle.Observer {
            when (it) {
                is createSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("success")
                        .setMessage("Creation nouveau utilisateur")
                        .setPositiveButton("OK") { dialog, which -> dialog.dismiss() }
                        .show()
                }
                createError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Utilisateur déjà existant")
                        .setPositiveButton("OK") { dialog, which -> dialog.dismiss() }
                        .show()
                }
            }
        })

        submitButton.setOnClickListener{
            registerViewModel.onClickedCreate(email_text_field.text.toString().trim(), passwordTextField.text.toString())
        }
    }
}
