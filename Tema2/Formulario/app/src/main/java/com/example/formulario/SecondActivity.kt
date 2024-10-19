package com.example.formulario

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formulario.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var user: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el bundle y verificar si contiene los datos del usuario
        val bundleDatos: Bundle? = intent.extras?.getBundle("Datos")

        // Asignar el valor del usuario, o mostrar un mensaje por defecto si es nulo
        user = bundleDatos?.getString("Usuario") ?: "Sin datos usuario"

        // Mostrar el nombre del usuario en el TextView
        binding.userLogged.text = user
    }
}



