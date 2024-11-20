package com.joelpigem.projectealumnesrepas_joelpigem

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.joelpigem.projectealumnesrepas_joelpigem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonArrow.setOnClickListener{
            val intent = Intent(applicationContext, MostrarAlumnesActivity::class.java)
            startActivity(intent)
        }

        val spinner: Spinner = binding.spinnerCurs
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.opcions_spinner, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        binding.buttonPlus.setOnClickListener{
            DataSource.alumnes.add(ItemsViewModel(R.drawable.jordanpole, binding.editTextNom.text.toString(), binding.editTextEdat.text.toString().toInt(), spinner.selectedItem.toString()))
            val textToast = ("Usuari " + binding.editTextNom.text.toString() + " afegit!")
            val toast = Toast.makeText(this, textToast, Toast.LENGTH_LONG)
            toast.show()
        }
    }
}