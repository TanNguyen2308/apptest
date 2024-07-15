package com.example.simpleapp
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReissueReceiptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reissue_receipt)

        val tvAmount = findViewById<TextView>(R.id.textViewReissueAmount)
        val amount = intent.getStringExtra("amount") ?: "$0.00"
        tvAmount.text = amount

        findViewById<Button>(R.id.buttonDone).setOnClickListener {
            finish()
        }



    }
}
