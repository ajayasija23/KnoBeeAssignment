package com.nfc.knobeeassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KnoBee:Application() {

    override fun onCreate() {
        super.onCreate()
    }
}