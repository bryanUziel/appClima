package com.example.appclima

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

class Network {
    companion object{
        fun conexion(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netkorkInfo = connectivityManager.activeNetworkInfo
            return netkorkInfo != null && netkorkInfo.isConnected

        }
    }
}