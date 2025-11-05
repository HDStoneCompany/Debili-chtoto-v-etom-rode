package com.example.getfixedboy

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val findCaliber = findViewById<Button>(R.id.button)
        findCaliber.setOnClickListener {
            val caliberColor = findViewById<Spinner>(R.id.rounds_types)
            val color = caliberColor.selectedItem
            val caliberList = getCalibers(color.toString())
            val calibers = caliberList.reduce {str, item -> str + '\n' + item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = calibers
        }
    }
        fun getCalibers(color: String): List<String> {
            return when (color){
                ".308 Winchester" -> listOf("jail pale ale", "lager lite")
                ".338 Lapua Magnum" -> listOf("jack amber", "red moose")
                ".408 CheyTac" -> listOf("brown bear beer", "bock brownie")
                ".50 BMG" -> listOf("BLUUGAUHH")
                else -> listOf("gout stout", "dark daniel")
            }
        }
    }
