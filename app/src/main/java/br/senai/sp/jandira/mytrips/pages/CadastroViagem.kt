package br.senai.sp.jandira.mytrips.pages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Viagem
import br.senai.sp.jandira.mytrips.repository.ViagemRepository
import coil.compose.rememberImagePainter
import kotlinx.coroutines.delay

@Composable
fun FormularioViagem(controleDeNavegacao: NavHostController) {

    var destinoState by remember { mutableStateOf("") }
    var descricaoState by remember { mutableStateOf("") }
    var dataChegadaState by remember { mutableStateOf("") }
    var dataPartidaState by remember { mutableStateOf("") }
    var imagemUri by remember { mutableStateOf<Uri?>(null) }

    val context = LocalContext.current
    val getContent = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            imagemUri = uri
        }
    }

    val viagemRepository = ViagemRepository(LocalContext.current)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.title_new_trip),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EE)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = destinoState,
            onValueChange = { destinoState = it },
            label = { Text(text = stringResource(id = R.string.trip_destination)) },
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = tween(durationMillis = 300)),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = descricaoState,
            onValueChange = { descricaoState = it },
            label = { Text(text = stringResource(id = R.string.trip_description)) },
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = tween(durationMillis = 300)),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dataChegadaState,
            onValueChange = { dataChegadaState = it },
            label = { Text(text = stringResource(id = R.string.trip_arrival_date)) },
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = tween(durationMillis = 300)),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = dataPartidaState,
            onValueChange = { dataPartidaState = it },
            label = { Text(text = stringResource(id = R.string.trip_departure_date)) },
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = tween(durationMillis = 300)),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = imagemUri != null,
            enter = fadeIn(animationSpec = tween(durationMillis = 300)),
            exit = fadeOut(animationSpec = tween(durationMillis = 300))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = rememberImagePainter(imagemUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop // Para garantir que a imagem preencha o espaço corretamente
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))







        Button(
            onClick = {
                getContent.launch("image/*")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF6200EE)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Selecionar Imagem")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val novaViagem = Viagem(
                    destino = destinoState,
                    descricao = descricaoState,
                    dataChegada = dataChegadaState,
                    dataPartida = dataPartidaState,
                    image = imagemUri
                )

                viagemRepository.salvar(novaViagem)
                controleDeNavegacao.navigate("home")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF6200EE)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = stringResource(id = R.string.save))
        }
    }
}
