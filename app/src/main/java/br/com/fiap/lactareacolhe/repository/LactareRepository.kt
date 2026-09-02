package br.com.fiap.lactareacolhe.repository

import br.com.fiap.lactareacolhe.data.Constants
import br.com.fiap.lactareacolhe.data.MockData
import br.com.fiap.lactareacolhe.model.MensagemChat
import br.com.fiap.lactareacolhe.model.PassoOnboarding
import br.com.fiap.lactareacolhe.model.PontoColeta

class LactareRepository {

    fun getPontosColeta(): List<PontoColeta> = MockData.pontosDeColeta

    fun getZonas(): List<String> {
        val zonas = MockData.pontosDeColeta
            .map { it.zona }
            .distinct()
            .sorted()
        return listOf(Constants.FILTRO_TODOS) + zonas
    }

    fun getPassosOnboarding(): List<PassoOnboarding> = MockData.passosOnboarding

    fun getMensagemInicial(): MensagemChat =
        MockData.roteiroChat.getValue(MockData.CHAVE_MENSAGEM_INICIAL)

    fun getRespostaBot(chave: String): MensagemChat =
        MockData.roteiroChat[chave] ?: MockData.roteiroChat.getValue(MockData.CHAVE_FALLBACK)
}
