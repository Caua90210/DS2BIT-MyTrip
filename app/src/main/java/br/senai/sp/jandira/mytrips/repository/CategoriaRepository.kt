package br.senai.sp.jandira.mytrips.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.categoria

class CategoriaRepository {
   @Composable
   fun listarTodasAsCategorias(): List<categoria>{
       val beach = categoria()
       beach.id = 1
       beach.categoria = "Beach"
       beach.image = painterResource(id = R.drawable.beach)

       val snow = categoria()
       snow.id = 2
       snow.categoria = "Snow"
       snow.image = painterResource(id = R.drawable.skii)

       val montain = categoria()
       montain.id = 3
       montain.categoria = "Montain"
       montain.image = painterResource(id = R.drawable.cascata)

       return listOf(beach, snow, montain)
   } 
    
}