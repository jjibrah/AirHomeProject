package com.Abdifatah.airhome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var homeList: ArrayList<Homes>
  private lateinit var homeAdapter: HomeAdapter


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)


    recyclerView = findViewById(R.id.houses)
    recyclerView.setHasFixedSize(false)
    recyclerView.layoutManager = LinearLayoutManager(this)

    homeList = ArrayList()

    homeList.add(Homes(R.drawable.pic1, "Mombasa", "4000"))
    homeList.add(Homes(R.drawable.pic2, "Kisumu", "3800"))
    homeList.add(Homes(R.drawable.pic_new_1, "Malindi", "5000"))
    homeList.add(Homes(R.drawable.pic_new_2, "Watamu", "4500"))
    homeList.add(Homes(R.drawable.pic1, "Mombasa", "4000"))
    homeList.add(Homes(R.drawable.pic2, "Kisumu", "3800"))
    homeList.add(Homes(R.drawable.pic_new_1, "Malindi", "5000"))
    homeList.add(Homes(R.drawable.pic_new_2, "Watamu", "4500"))
    homeList.add(Homes(R.drawable.pic1, "Mombasa", "4000"))
    homeList.add(Homes(R.drawable.pic2, "Kisumu", "3800"))
    homeList.add(Homes(R.drawable.pic_new_1, "Malindi", "5000"))
    homeList.add(Homes(R.drawable.pic_new_2, "Watamu", "4500"))

    homeAdapter = HomeAdapter(homeList)
    recyclerView.adapter = homeAdapter
  }
}