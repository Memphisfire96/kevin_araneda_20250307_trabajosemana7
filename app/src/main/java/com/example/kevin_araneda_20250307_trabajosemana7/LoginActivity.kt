package com.example.kevin_araneda_20250307_trabajosemana7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        //elementos de la interfaz

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        //obtener preferencias del usuario

        val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        if (sharedPref.contains("nombre")) {
            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }

        //configuración de botón para guardar el nombre

        btnGuardar.setOnClickListener {
            //Obtener el nombre ingresado por el usuario
            val nombre = etNombre.text.toString()
            //guardar el nombre en las preferencias de usuario
            sharedPref.edit().putString("nombre", nombre).apply()

            //Redirigir a la pantalla principal

            startActivity(Intent(this, InicioActivity::class.java))
            finish()
        }

        }
    }
