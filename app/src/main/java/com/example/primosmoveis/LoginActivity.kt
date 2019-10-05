package com.example.primosmoveis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.os.Handler
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {fazer_login()}

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(R.color.colorPrimary)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun Window.setStatusBarColor(color: Int) {
        this.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        this.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        this.statusBarColor = ContextCompat.getColor(baseContext, color)
    }

    fun fazer_login() {
        val insira_nome = findViewById<EditText>(R.id.insira_nome)
        val valor_nome = insira_nome.text.toString()
        val insira_senha = findViewById<EditText>(R.id.insira_senha)
        val valor_senha = insira_senha.text.toString()

        if (valor_senha=="impacta" && valor_nome=="aluno") {
            Toast.makeText(this, "Login Realizado" , Toast.LENGTH_LONG).show()
            proxima_tela()
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show()
        }
    }

    fun proxima_tela(){
        val intent = Intent(this, opcoesActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 1000)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
    }

}
