package br.com.fiap.lactareacolhe.model

data class OpcaoChat(
    val rotulo: String,
    val proximaMensagem: String,
    val rota: String? = null
)
