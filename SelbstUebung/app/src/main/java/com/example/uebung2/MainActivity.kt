package com.example.uebung2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.View
import android.widget.ListView
import com.example.uebung2.model.Department

import android.widget.TextView

import android.widget.ArrayAdapter
import android.widget.EditText
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.net.URL


class MainActivity : AppCompatActivity() {
    var departments: MutableList<Department> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get()
    }

    fun goToDepartmentActivity(view: View) {
        startActivity(Intent(this, DepartmentActivity::class.java))
    }

    fun gotToEmployeeActivity(view: View) {
        startActivity(Intent(this, EmployeeActivity::class.java))
    }

    fun gotToCustomerActivity(view: View) {
        startActivity(Intent(this, CustomerActivity::class.java))
    }

    fun gotToOrderActivity(view: View) {
        startActivity(Intent(this, OrderActivity::class.java))
    }

    fun test(view: View) {
        //i hof des geht oba es schaut guad aus

        //irgenda scheiß text der onzeigen soi
        val textView = findViewById<View>(R.id.textViewObject) as TextView
        textView.text = "text you want to display"

        updateListView()
    }

    fun add(view: View) {
        val editTextId = findViewById<View>(R.id.editTextId) as EditText
        val editTextName = findViewById<View>(R.id.editTextName) as EditText

        departments.add(
            Department(
                editTextId.text.toString().toInt(),
                editTextName.text.toString()
            )
        )

        updateListView()
        post(Department(editTextId.text.toString().toInt(), editTextName.text.toString()))
    }

    fun updateListView() {
        //liste
        val users = mutableListOf<String>()
        departments.forEach { x -> users.add(x.name) }

        var listView = findViewById<ListView>(R.id.listView)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listView.adapter = arrayAdapter
    }

    fun get() {
        var test = ""

        Fuel.get("http://10.0.2.2:7254/WeatherForecast/GetDepartments")
            .response { request, response, result ->
                test = String(response.data)
                //
                var shortText = test

                var dep = Gson().fromJson(shortText, Array<Department>::class.java)
                    .asList() as MutableList<Department>

                dep.forEach { x ->
                    departments.add(Department(x.id, x.name))
                }
            }
    }

    fun post(department: Department)
    {
        Fuel.post("http://10.0.2.2:7254/WeatherForecast/PostDepartments")
            .jsonBody("{ \"id\": ${department.id}, \"name\": \"${department.name}\" }")
            .also { println(it) }
            .response { result -> }
    }
}
