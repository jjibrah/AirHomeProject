package com.Abdifatah.airhome

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.Abdifatah.airhome.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class Add_pageActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mImage: String
    private lateinit var upload: Button
    private lateinit var Image: ImageButton
    private lateinit var db : DatabaseReference
    lateinit var mLocation : EditText
    var storageRef = Firebase.storage
    lateinit var uri:Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mLocation = findViewById(R.id.mEdtLocation)
        storageRef = FirebaseStorage.getInstance()
        Image = findViewById(R.id.mAddImage)
        upload = findViewById(R.id.mBtnPost)


        var image = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback{
                Image.setImageURI(it)
                uri = it!!
            })

        Image.setOnClickListener {
            image.launch("image/*")
        }

        upload.setOnClickListener {
            storageRef.getReference("images").child(System.currentTimeMillis().toString())
                .putFile(uri)
                .addOnSuccessListener { task ->
                    task.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener {
                            var userId = FirebaseAuth.getInstance().currentUser!!.uid

                            var mapImage = mapOf(
                                "url" to it.toString()
                            )
                            var databaseReference = FirebaseDatabase.getInstance().getReference("userimages")
                            databaseReference.child(userId).setValue(mapImage)
                                .addOnSuccessListener {
                                    Toast.makeText(this,"upload succcessful", Toast.LENGTH_SHORT).show()
                                }.addOnFailureListener {error ->
                                    Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()

                                }
                        }
                }
        }
    }
}