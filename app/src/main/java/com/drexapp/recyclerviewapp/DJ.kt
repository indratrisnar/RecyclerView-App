package com.drexapp.recyclerviewapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DJ (
    val image: Int,
    val name: String,
    val genre: String
) : Parcelable