package com.Abdifatah.airhome

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.email


class DetailActivity : AppCompatActivity() {
    lateinit var dbref : DatabaseReference
    lateinit var mImage : ImageView
    lateinit var mLocation : TextView
    lateinit var mPrice : TextView
    lateinit var mEmail : TextView
    lateinit var mContact : Button
    private val PERMISSION_CODE = 1000;
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mImage = findViewById(R.id.mHouse)
        mLocation = findViewById(R.id.mTvLocation)
        mPrice = findViewById(R.id.mPrice)
        mEmail = findViewById(R.id.mEdtOwnerEmail)
        mContact = findViewById(R.id.mBtnContact)


        mContact.setOnClickListener {
             email("$mEmail","Hi!!! I saw the AirBnB at $mLocation  and was really i was impressed and i would like to nook it for a week")
        }
    }
}
