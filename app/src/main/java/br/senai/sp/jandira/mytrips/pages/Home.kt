package br.senai.sp.jandira.mytrips.pages


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.reduzirData
import br.senai.sp.jandira.mytrips.repository.CategoriaRepository
import br.senai.sp.jandira.mytrips.repository.ViagemRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun Home(controleDeNavegacao: NavHostController) {

    val viagens = ViagemRepository().listarTodasAsViagens()
    val categoria = CategoriaRepository().listarTodasAsCategorias()

    var destinyState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xE6E4E2E2))
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
                        painter = painterResource(R.drawable.ye),
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
                            tint = Color.White,

                            )
                        Text(
                            text = "You`re in Paris",
                            color = Color.White,
                            fontSize = 20.sp
                        )

                    }


                    Text(
                        text = "My Trips",
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
            text = "Categories",
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

            items(categoria) {


                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .padding(horizontal = 6.dp),
                    colors = CardDefaults.cardColors(Color(0xFFCF06F0)),


                    ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Icon(
                            painter = if(it.image == null) painterResource(id = R.drawable.no_image) else it.image!! ,
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
                    text = "Search your destiny",
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
            text = "Past Trips",
            modifier = Modifier
                .padding(start = 22.dp),
            fontSize = 16.sp,
            color = Color(0xFF565454)
        )
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn() {
            items(viagens) {


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
                            Image(painter = if (it.image == null) painterResource(id = R.drawable.no_image) else it.image!!, contentDescription = "", contentScale = ContentScale.Crop )
                        }
                        Column(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text =  "${it.destino},  ${it.dataChegada.year}", color =  Color(0xFFCF06F0), fontSize = 18.sp )
                            Text(text = it.descricao, color =  Color(0xFF7A777A), modifier = Modifier.padding(vertical = 6.dp))
                            Text(text = "${reduzirData(it.dataChegada)} - ${reduzirData(it.dataPartida)}",  color =  Color(0xFFCF06F0), textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth()  )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))











            }


        }


    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    MyTripsTheme {

    }
}

