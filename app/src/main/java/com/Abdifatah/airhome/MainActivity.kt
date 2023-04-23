package com.Abdifatah.airhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnlogin:Button
    lateinit var btngetstarted:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnlogin = findViewById(R.id.mBtnLoginHome)
        btnlogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btngetstarted = findViewById(R.id.mBtnGetstarted)
        btngetstarted.setOnClickListener {
            var tembea = Intent(this, SignupActivity::class.java)
            startActivity(tembea)
        }
    }
}