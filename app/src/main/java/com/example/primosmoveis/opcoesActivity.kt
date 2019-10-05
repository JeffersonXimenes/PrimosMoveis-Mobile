package com.example.primosmoveis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_opcoes.*
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat



class opcoesActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcoes)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cadastrar_cliente.setOnClickListener {tela_cadastro()}
    }




    fun tela_cadastro(){
        val intent = Intent(this, cadastroActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 1000)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
    }

}
