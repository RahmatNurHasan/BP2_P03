package com.example.myamikomapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = intent.getStringExtra("EXTRA_USERNAME") ?: "Mahasiswa"
        val tvWelcome: TextView = findViewById(R.id.tv_welcome_message)
        val tvUser: TextView = findViewById(R.id.tv_username)
        tvUser.text = username

        findViewById<LinearLayout>(R.id.btn_matkul).setOnClickListener {
            Toast.makeText(this, "Fitur isi matkul dibuka!", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.btn_info).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://amikom.ac.id"))
            startActivity(intent)
        }
        findViewById<LinearLayout>(R.id.btn_ruang).setOnClickListener {
            Toast.makeText(this, "Menampilkan daftar ruang kampus...", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.btn_profile).setOnClickListener {
            Toast.makeText(this, "Fitur profil mahasiswa!", Toast.LENGTH_SHORT).show()
        }
        findViewById<LinearLayout>(R.id.btn_share).setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Coba aplikasi MyAmikomApp!")
            startActivity(Intent.createChooser(shareIntent, "Bagikan lewat"))
        }
        findViewById<LinearLayout>(R.id.btn_logout).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
