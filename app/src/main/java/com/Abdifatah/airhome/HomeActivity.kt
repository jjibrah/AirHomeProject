package com.Abdifatah.airhome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var homeList: ArrayList<Homes>
  private lateinit var homeAdapter: HomeAdapter
  lateinit var floatingActionButton: FloatingActionButton


  @SuppressLint("MissingInflatedId")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    floatingActionButton = findViewById(R.id.add_item)
    recyclerView = findViewById(R.id.houses)
    recyclerView.setHasFixedSize(false)
    recyclerView.layoutManager = LinearLayoutManager(this)

    homeList = ArrayList()

    homeList.add(Homes(R.drawable.pic1, "Mombasa", "4000"))
    homeList.add(Homes(R.drawable.pic2, "Kisumu", "3800"))
    homeList.add(Homes(R.drawable.pic_new_1, "Malindi", "5000"))
    homeList.add(Homes(R.drawable.pic_new_2, "Watamu", "4500"))

    homeAdapter = HomeAdapter(homeList)
    recyclerView.adapter = homeAdapter

    homeAdapter.onItemClick = {
      var intent = Intent(this,DetailActivity::class.java)
      intent.putExtra("home", it)
      startActivity(intent)
    }
    floatingActionButton.setOnClickListener {
      var go = Intent(this,Add_pageActivity::class.java)
      startActivity(go)

    }

  }
}