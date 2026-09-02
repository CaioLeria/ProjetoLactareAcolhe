package br.com.fiap.lactareacolhe.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.lactareacolhe.ui.screens.ApresentacaoScreen
import br.com.fiap.lactareacolhe.ui.screens.ChatScreen
import br.com.fiap.lactareacolhe.ui.screens.HomeScreen
import br.com.fiap.lactareacolhe.ui.screens.PontosColetaScreen
import br.com.fiap.lactareacolhe.ui.theme.AzulEscuro

private data class ItemBottomBar(
    val rota: String,
    val rotulo: String,
    val icone: ImageVector
)

private val itensBottomBar = listOf(
    ItemBottomBar(Rotas.HOME, "Início", Icons.Filled.Home),
    ItemBottomBar(Rotas.CHAT, "Chat", Icons.Filled.QuestionAnswer),
    ItemBottomBar(Rotas.PONTOS_COLETA, "Locais", Icons.Filled.Place)
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val rotaAtual = backStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (rotaAtual != Rotas.APRESENTACAO) {
                NavigationBar(containerColor = AzulEscuro) {
                    itensBottomBar.forEach { item ->
                        NavigationBarItem(
                            selected = rotaAtual == item.rota,
                            onClick = {
                                navController.navigate(item.rota) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icone,
                                    contentDescription = item.rotulo
                                )
                            },
                            label = { Text(text = item.rotulo) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = AzulEscuro,
                                selectedTextColor = Color.White,
                                unselectedIconColor = Color.White,
                                unselectedTextColor = Color.White,
                                indicatorColor = Color.White
                            )
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Rotas.APRESENTACAO,
            modifier = Modifier.padding(padding)
        ) {
            composable(Rotas.APRESENTACAO) {
                ApresentacaoScreen(navController = navController)
            }
            composable(Rotas.HOME) {
                HomeScreen(navController = navController)
            }
            composable(Rotas.CHAT) {
                ChatScreen(navController = navController)
            }
            composable(Rotas.PONTOS_COLETA) {
                PontosColetaScreen()
            }
        }
    }
}
