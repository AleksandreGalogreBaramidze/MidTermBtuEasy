package com.example.midtermbtueasy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var senderNumberEditText: EditText
    private lateinit var sendTextEditText: EditText
    private lateinit var sendTextButton: Button
    private var senderNumber: String? = null
    private var senderText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setListeners()
    }

    private fun init(){
        senderNumberEditText = findViewById(R.id.sendNumberEditText)
        sendTextEditText = findViewById(R.id.sendTextEditText)
        sendTextButton = findViewById(R.id.sendTextButton)
    }

    private fun setListeners(){
        sendTextButton.setOnClickListener {
            checkIfFieldsAreEmpty()
            if(senderNumber != null && senderText != null){
                startActivity(Intent(this, GetTextActivity::class.java).apply {
                    putExtra("number", senderNumber)
                    putExtra("text", senderText)
                })
            }else{
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkIfFieldsAreEmpty(){
        if(senderNumberEditText.text.isNullOrEmpty()){
            senderNumber = null
            senderNumberEditText.error = "You forget to input Your Number"
        }else{
            senderNumber = senderNumberEditText.text.toString()
        }
        if(sendTextEditText.text.isNullOrEmpty()){
            senderText = null
            sendTextEditText.error = "You forget to input Your Number"
        }else{
            senderText = senderNumberEditText.text.toString()
        }
    }
}