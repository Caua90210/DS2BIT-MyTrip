package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}


@Composable
fun login(){
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ){
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
        ){
            Spacer(modifier = Modifier.height(120.dp))

            Column {
                Text(
                    text = "Login",
                    color = Color(0xFFCF06F0),
                    fontSize = 60.sp,
                    fontWeight = FontWeight.Black

                )
                Text(text = "Please sign in to continue.",
                    color = Color(0xFFA09C9C)

                )
            }
            Spacer(modifier = Modifier.height(80.dp))

            OutlinedTextField(
                value = "Digite seu e-mail",
                onValueChange = {},
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
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0))
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            OutlinedTextField(
                value = "Digite sua senha",
                onValueChange = {},
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
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFFCF06F0))
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                    shape = RoundedCornerShape(13.dp)

                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "SIGN IN",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16 .sp
                        )
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "")
                    }
                }

            }
            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.End

            ) {
                    Text(text = "Don’t have an account?  ", color = Color(0xFFA09C9C))
                    Text(text = "Sign up", color = Color(0xFFCF06F0), fontWeight = FontWeight.Bold)
            }



        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ){
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
}


@Composable
fun SignUp(){


    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ){
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
        ){
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFFCF06F0),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center


                )
                Text(text = "Create a new account",
                    color = Color(0xFFA09C9C)

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ){
                Image(painter = painterResource(id = R.drawable.ellipse), contentDescription = "",
                    modifier = Modifier
                        .size(width = 120.dp, height = 370.dp)
                )
                Image(painter = painterResource(id = R.drawable.profile), contentDescription = "",
                    modifier = Modifier
                        .size(width = 80.dp, height = 140.dp)

                )
                Image(painter = painterResource(id = R.drawable.photo_add), contentDescription = "",
                    modifier = Modifier
                        .size(width = 40.dp, height = 50.dp)
                        .offset(x = (45.dp), y = (40.dp))
                )

            }

            OutlinedTextField(
                value = "Digite seu nome",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Username")
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),

                        unfocusedTextColor = Color(0xFF000000)
                    ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "", tint = Color(0xFFCF06F0), modifier = Modifier.padding(start = 10.dp))
                }
            )
            Spacer(modifier = Modifier.height(23.dp))
            OutlinedTextField(
                value = "Digite seu número",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Phone")
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
                    Icon(imageVector = Icons.Filled.Call, contentDescription = "", tint = Color(0xFFCF06F0), modifier = Modifier.padding(start = 10.dp))
                }
            )
            Spacer(modifier = Modifier.height(23.dp))
            OutlinedTextField(
                value = "Digite seu e-mail",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "E-mail")
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),

                        unfocusedTextColor = Color(0xFF000000)
                    ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0), modifier = Modifier.padding(start = 10.dp))
                }
            )

            Spacer(modifier = Modifier.height(23.dp))

            OutlinedTextField(
                value = "Digite sua senha",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                    ),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFFCF06F0), modifier = Modifier.padding(start = 10.dp))
                }
            )

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                    Checkbox(
                        checked = false, onCheckedChange = {},
                        colors = CheckboxDefaults.colors(uncheckedColor = Color(0xFFCF06F0)),
                        modifier = Modifier
                            .scale(1.5f)

                    )
                Text(text = "Over 18?")

            }
            Spacer(modifier = Modifier.height(10.dp))



            Row(
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.End
            ){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xFFCF06F0)),
                    shape = RoundedCornerShape(13.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)

                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "CREATE ACCOUNT",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 16 .sp
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                horizontalArrangement = Arrangement.End

            ) {
                Text(text = "Already have an account? ", color = Color(0xFFA09C9C))
                Text(text = "Sign up", color = Color(0xFFCF06F0), fontWeight = FontWeight.Bold)
            }



        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ){
            Card(
                modifier = Modifier
                    .offset(
                        x = (-60.dp),
                        y = 115.dp
                    )
                    .size(width = 200.dp, height = 60.dp),
                colors = CardDefaults.cardColors(Color(0xFFCF06F0))
            ) {

            }
        }
    }


    }

@Composable
fun Home(){
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

        OutlinedTextField(value = "", onValueChange = {},
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
fun SignUpPreview(){
    MyTripsTheme {
        SignUp()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginPreview(){
    MyTripsTheme {
        login()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    MyTripsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Home()
        }
    }
}
