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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.lactareacolhe.model.MensagemChat
import br.com.fiap.lactareacolhe.model.OpcaoChat
import br.com.fiap.lactareacolhe.ui.components.BalaoMensagemChat
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.FundoClaro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme
import br.com.fiap.lactareacolhe.ui.theme.Superficie
import br.com.fiap.lactareacolhe.viewmodel.ChatViewModel

@Composable
fun ChatScreen(
    navController: NavController,
    viewModel: ChatViewModel = viewModel()
) {
    val historico by viewModel.historico.collectAsStateWithLifecycle()
    val isDigitando by viewModel.isDigitando.collectAsStateWithLifecycle()

    ChatContent(
        historico = historico,
        isDigitando = isDigitando,
        onOpcaoSelecionada = { opcao ->
            viewModel.selecionarOpcao(opcao)
            opcao.rota?.let { rota -> navController.navigate(rota) }
        }
    )
}

@Composable
fun ChatContent(
    historico: List<MensagemChat>,
    isDigitando: Boolean,
    onOpcaoSelecionada: (OpcaoChat) -> Unit
) {
    val listState = rememberLazyListState()
    val idUltimaMensagemBot = historico.lastOrNull { !it.isUsuario }?.id

    LaunchedEffect(historico.size, isDigitando) {
        val total = historico.size + if (isDigitando) 1 else 0
        if (total > 0) {
            listState.animateScrollToItem(total - 1)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FundoClaro)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(historico, key = { it.id }) { mensagem ->
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    BalaoMensagemChat(mensagem)

                    val mostrarOpcoes = !mensagem.isUsuario &&
                        mensagem.id == idUltimaMensagemBot &&
                        !isDigitando &&
                        mensagem.opcoes.isNotEmpty()

                    if (mostrarOpcoes) {
                        mensagem.opcoes.forEach { opcao ->
                            Button(
                                onClick = { onOpcaoSelecionada(opcao) },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = AzulEscuro,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = opcao.rotulo)
                            }
                        }
                    }
                }
            }

            if (isDigitando) {
                item(key = "indicador_digitando") {
                    IndicadorDigitando()
                }
            }
        }
    }
}

@Composable
private fun IndicadorDigitando() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
        Surface(
            color = Superficie,
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 1.dp
        ) {
            Text(
                text = "digitando...",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = AzulEscuro
            )
        }
    }
}

private val historicoExemplo = listOf(
    MensagemChat(
        id = 1,
        texto = "Oi! Que bom ter você por aqui. Como você está agora?",
        isUsuario = false
    ),
    MensagemChat(
        id = 2,
        texto = "Quero saber mais",
        isUsuario = true
    ),
    MensagemChat(
        id = 3,
        texto = "Fico feliz com o seu interesse. Por onde começamos?",
        isUsuario = false,
        opcoes = listOf(
            OpcaoChat("Como doar", "como_doar"),
            OpcaoChat("Onde posso doar?", "onde_doar"),
            OpcaoChat("Tirar uma dúvida", "tirar_duvida")
        )
    )
)

@Preview(showBackground = true, name = "Chat - conversa com opções")
@Composable
private fun ChatContentPreview() {
    LactareAcolheTheme {
        ChatContent(
            historico = historicoExemplo,
            isDigitando = false,
            onOpcaoSelecionada = {}
        )
    }
}

@Preview(showBackground = true, name = "Chat - bot digitando")
@Composable
private fun ChatContentDigitandoPreview() {
    LactareAcolheTheme {
        ChatContent(
            historico = historicoExemplo,
            isDigitando = true,
            onOpcaoSelecionada = {}
        )
    }
}
