package br.com.fiap.lactareacolhe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.lactareacolhe.model.PontoColeta
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme
import br.com.fiap.lactareacolhe.ui.theme.Superficie

@Composable
fun CardPontoColeta(ponto: PontoColeta, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Superficie)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = ponto.nome,
                style = MaterialTheme.typography.titleMedium,
                color = AzulEscuro
            )
            Text(
                text = "${ponto.bairro} · ${ponto.zona}",
                style = MaterialTheme.typography.labelLarge,
                color = AzulEscuro
            )
            Text(
                text = ponto.endereco,
                style = MaterialTheme.typography.bodyMedium,
                color = AzulEscuro
            )
            Text(
                text = "CEP ${ponto.cep}",
                style = MaterialTheme.typography.bodyMedium,
                color = AzulEscuro
            )
            Text(
                text = "Telefone: ${ponto.telefone}",
                style = MaterialTheme.typography.bodyMedium,
                color = AzulEscuro
            )
        }
    }
}

@Preview(showBackground = true, name = "Card de ponto de coleta")
@Composable
private fun CardPontoColetaPreview() {
    LactareAcolheTheme {
        CardPontoColeta(
            PontoColeta(
                id = 1,
                nome = "Banco de Leite Humano Cachoeirinha",
                endereco = "Avenida Deputado Emílio Carlos, 3100",
                bairro = "Cachoeirinha",
                zona = "Zona Norte",
                telefone = "(11) 3986-1011",
                cep = "02720-200"
            )
        )
    }
}
