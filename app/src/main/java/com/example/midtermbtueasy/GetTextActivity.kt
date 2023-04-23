package com.example.midtermbtueasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GetTextActivity : AppCompatActivity() {
    private lateinit var sendedNumberTextView: TextView
    private lateinit var sendedTextEditText: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_text)

        init()
        setGetedNumberAndMessage()
        setListeners()
    }

    private fun init(){
        sendedNumberTextView = findViewById(R.id.sendedNumberTextView)
        sendedTextEditText = findViewById(R.id.sendedTextEditText)
        clearButton = findViewById(R.id.clearButton)
    }

    private fun setGetedNumberAndMessage(){
        sendedNumberTextView.text = intent.getStringExtra("number")
        sendedTextEditText.setText(intent.getStringExtra("text"))
    }

    private fun setListeners(){
        clearButton.setOnClickListener {
            sendedNumberTextView.text = null
            sendedTextEditText.text = null
        }
    }
}