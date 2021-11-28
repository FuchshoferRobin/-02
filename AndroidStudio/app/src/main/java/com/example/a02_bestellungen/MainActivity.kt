package com.example.a02_bestellungen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun moveToBestellungen(view: View){
        val i = Intent(this, Bestellungen::class.java)
        startActivity(i)
    }
    fun moveToKategorien(view: View){
        val i = Intent(this, Kategorien::class.java)
        startActivity(i)
    }
    fun moveToKunden(view: View){
        val i = Intent(this, Kunden::class.java)
        startActivity(i)
    }
    fun moveToLieferanten(view: View){
        val i = Intent(this, Lieferanten::class.java)
        startActivity(i)
    }


}