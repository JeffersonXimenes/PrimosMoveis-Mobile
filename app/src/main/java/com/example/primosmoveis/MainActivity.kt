package com.example.primosmoveis

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeToLogin()
    }

    fun changeToLogin(){
        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
    }

}
