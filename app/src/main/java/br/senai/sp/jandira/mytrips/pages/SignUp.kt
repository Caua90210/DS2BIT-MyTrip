package br.senai.sp.jandira.mytrips.pages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Usuarios
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import coil.compose.rememberImagePainter


@Composable
fun SignUp(controleDeNavegacao: NavHostController) {

    var nameState = remember {
        mutableStateOf("")
    }
    var phoneState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var senhaState = remember {
        mutableStateOf("")
    }
    var checkState = remember {
        mutableStateOf(false)
    }
    var erroState = remember {
        mutableStateOf(false)
    }
    var mensagemErroState = remember {
        mutableStateOf("")
    }
    var imagemUri by remember { mutableStateOf<Uri?>(null) }
    val getContent = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            imagemUri = uri
        }
    }

    val usuariosRepository = UsuarioRepository(LocalContext.current)
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sing_up),
                    color = Color(0xFFCF06F0),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.create_a_new_account),
                    color = Color(0xFFA09C9C)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 95.dp)
                    .height(130.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(300.dp),
                    shape = CircleShape
                ) {
                    Button(
                        onClick = { getContent.launch("image/*") },
                        modifier = Modifier.fillMaxSize(),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        ) {
                            if (imagemUri != null) {
                                Image(
                                    painter = rememberImagePainter(imagemUri!!),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .zIndex(1f)

                                )
                            } else {
                                Image(
                                    painter = painterResource(id = R.drawable.ellipse),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .zIndex(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .zIndex(2f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.photo_add),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .zIndex(3f)
                                        .offset(x = 40.dp, y = 30.dp)
                                )
                            }
                        }
                    }
                }
            }




            OutlinedTextField(
                value = nameState.value,
                onValueChange = {
                    nameState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.username))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    unfocusedTextColor = Color(0xFF000000)
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(23.dp))
            OutlinedTextField(
                value = phoneState.value,
                onValueChange = {
                    phoneState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.phone))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF673AB7),
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    focusedTextColor = Color(0xFF9C27B0),
                    unfocusedTextColor = Color(0xFF000000)
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(23.dp))
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
                    unfocusedBorderColor = Color(0xFFCF06F0),
                    unfocusedTextColor = Color(0xFF000000)
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0),
                        modifier = Modifier.padding(start = 10.dp)
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
                    Text(text = stringResource(id = R.string.password))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFCF06F0),
                ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkState.value,
                    onCheckedChange = {
                        checkState.value = it
                    },
                    colors = CheckboxDefaults.colors(uncheckedColor = Color(0xFFCF06F0)),
                    modifier = Modifier.scale(1.5f)
                )
                Text(text = stringResource(id = R.string.over))
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        if (nameState.value.isBlank() || phoneState.value.isBlank() || emailState.value.isBlank() || senhaState.value.isBlank()) {
                            mensagemErroState.value = "Todos os campos devem ser preenchidos"
                            erroState.value = true
                        } else {

                            val novoUsuario = Usuarios(
                                nome = nameState.value,
                                phone = phoneState.value,
                                email = emailState.value,
                                password = senhaState.value,
                                imageUser = imagemUri
                            )
                            usuariosRepository.salvar(novoUsuario)
                            controleDeNavegacao.navigate("login")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                    shape = RoundedCornerShape(13.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(id = R.string.create_account),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    color = Color(0xFFA09C9C)
                )
                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = Color(0xFFCF06F0),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { controleDeNavegacao.navigate("login") }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Card(
                modifier = Modifier
                    .offset(
                        x = (-70.dp),
                        y = 70.dp
                    )
                    .size(width = 200.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color(0xFFCF06F0))
            ) {

            }
        }
    }
}}
@Composable
fun rememberImagePainter(imagemUri: Uri): Painter {
    return rememberImagePainter(imagemUri)
}
