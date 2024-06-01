package br.senai.sp.jandira.mytrips.repository

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.categoria

class CategoriaRepository {

    @Composable
    fun listarTodasAsCategorias(): List<categoria>{
        val beach = categoria()
        beach.id = 1
        beach.categoria = stringResource(id = R.string.beach)
        beach.image = painterResource(id = R.drawable.beach)

        val snow = categoria()
        snow.id = 2
        snow.categoria = stringResource(id = R.string.snow)
        snow.image = painterResource(id = R.drawable.skii)

        val mountain = categoria()
        mountain.id = 3
        mountain.categoria = stringResource(id = R.string.montain)
        mountain.image = painterResource(id = R.drawable.cascata)

        val city = categoria()
        city.id = 4
        city.categoria = stringResource(id = R.string.city)
        city.image = painterResource(id = R.drawable.city)


        val desert = categoria()
        desert.id = 5
        desert.categoria = stringResource(id = R.string.desert)
        desert.image = painterResource(id = R.drawable.desert)

        val forest = categoria()
        forest.id = 6
        forest.categoria = stringResource(id = R.string.forest)
        forest.image = painterResource(id = R.drawable.florest)


        return listOf(beach, snow, mountain, city, desert, forest)
    }
}
