package com.example.uebung2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class CustomerActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_activity)
    }

    fun goToNextActivity(view: View) {
        finish()
    }
}