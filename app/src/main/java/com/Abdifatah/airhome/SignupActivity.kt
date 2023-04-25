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
    lateinit var binding: ActivitySignupBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.mBtnSignup.setOnClickListener {
            var name = binding.mEdtName.text.toString()
            var Email = binding.mEdtEmail.text.toString()
            var password = binding.mEdtPass.text.toString()
            var confirm = binding.mEdtPassword.text.toString()

            if(name.isNotEmpty()&& Email.isNotEmpty()&& password.isNotEmpty()&&confirm.isNotEmpty()){
                if(password == confirm){
                    firebaseAuth.createUserWithEmailAndPassword(Email , password).addOnCompleteListener {
                        if (it.isSuccessful){
                            var intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "account created successfully !!!", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Passwords do not match !!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Field Cannot be empty", Toast.LENGTH_LONG).show()
                }
            }
            binding.mTvLog.setOnClickListener {
                var loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }
        }
    }
}