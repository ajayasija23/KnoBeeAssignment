package com.nfc.knobeeassignment.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Gallery(
    var filename: String?
)