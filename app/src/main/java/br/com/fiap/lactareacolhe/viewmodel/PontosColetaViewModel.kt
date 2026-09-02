package br.com.fiap.lactareacolhe.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fiap.lactareacolhe.data.Constants
import br.com.fiap.lactareacolhe.model.PontoColeta
import br.com.fiap.lactareacolhe.repository.LactareRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PontosColetaViewModel : ViewModel() {

    private val repository = LactareRepository()

    private val todosOsPontos = repository.getPontosColeta()

    val zonas: List<String> = repository.getZonas()

    private val _filtroSelecionado = MutableStateFlow(Constants.FILTRO_TODOS)
    val filtroSelecionado: StateFlow<String> = _filtroSelecionado.asStateFlow()

    private val _pontosFiltrados = MutableStateFlow(todosOsPontos)
    val pontosFiltrados: StateFlow<List<PontoColeta>> = _pontosFiltrados.asStateFlow()

    fun filtrarPorZona(zona: String) {
        _filtroSelecionado.value = zona
        _pontosFiltrados.value =
            if (zona == Constants.FILTRO_TODOS) todosOsPontos
            else todosOsPontos.filter { it.zona == zona }
    }
}
