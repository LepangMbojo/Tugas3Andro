package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val user = if (android.os.Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("DATA_USER", User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<User>("DATA_USER")
        }

        if (user == null) {
            finish()
            return
        }

        findViewById<TextView>(R.id.tvNama).text = "Nama: ${user.nama}"
        findViewById<TextView>(R.id.tvNim).text = "NIM: ${user.nim}"
        findViewById<TextView>(R.id.tvProdi).text = "Prodi: ${user.prodi}"
        findViewById<TextView>(R.id.tvGender).text = "Gender: ${user.gender}"
        findViewById<TextView>(R.id.tvHobi).text = "Hobi: ${user.hobi}"
    }
}