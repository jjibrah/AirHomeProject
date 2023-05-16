package com.Abdifatah.airhome

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeActivity : AppCompatActivity() {
  
  //Initiate the needed items
  private lateinit var recyclerView: ListView
  private lateinit var homeList: ArrayList<Home>
  private lateinit var homeAdapter: HomeAdapter
  lateinit var floatingActionButton: FloatingActionButton
  lateinit var mAuth: FirebaseAuth
  lateinit var dbref : DatabaseReference
  lateinit var bottomNavigationView: BottomNavigationView


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    floatingActionButton = findViewById(R.id.add_item)
    recyclerView = findViewById(R.id.houses)
    Toast.makeText(this, " ", Toast.LENGTH_SHORT).show()


    homeList = ArrayList()

    homeAdapter = HomeAdapter(this,homeList)
    var userId = FirebaseAuth.getInstance().currentUser!!.uid
    dbref = FirebaseDatabase.getInstance().getReference().child("Homes/")

    dbref.addValueEventListener(object : ValueEventListener{
      override fun onDataChange(snapshot: DataSnapshot) {
        for (homeSnapshot in snapshot.children){
          var home = homeSnapshot.getValue(Home::class.java)
          homeList.add(home!!)
          Log.d("mapicha", "onDataChange: "+home!!.image)
        }
        homeAdapter.notifyDataSetChanged()
      }

      override fun onCancelled(error: DatabaseError) {

      }

    })

    recyclerView.adapter = homeAdapter

    recyclerView.setOnItemClickListener { parent, view, position, id ->
      val intent = Intent(this,DetailActivity::class.java)
      intent.putExtra("home", homeList.get(position).image)
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

  }

}