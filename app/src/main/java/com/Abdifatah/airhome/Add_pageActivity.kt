package com.Abdifatah.airhome

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Add_pageActivity : AppCompatActivity() {
    lateinit var mHouse : ImageButton
    lateinit var mLocation : EditText
    lateinit var mHouseDetails : EditText
    lateinit var mPrice : EditText
    lateinit var mEmail : EditText
    lateinit var mPost : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_page)
        mHouse = findViewById(R.id.house_image)
        mLocation = findViewById(R.id.house_location)
        mHouseDetails = findViewById(R.id.house_details)
        mPrice = findViewById(R.id.house_price)
        mEmail = findViewById(R.id.owner_email)
        mPost = findViewById(R.id.mBtnPost)


        //set onclick listeners for each of the items in the page and enable it to post it on firebase DB when post button is pressed
        mHouse.setOnClickListener {  }
        mLocation.setOnClickListener {  }
        mHouseDetails.setOnClickListener {  }
        mPrice.setOnClickListener {  }
        mEmail.setOnClickListener {  }
        mPost.setOnClickListener {  }
    }
}