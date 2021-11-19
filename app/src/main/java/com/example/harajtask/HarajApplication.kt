package com.example.harajtask

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class HarajApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}