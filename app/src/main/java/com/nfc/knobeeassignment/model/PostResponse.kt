package com.nfc.knobeeassignment.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostResponse(
    var code: Int?,
    var `data`: Data?,
    var message: String?,
    var status: String?
)