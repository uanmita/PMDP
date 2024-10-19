package com.example.formulario

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginButton.setOnClickListener(this)
        binding.ClearButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.LoginButton.id -> {

                if (binding.userPass.text.isNotEmpty() && binding.userEntry.text.isNotEmpty()) {
                    // Intent con el contexto correcto
                    val intent = Intent(this, SecondActivity::class.java)

                    // Crear el bundle y pasar los datos
                    val bundle = Bundle()
                    bundle.putString("Usuario", binding.userEntry.text.toString())
                    intent.putExtra("Datos", bundle)

                    // Iniciar la nueva actividad
                    startActivity(intent)


                } else {
                    // Mostrar el mensaje de error si faltan datos
                    Snackbar.make(binding.root, "Faltan Datos", Snackbar.LENGTH_LONG).show()
                }
            }

            binding.ClearButton.id -> {
                limpiardatos()
           }
        }
   }

    fun limpiardatos() {
        binding.userEntry.text.clear()
        binding.userPass.text.clear()
    }


    override fun onRestart() {
        super.onRestart()
        limpiardatos()
    }
}





