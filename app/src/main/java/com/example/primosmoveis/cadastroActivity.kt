package com.example.primosmoveis

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import kotlinx.android.synthetic.main.toolbar.*
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_cadastro.*
import android.content.Context
import kotlinx.android.synthetic.main.toolbar.*
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler

class cadastroActivity : AppCompatActivity() {

    private val context: Context get() = this



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar()?.setHomeButtonEnabled(true);      //Ativa botão

        btn_cadastrar.setOnClickListener {
            val cadastro = Cadastro()
            cadastro.insira_nome = insira_nome.text.toString()
            cadastro.telefone_cliente = telefone_cliente.text.toString()
            cadastro.telefone_cliente2 = telefone_cliente2.text.toString()
            cadastro.email_cliente = email_cliente.text.toString()
            cadastro.interesse_cliente = interesse_cliente.text.toString()

            taskAtualizar(cadastro)
        }


    }

    private fun taskAtualizar(disciplina: Cadastro) {
        // Thread para salvar a discilpina
        Thread {
            Cadastro_Cliente.save(disciplina)
            runOnUiThread {
                Toast.makeText(context, "Cliente cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                // após cadastrar, voltar para activity anterior
                tela_concluido()
            }
        }.start()
    }
    fun tela_concluido(){
        val intent = Intent(this, opcoesActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 150)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
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

        if (item != null) {
            when (item.itemId) {
                android.R.id.home  //ID do BOTAO (POR PADRAO É HOME BB)
                -> {
                    startActivity(
                        Intent(
                            this,
                            opcoesActivity::class.java
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


        if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
