package br.com.fiap.lactareacolhe.model

data class PontoColeta(
    val id: Int,
    val nome: String,
    val endereco: String,
    val bairro: String,
    val zona: String,
    val telefone: String,
    val cep: String
)
