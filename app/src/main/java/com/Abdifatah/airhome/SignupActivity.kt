package com.Abdifatah.airhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.Abdifatah.airhome.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    //Initiate the variables.
    lateinit var binding: ActivitySignupBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get Instance for the firebase authentication.
        firebaseAuth=FirebaseAuth.getInstance()

        //Set on click listeners for the signup button.
        binding.mBtnSignup.setOnClickListener {
            var name = binding.mEdtName.text.toString()
            var Email = binding.mEdtEmail.text.toString()
            var password = binding.mEdtPass.text.toString()
            var confirm = binding.mEdtPassword.text.toString()

            // Do some Validations to ensure that there are no empty spaces.
            if(name.isNotEmpty()&& Email.isNotEmpty()&& password.isNotEmpty()&&confirm.isNotEmpty()){


               // Provide the code that will check if the password and the reentered password are the same
                if(password == confirm){


                    //Provide the firebase DB Authentication code to create an account
                    firebaseAuth.createUserWithEmailAndPassword(Email , password).addOnCompleteListener {
                        if (it.isSuccessful){

                            //Open the login page and toast a success message
                            var intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "account created successfully !!!", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Passwords do not match !!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                    //Toast a Fail message
                }else{
                    Toast.makeText(this, "Field Cannot be empty", Toast.LENGTH_LONG).show()
                }
            }


            //Provide the login access if a person has an account
            binding.mTvLog.setOnClickListener {
                var loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }
        }
    }
}