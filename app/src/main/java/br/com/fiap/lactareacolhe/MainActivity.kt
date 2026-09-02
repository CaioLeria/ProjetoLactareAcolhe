package br.com.fiap.lactareacolhe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.lactareacolhe.navigation.AppNavigation
import br.com.fiap.lactareacolhe.ui.theme.FundoClaro
import br.com.fiap.lactareacolhe.ui.theme.LactareAcolheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LactareAcolheTheme {
                Surface(modifier = Modifier.fillMaxSize().background(FundoClaro)) {
                    AppNavigation()
                }
            }
        }
    }
}
