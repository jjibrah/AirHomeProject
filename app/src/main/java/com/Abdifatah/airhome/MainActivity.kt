package com.Abdifatah.airhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    // Initiate the variables on the page
    lateinit var btnlogin:Button
    lateinit var btngetstarted:Button
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Give btnLogin variable the id of the specific button
        btnlogin = findViewById(R.id.mBtnLoginHome)
        //if the user is already logged in just let them pass to the home page to view the homes available
        mAuth = FirebaseAuth.getInstance()
        if (mAuth.currentUser != null){
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //Give btngetstarted variable the id of the specific button
        btngetstarted = findViewById(R.id.mBtnGetstarted)


        //start signing up activity
        btngetstarted.setOnClickListener {
            var tembea = Intent(this, SignupActivity::class.java)
            startActivity(tembea)
        }
    }
}