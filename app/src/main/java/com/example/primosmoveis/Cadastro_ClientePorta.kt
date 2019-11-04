package com.example.primosmoveis

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro.*

class Cadastro_ClientePorta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        setTitle("Nova cliente de Porta")

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
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }

}

