package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNim)
        val spProdi = findViewById<Spinner>(R.id.spProdi)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbGaming = findViewById<CheckBox>(R.id.cbGaming)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        val prodiList = arrayOf("Informatika", "Sistem Informasi", "Teknik Elektro")
        spProdi.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, prodiList)

        btnSubmit.setOnClickListener {

            val nama = etNama.text.toString()
            val nim = etNim.text.toString()

            if (nama.isEmpty()) {
                etNama.error = "Nama wajib diisi"
                return@setOnClickListener
            }

            if (nim.isEmpty()) {
                etNim.error = "NIM wajib diisi"
                return@setOnClickListener
            }

            val prodi = spProdi.selectedItem.toString()

            val genderId = rgGender.checkedRadioButtonId
            val gender = if (genderId != -1) {
                findViewById<RadioButton>(genderId).text.toString()
            } else "Tidak dipilih"

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbGaming.isChecked) hobiList.add("Gaming")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hobi = if (hobiList.isNotEmpty()) hobiList.joinToString(", ") else "Tidak ada"

            val user = User(nama, nim, prodi, gender, hobi)

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("DATA_USER", user)
            startActivity(intent)
        }
    }
}