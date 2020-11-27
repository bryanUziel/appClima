package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ciudades : AppCompatActivity() {

    val TAG = "com.example.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val botonMiami = findViewById<Button>(R.id.botonMiami)
        val botonCdmx = findViewById<Button>(R.id.botonCdmx)
        val botonMoscu = findViewById<Button>(R.id.botonMoscu)
        botonMiami.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"4164138")
            startActivity(intent)
        })
        botonCdmx.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"3530597")
            startActivity(intent)
        })
        botonMoscu.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"524901")
            startActivity(intent)
        }
    }
}
