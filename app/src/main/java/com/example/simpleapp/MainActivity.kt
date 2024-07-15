package com.example.simpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvAmount: TextView
    private var amount: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAmount = findViewById(R.id.tvAmount)

        val buttons = listOf(
            findViewById<Button>(R.id.btn1), findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3), findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5), findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7), findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9), findViewById<Button>(R.id.btn0),
            findViewById<Button>(R.id.btn00), findViewById<Button>(R.id.btnDelete)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                when (val text = (it as Button).text.toString()) {
                    "C" -> if (amount.isNotEmpty()) amount = amount.dropLast(1)
                    else -> amount += text
                }
                updateAmount()
            }
        }

        findViewById<Button>(R.id.btnEnter).setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("amount", amount)
            startActivity(intent)
        }
    }

    private fun updateAmount() {
        tvAmount.text = if (amount.isEmpty()) "$0.00" else "$$amount"
    }
}
