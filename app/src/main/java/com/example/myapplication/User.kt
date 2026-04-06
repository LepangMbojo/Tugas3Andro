package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nama: String,
    val nim: String,
    val prodi: String,
    val gender: String,
    val hobi: String
) : Parcelable