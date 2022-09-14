package com.ray.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var num1: EditText? = null
    private var num2: EditText? = null
    private var sum: Button? = null
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //essa linha aqui está vinculando o arquivo xml de tela, com a minha classe

        // precisa referenciar as views, tbm é possível utilizar bibliotecas, mas o padrão é o comando findviewById,
        num1 = findViewById(R.id.num1)
        num2 = findViewById<EditText>(R.id.num2)
        sum = findViewById<Button>(R.id.btnSoma)
        result = findViewById<TextView>(R.id.tvResultado)

        sum?.setOnClickListener {
            val valor1 = num1?.text.toString().toInt()
            val valor2 = num2?.text.toString().toInt()
            result.text = "Resultado: ${valor1 + valor2}"
        }

        findViewById<Button>(R.id.btnTela2).setOnClickListener {
            val intent = Intent(MainActivity@this, Tela2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        result.text = ""
    }
}