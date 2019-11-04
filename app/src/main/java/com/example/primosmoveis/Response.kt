package com.example.primosmoveis

data class Response (val status:String, val msg:String) {
    // verificar se o chamada foi executada com sucesso
    fun isOK() = "OK".equals(status, ignoreCase = true)
}