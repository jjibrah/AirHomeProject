package com.Abdifatah.airhome

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
  lateinit var mWeb : WebView
  lateinit var mAuth: FirebaseAuth
  lateinit var bottomNavigationView: BottomNavigationView

  @RequiresApi(Build.VERSION_CODES.O)
  @SuppressLint("SetJavaScriptEnabled")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    mWeb = findViewById(R.id.mWebView)

    mAuth = FirebaseAuth.getInstance()
    bottomNavigationView = findViewById(R.id.bottomAppBar)
    bottomNavigationView.setOnItemReselectedListener {
      when(it.itemId){
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
    webViewSetup()
  }

  @SuppressLint("SetJavaScriptEnabled")
  @RequiresApi(Build.VERSION_CODES.O)
  private fun webViewSetup(){
    mWeb.webViewClient = WebViewClient()

    mWeb.apply {
      loadUrl("www.booking.com")
      settings.javaScriptEnabled = true
      settings.safeBrowsingEnabled = true

    }
  }

  override fun onBackPressed() {
    if(mWeb.canGoBack())
      mWeb.goBack()
    else super.onBackPressed()
  }
}