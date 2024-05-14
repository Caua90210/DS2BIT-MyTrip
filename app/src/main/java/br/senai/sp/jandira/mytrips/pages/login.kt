package br.senai.sp.jandira.mytrips.pages


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.repository.UsuariosRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun login(controleDeNavegacao: NavHostController?) {

    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }

    var erroState = remember {
        mutableStateOf(false)
    }
    var menssagemErroState = remember {
        mutableStateOf("")
    }

    val usuariosRepository = UsuariosRepository(LocalContext.current)

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Card(
                modifier = Modifier
                    .offset(
                        x = 260.dp,
                        y = (-10.dp)
                    )
                    .size(width = 200.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color(0xFFCF06F0))
            ) {

            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            Column {
                Text(
                    text = "Login",
                    color = Color(0xFFCF06F0),
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Black

                )
                Text(
                    text = "Please sign in to continue.",
                    color = Color(0xFFA09C9C)

                )
            }
            Spacer(modifier = Modifier.height(80.dp))

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "E-mail")
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xFF00FF7C),
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedTextColor = Color(0xFF910000),
                        unfocusedTextColor = Color(0xFF000000)
                    ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            OutlinedTextField(
                value = senhaState.value,
                onValueChange = {
                    senhaState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xFF00FF7C),
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedTextColor = Color(0xFF910000),
                        unfocusedTextColor = Color(0xFF000000)
                    ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0)
                    )
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {


                        val email = emailState.value
                        val senha = senhaState.value
                        if (usuariosRepository.verificarEmailSenha(email, senha)){
                            controleDeNavegacao!!.navigate("home")
                        } else {
                            erroState.value = true
                            menssagemErroState.value = "Usuário e senha incorretos!"
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "SIGN IN",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(Icons.Filled.ArrowForward, contentDescription = null)
                }
                Spacer(modifier = Modifier.height(23.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = "Don’t have an account?  ", color = Color(0xFFA09C9C))
                    Text(
                        text = "Sign up",
                        color = Color(0xFFCF06F0),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { controleDeNavegacao!!.navigate("signup") }
                    )
                }


            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                Card(
                    modifier = Modifier
                        .offset(
                            x = (-60.dp),
                            y = 120.dp
                        )
                        .size(width = 200.dp, height = 60.dp),
                    colors = CardDefaults.cardColors(Color(0xFFCF06F0))
                ) {

                }
            }
        }
    }}

