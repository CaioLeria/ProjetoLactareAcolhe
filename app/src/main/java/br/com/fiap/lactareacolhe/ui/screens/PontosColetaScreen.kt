package br.com.fiap.lactareacolhe.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.fiap.lactareacolhe.data.Constants
import br.com.fiap.lactareacolhe.model.PontoColeta
import br.com.fiap.lactareacolhe.ui.components.CardPontoColeta
import br.com.fiap.lactareacolhe.ui.components.ChipFiltroRegiao
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.FundoClaro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme
import br.com.fiap.lactareacolhe.viewmodel.PontosColetaViewModel

@Composable
fun PontosColetaScreen(
    viewModel: PontosColetaViewModel = viewModel()
) {
    val pontos by viewModel.pontosFiltrados.collectAsStateWithLifecycle()
    val filtroSelecionado by viewModel.filtroSelecionado.collectAsStateWithLifecycle()

    PontosColetaContent(
        pontos = pontos,
        zonas = viewModel.zonas,
        filtroSelecionado = filtroSelecionado,
        onFiltroSelecionado = viewModel::filtrarPorZona
    )
}

@Composable
fun PontosColetaContent(
    pontos: List<PontoColeta>,
    zonas: List<String>,
    filtroSelecionado: String,
    onFiltroSelecionado: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FundoClaro)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(zonas) { zona ->
                ChipFiltroRegiao(
                    texto = zona,
                    ativo = zona == filtroSelecionado,
                    onClick = { onFiltroSelecionado(zona) }
                )
            }
        }

        if (pontos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nenhum ponto de coleta nesta região",
                    style = MaterialTheme.typography.bodyLarge,
                    color = AzulEscuro
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(pontos, key = { it.id }) { ponto ->
                    CardPontoColeta(ponto)
                }
            }
        }
    }
}

private val pontosExemplo = listOf(
    PontoColeta(
        id = 1,
        nome = "Banco de Leite Humano Cachoeirinha",
        endereco = "Avenida Deputado Emílio Carlos, 3100",
        bairro = "Cachoeirinha",
        zona = "Zona Norte",
        telefone = "(11) 3986-1011",
        cep = "02720-200"
    ),
    PontoColeta(
        id = 2,
        nome = "Banco de Leite Humano da Santa Casa de São Paulo",
        endereco = "Rua Dr. Cesário Mota Júnior, 112",
        bairro = "Vila Buarque",
        zona = "Centro",
        telefone = "(11) 2176-7390",
        cep = "01221-020"
    )
)

@Preview(showBackground = true, name = "Pontos de coleta - lista")
@Composable
private fun PontosColetaContentPreview() {
    LactareAcolheTheme {
        PontosColetaContent(
            pontos = pontosExemplo,
            zonas = listOf(Constants.FILTRO_TODOS, "Centro", "Zona Norte", "Zona Sul"),
            filtroSelecionado = Constants.FILTRO_TODOS,
            onFiltroSelecionado = {}
        )
    }
}

@Preview(showBackground = true, name = "Pontos de coleta - estado vazio")
@Composable
private fun PontosColetaContentVazioPreview() {
    LactareAcolheTheme {
        PontosColetaContent(
            pontos = emptyList(),
            zonas = listOf(Constants.FILTRO_TODOS, "Centro", "Zona Norte", "Zona Sul"),
            filtroSelecionado = "Zona Norte",
            onFiltroSelecionado = {}
        )
    }
}
