package com.example.primosmoveis

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.net.URL

object Cadastro_Cliente {
    val host = "http://jeffersonximenes.pythonanywhere.com/"
    val TAG = "Primosmoveis"

    fun getCliente(context: Context): List<Cadastro> {
        var cliente = ArrayList<Cadastro>()
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/cliente"
            val json = HttpHelper.get(url)
             cliente = parserJson(json)
            return parserJson(json)
        } else {
            return ArrayList<Cadastro>()
        }
    }

    fun save(cliente: Cadastro): Response {
        val json = HttpHelper.post("$host/cliente", cliente.toJson())
        return parserJson(json)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
