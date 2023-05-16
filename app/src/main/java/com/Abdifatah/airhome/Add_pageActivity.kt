package com.Abdifatah.airhome

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistryOwner
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
    private lateinit var mImage: String
    private lateinit var upload: Button
    private lateinit var Image: ImageButton
    private lateinit var db : DatabaseReference
    lateinit var mLocation : EditText
    lateinit var mPrice : EditText
    lateinit var mDetails : EditText
    lateinit var mOwner : EditText
    var storageRef = Firebase.storage
    lateinit var uri:Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_page)
        mLocation = findViewById(R.id.mEdtLocation)
        mPrice = findViewById(R.id.mEdtPrice)
        mDetails = findViewById(R.id.house_details)
        mOwner = findViewById(R.id.mEdtOwnerEmail)
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
            var location = mLocation.text.toString()
            var price = mPrice.text.toString()
            var details = mDetails.text.toString()
            var owner = mOwner.text.toString()
            var id = System.currentTimeMillis().toString()
            storageRef.getReference("Homes").child(id)
                .putFile(uri)
                .addOnSuccessListener { task ->
                    task.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener {
                            var userId = FirebaseAuth.getInstance().currentUser!!.uid

                            var homeData = Home(it.toString(),location, details, price, id)
                            var databaseReference = FirebaseDatabase.getInstance().getReference("Homes")
                            databaseReference.child("$userId/$id").setValue(homeData)
                                .addOnSuccessListener {
                                    Toast.makeText(this,"upload succcessful", Toast.LENGTH_SHORT).show()
                                    mLocation.setText("")
                                    mPrice.setText("")
                                    mDetails.setText("")
                                    mOwner.setText("")
                                    Image.setImageResource(R.drawable.add)
                                }.addOnFailureListener {error ->
                                    Toast.makeText(this,it.toString(), Toast.LENGTH_SHORT).show()

                                }
                        }
                }
        }
    }
}