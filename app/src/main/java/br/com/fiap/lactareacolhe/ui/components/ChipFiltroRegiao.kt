package br.com.fiap.lactareacolhe.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.lactareacolhe.ui.theme.AzulClaro
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipFiltroRegiao(
    texto: String,
    ativo: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = ativo,
        onClick = onClick,
        label = { Text(texto) },
        modifier = modifier,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = AzulClaro,
            selectedLabelColor = AzulEscuro,
            labelColor = AzulEscuro
        )
    )
}

@Preview(showBackground = true, name = "Chips de filtro")
@Composable
private fun ChipFiltroRegiaoPreview() {
    LactareAcolheTheme {
        Row {
            ChipFiltroRegiao(texto = "Todos", ativo = true, onClick = {}, modifier = Modifier.padding(end = 8.dp))
            ChipFiltroRegiao(texto = "Zona Sul", ativo = false, onClick = {})
        }
    }
}
