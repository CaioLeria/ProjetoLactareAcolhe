package br.com.fiap.lactareacolhe.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.lactareacolhe.model.PassoOnboarding
import br.com.fiap.lactareacolhe.navigation.Rotas
import br.com.fiap.lactareacolhe.repository.LactareRepository
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme

@Composable
fun ApresentacaoScreen(navController: NavController) {
    val repository = remember { LactareRepository() }
    ApresentacaoContent(
        passos = repository.getPassosOnboarding(),
        onFinalizar = {
            navController.navigate(Rotas.HOME) {
                popUpTo(Rotas.APRESENTACAO) { inclusive = true }
            }
        }
    )
}

@Composable
fun ApresentacaoContent(
    passos: List<PassoOnboarding>,
    onFinalizar: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { passos.size })
    val ultimaPagina = pagerState.currentPage == passos.lastIndex

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AzulEscuro)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = onFinalizar) {
                Text(text = "Pular", color = Color.White)
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { pagina ->
            val passo = passos[pagina]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = passo.titulo,
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = passo.texto,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            passos.indices.forEach { indice ->
                val selecionado = pagerState.currentPage == indice
                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(if (selecionado) 10.dp else 8.dp)
                        .clip(CircleShape)
                        .background(if (selecionado) Color.White else Color.White.copy(alpha = 0.4f))
                )
            }
        }

        if (ultimaPagina) {
            Button(
                onClick = onFinalizar,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = AzulEscuro
                )
            ) {
                Text(text = "Começar")
            }
        } else {
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Preview(showBackground = true, name = "Onboarding - primeira página")
@Composable
private fun ApresentacaoContentPreview() {
    LactareAcolheTheme {
        ApresentacaoContent(
            passos = listOf(
                PassoOnboarding(
                    titulo = "Bem-vinda ao Lactare Acolhe",
                    texto = "Um espaço para tirar dúvidas sobre amamentação e doação de leite humano, no seu tempo e sem julgamento."
                ),
                PassoOnboarding(
                    titulo = "Sua dúvida tem resposta",
                    texto = "Converse com a gente sobre pega, produção de leite, armazenamento e o que mais precisar saber."
                )
            ),
            onFinalizar = {}
        )
    }
}
