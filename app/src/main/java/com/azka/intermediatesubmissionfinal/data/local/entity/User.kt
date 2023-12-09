package com.azka.intermediatesubmissionfinal.data.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val userId: String,
    val name: String,
    val token: String
) : Parcelable
