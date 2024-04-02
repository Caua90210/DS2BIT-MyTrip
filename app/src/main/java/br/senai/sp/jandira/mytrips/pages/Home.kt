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
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun Home(controleDeNavegacao: NavHostController) {

    var destinyState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xE6E4E2E2))
    ) {


        Box (
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        ){
            Image(painter = painterResource(id = R.drawable.paris), contentDescription = "foto de paris",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp, end = 20.dp),
                horizontalAlignment = Alignment.End

            ){
                Card (
                    modifier = Modifier.size(width = 70.dp, height = 70.dp),
                    border = BorderStroke(width = 2.dp, Color.White),
                    shape = CircleShape
                ) {
                    Image(painter = painterResource(R.drawable.ye), contentDescription = "", contentScale = ContentScale.Crop )

                }
                Text(text = "Ye",
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
                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "",
                            tint = Color.White,

                            )
                        Text(text = "You`re in Paris",
                            color = Color.White,
                            fontSize = 20.sp)

                    }


                    Text(text = "My Trips",
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

        Text(text = "Categories",
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
        ){
            item {
                Spacer(modifier = Modifier.width(14.dp))
            }

            items(1){


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

                    ){

                        Icon(painter = painterResource(id = R.drawable.cascata), contentDescription = "",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .size(width = 40.dp, height = 40.dp)
                                .offset(x = 0.dp, y = (12.dp))
                        )
                        Spacer(modifier = Modifier.height(13.dp))
                        Text(text = "Montain", color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold)

                    }



                }

                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .padding(horizontal = 6.dp),
                    colors = CardDefaults.cardColors(Color(0xFFEAABF4))

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){

                        Icon(painter = painterResource(id = R.drawable.skii), contentDescription = "",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .size(width = 40.dp, height = 40.dp)
                                .offset(x = 0.dp, y = (12.dp))
                        )
                        Spacer(modifier = Modifier.height(13.dp))
                        Text(text = "Snow", color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold)

                    }



                }




                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .padding(horizontal = 6.dp),
                    colors = CardDefaults.cardColors(Color(0xFFEAABF4))

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){

                        Icon(painter = painterResource(id = R.drawable.beach), contentDescription = "",
                            tint = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .size(width = 40.dp, height = 40.dp)
                                .offset(x = 0.dp, y = (12.dp))
                        )
                        Spacer(modifier = Modifier.height(13.dp))
                        Text(text = "Beach", color = Color(0xFFFFFFFF),
                            fontWeight = FontWeight.SemiBold)

                    }



                }



            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = destinyState.value, onValueChange = {
            destinyState.value = it
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            placeholder = {
                Text(text = "Search your destiny",
                    color = Color(0xFFA09C9C)

                )
            },
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "",
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

        Text(text = "Past Trips",
            modifier = Modifier
                .padding(start = 22.dp),
            fontSize = 16.sp,
            color = Color(0xFF565454)
        )
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(){
            items(1){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .padding(horizontal = 20.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFFFFFF))

                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {

                        Image(painter = painterResource(id = R.drawable.london), contentDescription = "", contentScale = ContentScale.Crop,

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)

                        )

                        Text(text = "London, 2019",

                            color = Color(0xFFCF06F0),
                            modifier = Modifier
                                .padding(start = 10.dp, bottom = 6.dp)


                        )

                        Text(text = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",

                            color = Color(0xFFA09C9C),
                            lineHeight = 16.sp,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 10.dp, bottom = 10.dp)
                        )

                        Text(text = "18 Feb - 21 Feb",
                            fontSize = 10.sp,
                            color = Color(0xFFCF06F0),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            textAlign = TextAlign.End


                        )

                    }


                }

                Spacer(modifier = Modifier.height(15.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .padding(horizontal = 20.dp),
                    colors = CardDefaults.cardColors(Color(0xFFFFFFFFF))

                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {

                        Image(painter = painterResource(id = R.drawable.porto), contentDescription = "", contentScale = ContentScale.Crop,

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)

                        )

                        Text(text = "Porto, 2022",

                            color = Color(0xFFCF06F0),
                            modifier = Modifier
                                .padding(start = 10.dp, bottom = 6.dp)


                        )

                        Text(text = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas.",

                            color = Color(0xFFA09C9C),
                            lineHeight = 16.sp,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 10.dp, bottom = 10.dp)
                        )

                        Text(text = "18 Feb - 21 Feb",
                            fontSize = 10.sp,
                            color = Color(0xFFCF06F0),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            textAlign = TextAlign.End


                        )

                    }


                }
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

