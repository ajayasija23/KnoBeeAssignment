package com.nfc.knobeeassignment.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    var Gallery: List<List<Gallery>>
)