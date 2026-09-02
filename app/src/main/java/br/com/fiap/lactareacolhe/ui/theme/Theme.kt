package br.com.fiap.lactareacolhe.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EsquemaDeCores = lightColorScheme(
    primary = AzulEscuro,
    onPrimary = Color.White,
    primaryContainer = AzulEscuro,
    onPrimaryContainer = Color.White,
    secondary = AzulClaro,
    onSecondary = AzulEscuro,
    secondaryContainer = AzulClaro,
    onSecondaryContainer = AzulEscuro,
    background = FundoClaro,
    onBackground = AzulEscuro,
    surface = Superficie,
    onSurface = AzulEscuro,
    surfaceVariant = FundoClaro,
    onSurfaceVariant = AzulEscuro
)

@Composable
fun LactareAcolheTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaDeCores,
        typography = Tipografia,
        content = content
    )
}
