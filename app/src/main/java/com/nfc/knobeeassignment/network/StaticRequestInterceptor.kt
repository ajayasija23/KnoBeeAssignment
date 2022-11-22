package com.nfc.knobeeassignment.network

import com.nfc.knobeeassignment.util.log
import okhttp3.logging.HttpLoggingInterceptor


class StaticRequestInterceptor() : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
       message.log()
    }
}