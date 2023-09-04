package com.example.submissiongames

import  android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games (
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable