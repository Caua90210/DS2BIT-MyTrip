package br.senai.sp.jandira.mytrips.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Viagem
import br.senai.sp.jandira.mytrips.repository.ViagemRepository


@Composable
fun FormularioViagem(controleDeNavegacao: NavHostController) {

    var destinoState = remember {
        mutableStateOf("")
    }
    var descricaoState = remember { mutableStateOf("") }
    var dataChegadaState = remember { mutableStateOf("") }
    var dataPartidaState = remember { mutableStateOf("") }
    var imagemPathState = remember { mutableStateOf("") }

    val viagemRepository = ViagemRepository(LocalContext.current)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_new_trip),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = destinoState.value,
            onValueChange = { destinoState.value = it },
            label = { Text(text = stringResource(id = R.string.trip_destination)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descricaoState.value,
            onValueChange = { descricaoState.value = it },
            label = { Text(text = stringResource(id = R.string.trip_description)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dataChegadaState.value,
            onValueChange = { dataChegadaState.value = it },
            label = { Text(text = stringResource(id = R.string.trip_arrival_date)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = dataPartidaState.value,
            onValueChange = { dataPartidaState.value = it },
            label = { Text(text = stringResource(id = R.string.trip_departure_date)) },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = imagemPathState.value,
            onValueChange = { imagemPathState.value = it },
            label = { Text(text = stringResource(id = R.string.trip_image_path)) },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {

                val novaViagem = Viagem(
                    destino = destinoState.value,
                    descricao = descricaoState.value,
                    dataChegada = dataChegadaState.value,
                    dataPartida = dataPartidaState.value,
                    image = imagemPathState.value
                )

                // Salvar a nova viagem no repositório
                viagemRepository.salvar(novaViagem)

                controleDeNavegacao.navigate("home")

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.save))
        }
    }
}
