package com.example.primosmoveis

import com.google.gson.GsonBuilder
import java.io.Serializable


class Cadastro : Serializable {

    var id:Long = 0
    var insira_nome = ""
    var telefone_cliente = ""
    var telefone_cliente2 = ""
    var email_cliente = ""
    var interesse_cliente = ""

    override  fun toString(): String{
        return "Cliente(cliente='$insira_nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}