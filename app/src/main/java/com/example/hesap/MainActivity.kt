package com.example.hesap

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextSayi1: EditText
    private lateinit var editTextSayi2: EditText
    private lateinit var textViewSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextSayi1 = findViewById(R.id.editTextSayi1)
        editTextSayi2 = findViewById(R.id.editTextSayi2)
        textViewSonuc = findViewById(R.id.textViewSonuc)

        findViewById<Button>(R.id.btnTopla).setOnClickListener { hesapla("topla") }
        findViewById<Button>(R.id.btnCikar).setOnClickListener { hesapla("cikar") }
        findViewById<Button>(R.id.btnCarp).setOnClickListener { hesapla("carp") }
        findViewById<Button>(R.id.btnBol).setOnClickListener { hesapla("bol") }
    }

    fun topla(s1: Double, s2: Double): Double {
        return s1 + s2
    }

    fun cikar(s1: Double, s2: Double): Double {
        return s1 - s2
    }

    fun carp(s1: Double, s2: Double): Double {
        return s1 * s2
    }

    fun bol(s1: Double, s2: Double): Double {
        return s1 / s2
    }

    private fun hesapla(islem: String) {
        val sayi1Text = editTextSayi1.text.toString()
        val sayi2Text = editTextSayi2.text.toString()

        if (sayi1Text.isEmpty() || sayi2Text.isEmpty()) {
            Toast.makeText(this, "Lütfen her iki sayıyı da giriniz!", Toast.LENGTH_SHORT).show()
            return
        }

        val sayi1 = sayi1Text.toDouble()
        val sayi2 = sayi2Text.toDouble()

        val sonuc = when (islem) {
            "topla" -> topla(sayi1, sayi2)
            "cikar" -> cikar(sayi1, sayi2)
            "carp" -> carp(sayi1, sayi2)
            "bol" -> {
                if (sayi2 == 0.0) {
                    Toast.makeText(this, "Lütfen bölme hatası!", Toast.LENGTH_SHORT).show()
                    return
                }
                bol(sayi1, sayi2)
            }
            else -> 0.0
        }

        textViewSonuc.text = sonuc.toString()
    }
}
