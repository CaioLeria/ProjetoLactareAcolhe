package br.com.fiap.lactareacolhe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.lactareacolhe.model.MensagemChat
import br.com.fiap.lactareacolhe.model.OpcaoChat
import br.com.fiap.lactareacolhe.repository.LactareRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val repository = LactareRepository()

    private var contadorId = 0

    private val _historico = MutableStateFlow<List<MensagemChat>>(emptyList())
    val historico: StateFlow<List<MensagemChat>> = _historico.asStateFlow()

    private val _isDigitando = MutableStateFlow(false)
    val isDigitando: StateFlow<Boolean> = _isDigitando.asStateFlow()

    init {
        _historico.value = listOf(comNovoId(repository.getMensagemInicial()))
    }

    fun selecionarOpcao(opcao: OpcaoChat) {
        if (_isDigitando.value) return

        val falaUsuaria = MensagemChat(
            id = proximoId(),
            texto = opcao.rotulo,
            isUsuario = true
        )
        _historico.value = _historico.value + falaUsuaria
        _isDigitando.value = true

        viewModelScope.launch {
            delay(900)
            val resposta = comNovoId(repository.getRespostaBot(opcao.proximaMensagem))
            _historico.value = _historico.value + resposta
            _isDigitando.value = false
        }
    }

    private fun proximoId(): Int {
        contadorId += 1
        return contadorId
    }

    private fun comNovoId(mensagem: MensagemChat): MensagemChat = mensagem.copy(id = proximoId())
}
