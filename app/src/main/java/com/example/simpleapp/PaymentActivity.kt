package com.example.simpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val btnBack = findViewById<Button>(R.id.buttonBack)
        val btnReissueReceipt = findViewById<Button>(R.id.buttonReissueReceipt)
        val tvAmount = findViewById<TextView>(R.id.textViewAmount)

        val amount = intent.getStringExtra("amount") ?: "$0.00"
        tvAmount.text = amount

        btnBack.setOnClickListener {
            finish()
        }

        btnReissueReceipt.setOnClickListener {
            val intent = Intent(this, ReissueReceiptActivity::class.java)
            intent.putExtra("amount", amount)
            startActivity(intent)
        }
    }
}
