package br.senai.sp.jandira.mytrips.pages

import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import kotlinx.coroutines.launch

@Composable
fun login(controleDeNavegacao: NavHostController?) {

    val emailState = remember {
        mutableStateOf("")
    }
    val senhaState = remember {
        mutableStateOf("")
    }

    val erroState = remember {
        mutableStateOf(false)
    }
    val mensagemErroState = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    val usuarios = UsuarioRepository(LocalContext.current).buscarPorEmailESenha(emailState.value, senhaState.value)

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
                    text = stringResource(id = R.string.login),
                    color = Color(0xFFCF06F0),
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = stringResource(id = R.string.please_sign_in_to_continue),
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
                    Text(text = stringResource(id = R.string.email))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF673AB7),
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedTextColor = Color(0xFF9C27B0),
                    unfocusedTextColor = Color(0xFF000000)
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0))
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
                    Text(text = stringResource(id = R.string.password))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF673AB7),
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedTextColor = Color(0xFF9C27B0),
                    unfocusedTextColor = Color(0xFF000000)
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFFCF06F0))
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
                        scope.launch {
                            if (usuarios != null) {
                                controleDeNavegacao?.navigate("home")
                            } else {
                                erroState.value = true
                                mensagemErroState.value = "Usuário e senha incorretos!"
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                    shape = RoundedCornerShape(13.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = stringResource(id = R.string.dont_have_an_account), color = Color(0xFFA09C9C))
                Text(
                    text = stringResource(id = R.string.sing_up), color = Color(0xFFCF06F0), fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { controleDeNavegacao?.navigate("signup") }
                )
            }



            AnimatedVisibility(
                visible = erroState.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 20.dp)
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(Color(0xFFCC0F0F))
                    ) {
                        Text(
                            text = mensagemErroState.value,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp).align(alignment = Alignment.CenterHorizontally)
                        )
                    }
                    LaunchedEffect(Unit) {
                        kotlinx.coroutines.delay(2000)
                        erroState.value = false
                    }
                }
            }

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
                    y = 770.dp
                )
                .size(width = 200.dp, height = 60.dp),
            colors = CardDefaults.cardColors(Color(0xFFCF06F0))
        ) {

        }
    }
}



