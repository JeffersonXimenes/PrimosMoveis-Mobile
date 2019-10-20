package com.example.primosmoveis

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_opcoes.*
import kotlinx.android.synthetic.main.toolbar.*
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class opcoesActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcoes)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cadastrar_cliente.setOnClickListener {tela_cadastro()}


        sair_cliente.setOnClickListener {sairDoAplicativo()}


    }
    fun sairDoAplicativo() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Até logo ❤");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    // aqui comeca mesmo
    //
    /// aqui come
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar

        menuInflater.inflate(R.menu.menu_main, menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_configuracoes)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado

        if (item != null) {
            when (item.itemId) {
                android.R.id.home  //ID do BOTAO (POR PADRAO É HOME BB)
                -> {
                    startActivity(
                        Intent(
                            this,
                            LoginActivity::class.java
                        )
                    )
                    finishAffinity()
                }
                else -> {
                }
            }
        }
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem Toast na tela
        // a comparação é feita com o recurso de id definido no xml

        if (id == R.id.action_configuracoes) {
            Toast.makeText(context, "Botão de atualizar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


// aqui encerra
// dadadad
    ///dadadadadadadadad
    //adadadadada

    // botao de voltar





    //


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


