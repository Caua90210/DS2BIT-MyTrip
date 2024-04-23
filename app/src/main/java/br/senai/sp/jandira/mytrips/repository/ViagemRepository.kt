package br.senai.sp.jandira.mytrips.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Viagem
import java.time.LocalDate

class ViagemRepository {

    @Composable
    fun listarTodasAsViagens(): List<Viagem>{
        val londres = Viagem()
        londres.id = 1
        londres.destino = "Londres"
        londres.descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana."
        londres.dataChegada = LocalDate.of(2019, 2, 18)
        londres.dataPartida = LocalDate.of(2019, 2, 21)
        londres.image = painterResource(id = R.drawable.londres)

        val porto = Viagem()
        porto.id = 2
        porto.destino = "Porto"
        porto.descricao = "Futebol Clube do Porto, também conhecido como FC Porto ou simplesmente Porto, é um clube multidesportivo português sedeado na cidade do Porto."
        porto.dataChegada = LocalDate.of(2022, 2, 18)
        porto.dataPartida = LocalDate.of(2022, 2, 21)
        porto.image = null


        val recife = Viagem()
        recife.id = 3
        recife.destino = "Recife"
        recife.descricao = "Recife, a capital do estado de Pernambuco, no nordeste do Brasil, distingue-se pelos seus vários rios, pontes, ilhéus e penínsulas."
        recife.dataChegada = LocalDate.of(2022, 2, 18)
        recife.dataPartida = LocalDate.of(2022, 2, 21)
        recife.image = null

        val fortaleza = Viagem()
        fortaleza.id = 4
        fortaleza.destino = "fortaleza"
        fortaleza.descricao = "O Fortaleza Esporte Clube é um clube poliesportivo da cidade brasileira de Fortaleza, capital do estado do Ceará."
        fortaleza.dataChegada = LocalDate.of(2022, 2, 18)
        fortaleza.dataPartida = LocalDate.of(2022, 2, 21)
        fortaleza.image = null

        val boston = Viagem()
        boston.id = 5
        boston.destino = "Boston"
        boston.descricao = "Boston é a capital e a maior cidade de Massachusetts. Fundada em 1630, é uma das mais antigas cidades do EUA. "
        boston.dataChegada = LocalDate.of(2022, 2, 18)
        boston.dataPartida = LocalDate.of(2022, 2, 21)
        boston.image = null

        return listOf(londres, porto, recife, fortaleza, boston)
    }

}