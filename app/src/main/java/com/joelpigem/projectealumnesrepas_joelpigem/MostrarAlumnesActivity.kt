package com.joelpigem.projectealumnesrepas_joelpigem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.joelpigem.projectealumnesrepas_joelpigem.databinding.ActivityMostrarAlumnesBinding

class MostrarAlumnesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMostrarAlumnesBinding = DataBindingUtil.setContentView(this, R.layout.activity_mostrar_alumnes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //intent
        val intent = intent

        //Spinner
        val spinner: Spinner = binding.spinnerCurs
        val adapterSpinner = ArrayAdapter.createFromResource(
            this, R.array.opcions_spinner, android.R.layout.simple_spinner_item
        )
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapterSpinner

        //RecyclerView
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = LinearLayoutManager(this)

        //Boto Buscar
        binding.buttonBuscar.setOnClickListener{
            val llistarAlumnes = DataSource.carregarAlumnes()
            val valorSpinner = spinner.selectedItem.toString()

            val llistarAlumnesPerCurs = llistarAlumnes.filter { alumne ->
                alumne.curs == valorSpinner
            }

            val adapterRecycler = CustomAdapter(llistarAlumnesPerCurs)
            recyclerview.adapter = adapterRecycler
        }


        //Boto enrere
        binding.buttonBack.setOnClickListener{
            finish()
        }

    }
}