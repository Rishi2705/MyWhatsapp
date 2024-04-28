package com.example.mywhatsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splash_screen)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this,chats::class.java))
            finish()
        },1500)
    }
}