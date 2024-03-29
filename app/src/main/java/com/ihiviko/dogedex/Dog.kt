package com.ihiviko.dogedex

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val id: Long,
    val index: Int,
    val name: String, //le agregamos field para que no aparescan null
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String
) : Parcelable
