package br.senai.sp.jandira.mytrips.pages

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.CategoriaRepository
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips.repository.ViagemRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import java.io.FileNotFoundException


@Composable
fun Home(controleDeNavegacao: NavHostController) {

    val context = LocalContext.current
    val viagens = ViagemRepository(LocalContext.current).listarTodasAsViagens()
    val categoria = CategoriaRepository().listarTodasAsCategorias()
    var destinyState = remember {
        mutableStateOf("")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    controleDeNavegacao.navigate("cadastro")
                },
                containerColor = Color(0xFFCF06F0)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add New Trip", tint = Color.White)
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xE6E4E2E2))
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "foto de paris",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, end = 20.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Card(
                        modifier = Modifier.size(width = 70.dp, height = 70.dp),
                        border = BorderStroke(width = 2.dp, Color.White),
                        shape = CircleShape
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ye),
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = "Ye",
                        color = Color.White,
                        modifier = Modifier
                            .padding(end = 30.dp, top = 5.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.offset(x = 0.dp, y = (8.dp))
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn, contentDescription = "",
                                tint = Color.White
                            )
                            Text(
                                text = stringResource(id = R.string.you_re_in_paris),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }

                        Text(
                            text = stringResource(id = R.string.my_trips),
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 26.sp,
                            modifier = Modifier
                                .padding(start = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(id = R.string.categories),
                modifier = Modifier
                    .padding(start = 22.dp),
                fontSize = 16.sp,
                color = Color(0xFF565454)
            )
            Spacer(modifier = Modifier.height(15.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.width(14.dp))
                }

                items(categoria) { it ->
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 6.dp),
                        colors = CardDefaults.cardColors(Color(0xFFCF06F0))
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = if (it.image == null) painterResource(id = R.drawable.no_image) else it.image!!,
                                contentDescription = "",
                                tint = Color(0xFFFFFFFF),
                                modifier = Modifier
                                    .size(width = 40.dp, height = 40.dp)
                                    .offset(x = 0.dp, y = (12.dp))
                            )
                            Spacer(modifier = Modifier.height(13.dp))
                            Text(
                                text = it.categoria, color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = destinyState.value, onValueChange = {
                    destinyState.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.search),
                        color = Color(0xFFA09C9C)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search, contentDescription = "",
                            tint = Color(0xFFA09C9C)
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFFFFFFFF),
                    unfocusedBorderColor = Color(0xFFFFFFFF),
                    focusedBorderColor = Color(0xFFFFFFFF)
                ),
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.past_trips),
                modifier = Modifier
                    .padding(start = 22.dp),
                fontSize = 16.sp,
                color = Color(0xFF565454)
            )
            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn() {
                items(viagens) { viagem ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .padding(horizontal = 16.dp),
                        colors = CardDefaults.cardColors(Color(0xFFFFFFFF))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(190.dp)
                            ) {
                                val context = LocalContext.current
                                val imageBitmap: ImageBitmap? = remember {
                                    try {
                                        viagem.image?.let { uri ->
                                            val inputStream = context.contentResolver.openInputStream(uri)
                                            val bitmap = BitmapFactory.decodeStream(inputStream)
                                            bitmap?.asImageBitmap()
                                        }
                                    } catch (e: FileNotFoundException) {
                                        e.printStackTrace()
                                        null
                                    }
                                }

                                imageBitmap?.let { bitmap ->
                                    Image(
                                        bitmap = bitmap,
                                        contentDescription = "Imagem da Viagem",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } ?: run {
                                    Image(
                                        painter = painterResource(R.drawable.no_image),
                                        contentDescription = "Imagem não disponível",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(text = "${viagem.destino},  ${viagem.dataChegada}", color = Color(0xFFCF06F0), fontSize = 18.sp)
                                Text(text = viagem.descricao, color = Color(0xFF7A777A), modifier = Modifier.padding(vertical = 6.dp))
                                Text(text = "${viagem.dataChegada} - ${viagem.dataPartida}", color = Color(0xFFCF06F0), textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun Image(bitmap: Bitmap?, contentDescription: String, contentScale: ContentScale) {
    bitmap?.let {
        androidx.compose.foundation.Image(
            bitmap = it.asImageBitmap(),
            contentDescription = contentDescription,
            contentScale = contentScale
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    MyTripsTheme {

    }
}
