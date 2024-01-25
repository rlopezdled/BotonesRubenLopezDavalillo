package com.example.botonesderubenlopezdavalillo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val numBotones = 10
    private lateinit var llBotonera: LinearLayout
    private var botonCorrecto: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBotonera = findViewById(R.id.llBotonera)
        //Creamos las propiedades de layout que tendrán los botones.
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_height)
        )

        botonCorrecto = Random.nextInt(numBotones)

        //Creamos los botones en bucle
        for (i in 0 until numBotones) {
            val button = Button(this)
            //Asignamos propiedades de layout al botón
            button.layoutParams = lp
            //Asignamos Texto al botón
            button.text = "Botón " + String.format("%02d", i)
            //Asignamos el Listener
            button.setOnClickListener(buttonClickListener(i))
            //Añadimos el botón a la botonera
            llBotonera.addView(button)
        }
    }

    private fun buttonClickListener(index: Int): View.OnClickListener {
        return View.OnClickListener {
            if (index == botonCorrecto) {
                Toast.makeText(this@MainActivity, "¡ME ENCONTRASTE!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Sigue buscando", Toast.LENGTH_SHORT).show()
            }
        }
    }
}