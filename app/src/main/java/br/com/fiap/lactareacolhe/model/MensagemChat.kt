package br.com.fiap.lactareacolhe.model

data class MensagemChat(
    val id: Int,
    val texto: String,
    val isUsuario: Boolean,
    val opcoes: List<OpcaoChat> = emptyList()
)
