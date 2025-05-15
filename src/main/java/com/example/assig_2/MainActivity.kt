package com.example.assig_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn = findViewById<Button>(R.id.btnStart)

        startbtn.setOnClickListener {
            val intent =Intent(this,question::class.java)
            startActivity(intent)
        }

    }
}