package br.com.fiap.lactareacolhe.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.lactareacolhe.model.MensagemChat
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme
import br.com.fiap.lactareacolhe.ui.theme.Superficie

@Composable
fun BalaoMensagemChat(mensagem: MensagemChat, modifier: Modifier = Modifier) {
    val alinhamento = if (mensagem.isUsuario) Alignment.CenterEnd else Alignment.CenterStart
    val corDeFundo = if (mensagem.isUsuario) AzulEscuro else Superficie
    val corDoTexto = if (mensagem.isUsuario) Color.White else AzulEscuro
    val formato = if (mensagem.isUsuario) {
        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 4.dp)
    } else {
        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 4.dp, bottomEnd = 16.dp)
    }

    Box(modifier = modifier.fillMaxWidth(), contentAlignment = alinhamento) {
        Text(
            text = mensagem.texto,
            color = corDoTexto,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .widthIn(max = 300.dp)
                .clip(formato)
                .background(corDeFundo)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
    }
}

@Preview(showBackground = true, name = "Mensagem do bot")
@Composable
private fun BalaoMensagemChatBotPreview() {
    LactareAcolheTheme {
        BalaoMensagemChat(
            MensagemChat(
                id = 1,
                texto = "Oi! Que bom ter você por aqui. Como você está agora?",
                isUsuario = false
            )
        )
    }
}

@Preview(showBackground = true, name = "Mensagem da usuária")
@Composable
private fun BalaoMensagemChatUsuariaPreview() {
    LactareAcolheTheme {
        BalaoMensagemChat(
            MensagemChat(
                id = 2,
                texto = "Estou amamentando",
                isUsuario = true
            )
        )
    }
}
