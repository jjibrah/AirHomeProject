package com.Abdifatah.airhome

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.Abdifatah.airhome.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    //Initiate the variables
    lateinit var binding: ActivityLoginBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate((layoutInflater))
        setContentView(binding.root)

        //Get Firebase Authentication Instance
        firebaseAuth = FirebaseAuth.getInstance()



        // Set on click listener
        binding.mBtnLoginHome.setOnClickListener {
            var Email = binding.mEdtEmail.text.toString()
            var Password = binding.mEdtPassword.text.toString()



            // Check to Validate if there are any empty fields
            if (Email.isNotEmpty() && Password.isNotEmpty()) {



                //If the credentials are correct open the home page
                firebaseAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        var intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Field cannot be empty",Toast.LENGTH_SHORT).show()
            }
        }

        // Create a way to access the signup page if there one has no account
        binding.mTvSignUp.setOnClickListener {
            var signupIntent = Intent(this, SignupActivity::class.java)
            startActivity(signupIntent)
            finish()
        }
    }
}