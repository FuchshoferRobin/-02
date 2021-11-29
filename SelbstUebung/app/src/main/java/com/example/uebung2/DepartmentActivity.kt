package com.example.uebung2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class DepartmentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.department_activity)
    }

    fun goToNextActivity(view: View) {
        finish()
    }
}