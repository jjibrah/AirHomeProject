package com.Abdifatah.airhome

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var homeList: ArrayList<Homes>
  private lateinit var homeAdapter: HomeAdapter
  lateinit var floatingActionButton: FloatingActionButton
  lateinit var mAuth: FirebaseAuth
  lateinit var bottomNavigationView: BottomNavigationView


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    floatingActionButton = findViewById(R.id.add_item)
    recyclerView = findViewById(R.id.houses)
    recyclerView.setHasFixedSize(false)
    recyclerView.layoutManager = LinearLayoutManager(this)

    homeList = ArrayList()

    homeAdapter = HomeAdapter(homeList)
    recyclerView.adapter = homeAdapter

    homeAdapter.onItemClick = {
      val intent = Intent(this,DetailActivity::class.java)
      intent.putExtra("home", it)
      startActivity(intent)
    }
    floatingActionButton.setOnClickListener {
      val go = Intent(this,Add_pageActivity::class.java)
      startActivity(go)

    }
    mAuth = FirebaseAuth.getInstance()
    bottomNavigationView = findViewById(R.id.bottomAppBar)
    bottomNavigationView.setOnItemSelectedListener {
      when(it.itemId){
        R.id.menuAccount -> {
          val go = Intent(this, ProfileActivity::class.java)
          startActivity(go)
        }

          R.id.menuHome -> {
          val intent = Intent(this,HomeActivity::class.java)
          startActivity(intent)
        }


        R.id.menuNotification -> {
          Toast.makeText(this,"Notification clicked",Toast.LENGTH_LONG).show()
          true
        }

        R.id.menuLogout -> {
          var alertDialog = AlertDialog.Builder(this)
          alertDialog.setTitle("Logging out!!!")
          alertDialog.setMessage("Are you sure you want to logout")
          alertDialog.setNegativeButton("No", null)
          alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            mAuth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
          })
          alertDialog.create().show()
          true
        }
      }
      true
    }

  } }