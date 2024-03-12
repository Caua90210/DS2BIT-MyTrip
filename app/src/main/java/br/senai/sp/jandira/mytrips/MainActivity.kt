package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
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
                    login()
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun Greeting() {}

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
                        .offset(x = (45.dp)  , y = (40.dp) )
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
