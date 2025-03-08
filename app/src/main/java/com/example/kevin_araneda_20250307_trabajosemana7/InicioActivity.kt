package com.example.kevin_araneda_20250307_trabajosemana7

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InicioActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //Obtener las preferencias compartidas donde se guarda el nombre ingresado por el usuario

        val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val nombre = sharedPref.getString("nombre", "Usuario")

        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        tvBienvenida.text = "Bienvenido: $nombre"

        // configuracion del boton para cerrar y limpiar las preferencias

        btnCerrarSesion.setOnClickListener {
            sharedPref.edit().clear().apply()
            finish()
        }

        // llamamos al metodo para cargar las farmacias desde la api

        cargarFarmacias()
    }

    //metodo para cargar las farmacias usando retrofit

    private fun cargarFarmacias() {
        RetrofitClient.instance.getFarmacias().enqueue(object : Callback<List<Farmacia>> {
            override fun onResponse(call: Call<List<Farmacia>>, response: Response<List<Farmacia>>) {
                if (response.isSuccessful) {
                    //si la respuesta es correcta , asigna el adaptador reciclerview
                    response.body()?.let {
                        recyclerView.adapter = FarmaciaAdapter(it)
                    }
                } else {
                    // si la respuesta no es correcta, mostrara el mensaje error
                    Toast.makeText(this@InicioActivity, "Error al cargar datos", Toast.LENGTH_SHORT).show()
                }
            }
            //metodo para manejar los fallos en la llamada a la api

            override fun onFailure(call: Call<List<Farmacia>>, t: Throwable) {
                Log.e("API_ERROR", "Error al obtener farmacias", t)
                Toast.makeText(this@InicioActivity, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
