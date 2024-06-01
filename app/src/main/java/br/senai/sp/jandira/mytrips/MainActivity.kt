package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.pages.FormularioViagem
import br.senai.sp.jandira.mytrips.pages.Home
import br.senai.sp.jandira.mytrips.pages.SignUp
import br.senai.sp.jandira.mytrips.pages.login
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val controleDeNavegacao = rememberNavController()
                    NavHost(navController = controleDeNavegacao, startDestination = "login") {
                        composable(route = "login") { login(controleDeNavegacao) }
                        composable(route = "signup") { SignUp(controleDeNavegacao) }
                        composable(route = "home/{usuarioID}") { backStackEntry ->
                            val nomeUsuario = backStackEntry.arguments?.getString("usuarioID") ?: ""
                            Home(controleDeNavegacao, nomeUsuario)
                        }
                        composable(route = "cadastro") { FormularioViagem(controleDeNavegacao) }
                    }
                }
            }
        }
    }
}
