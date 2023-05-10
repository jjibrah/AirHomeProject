package com.Abdifatah.airhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var homes = intent.getParcelableExtra<Homes>("home")
        if(homes != null){
            var location : TextView = findViewById(R.id.mTvLocation)
            var locationlogo : ImageView = findViewById(R.id.mImgLocation)
            var houseprice : TextView = findViewById(R.id.mTvPrice)
            var houseimage : ImageView = findViewById(R.id.mImgHouse)

            location.text = homes.location
            locationlogo.setImageResource(R.drawable.house_location_24)
            houseimage.setImageResource(homes.image)
            houseprice.text = homes.price
        }
    }
}