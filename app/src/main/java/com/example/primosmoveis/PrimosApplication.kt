package com.example.primosmoveis

import android.app.Application

import java.lang.IllegalStateException

class PrimosApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        // singleton
        private var appInstance: PrimosApplication?  = null
        fun getInstance(): PrimosApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}