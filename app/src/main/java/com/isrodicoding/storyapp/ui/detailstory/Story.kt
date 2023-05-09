package com.isrodicoding.storyapp.ui.detailstory

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Story(
    var user: String? = null,
    var photo: String? = null,
    var description: String? = null
) : Parcelable