package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvClima:TextView? = null
    var tvHumedad:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.textViewCiudad)
        tvClima = findViewById(R.id.textViewClima)
        tvGrados = findViewById(R.id.textViewGrados)
        tvHumedad = findViewById(R.id.textViewHumedad)

        val ciudad = intent.getStringExtra("com.example.appclima.ciudades.CIUDAD")

        if(Network.conexion(this)){
            solicitudHttpVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=57c49643ea4ed643f02b9be3101e3e58&units=metric&lang=es")
        }else{
            Toast.makeText(this,"No hay red",Toast.LENGTH_SHORT).show()
        }
    }
    //Metodo para volley
    private fun solicitudHttpVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET,url, Response.Listener<String> {
                response ->
            try{
                Log.d("SolicitudHttpVolley",response)
                val gson = Gson()
                val ciudad = gson.fromJson(response,Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = ciudad.main?.temp.toString()+"°"
                tvClima?.text = ciudad.weather?.get(0)?.description
                tvHumedad?.text = ciudad.main?.humidity.toString()+"%"

            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
