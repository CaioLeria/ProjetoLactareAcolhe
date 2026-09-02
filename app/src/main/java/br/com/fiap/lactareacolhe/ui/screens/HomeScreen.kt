package br.com.fiap.lactareacolhe.ui.screens

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.lactareacolhe.data.Constants
import br.com.fiap.lactareacolhe.navigation.Rotas
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.FundoClaro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme
import br.com.fiap.lactareacolhe.ui.theme.Superficie

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    HomeContent(
        onAbrirNoticia = { abrirLinkExterno(context, Constants.SITE_URL) },
        onAbrirWhatsApp = { abrirLinkExterno(context, "https://wa.me/${Constants.WHATSAPP_NUMERO}") },
        onAbrirChat = { navController.navigate(Rotas.CHAT) }
    )
}

@Composable
fun HomeContent(
    onAbrirNoticia: () -> Unit,
    onAbrirWhatsApp: () -> Unit,
    onAbrirChat: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FundoClaro)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Lactare Acolhe",
            style = MaterialTheme.typography.headlineMedium,
            color = AzulEscuro
        )
        Text(
            text = "Apoio de verdade para amamentar e para doar leite humano, sem pressa e sem julgamento.",
            style = MaterialTheme.typography.bodyLarge,
            color = AzulEscuro
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onAbrirNoticia),
            colors = CardDefaults.cardColors(containerColor = AzulEscuro)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Agosto Dourado",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    text = "O mês de incentivo à amamentação e à doação de leite humano. Toque para ler a campanha oficial.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Superficie)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Gostaria de conhecer o Lactare Acolhe e tirar suas dúvidas?",
                    style = MaterialTheme.typography.titleMedium,
                    color = AzulEscuro
                )
                Button(
                    onClick = onAbrirWhatsApp,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulEscuro,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Falar no WhatsApp")
                }
                OutlinedButton(
                    onClick = onAbrirChat,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Conversar aqui no app", color = AzulEscuro)
                }
            }
        }
    }
}

private fun abrirLinkExterno(context: Context, url: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(
            context,
            "Nenhum aplicativo disponível para abrir este link",
            Toast.LENGTH_SHORT
        ).show()
    }
}

@Preview(showBackground = true, name = "Home")
@Composable
private fun HomeContentPreview() {
    LactareAcolheTheme {
        HomeContent(
            onAbrirNoticia = {},
            onAbrirWhatsApp = {},
            onAbrirChat = {}
        )
    }
}
