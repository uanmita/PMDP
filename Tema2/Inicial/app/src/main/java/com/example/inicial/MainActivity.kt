package com.example.inicial

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicial.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.time.Duration.Companion.hours
import kotlin.time.times

//Lógica de una pantalla --> Activity

    class MainActivity : AppCompatActivity() {
            private lateinit var binding: ActivityMainBinding
            private var isRunning = false

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                setupClickListeners()
            }

            private fun setupClickListeners() {
                binding.botonStart.setOnClickListener {
                    if (isRunning) {
                        stopChronometer()
                    } else {
                        startChronometer()
                    }
                }

                binding.botonreset.setOnClickListener {
                    resetChronometer()
                }
            }

            private fun startChronometer() {
                binding.crono.start()
                isRunning = true
                binding.botonStart.text = "Stop"
            }

            private fun stopChronometer() {
                binding.crono.stop()
                isRunning = false
                binding.botonStart.text = "Start"
            }

            private fun resetChronometer() {
                binding.crono.base = SystemClock.elapsedRealtime()
                if (isRunning) {
                    stopChronometer()
                }



                }
    }













