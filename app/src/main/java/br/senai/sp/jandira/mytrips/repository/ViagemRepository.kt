package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.dao.ViagemDB
import br.senai.sp.jandira.mytrips.model.Viagem
import java.time.LocalDate

class ViagemRepository(context: Context) {
    private val db = ViagemDB.getBancoDeDados(context).viagemDao()

    fun salvar(viagem: Viagem): Long{
        return db.salvar(viagem)
    }
    @Composable
    fun listarTodasAsViagens(): List<Viagem>{
        return db.listarTodosAsViagens()


//        val londres = Viagem()
//        londres.id = 1
//        londres.destino = "Londres"
//        londres.descricao = "Londres, capital da Inglaterra e do Reino Unido, é uma cidade do século 21 com uma história que remonta à era romana."
//        londres.dataChegada = "2020-02-02"
//        londres.dataPartida = "2023-02-02"
//        londres.image = "https://static.mundoeducacao.uol.com.br/mundoeducacao/2021/11/centro-financeiro-londres.jpg"

//        return listOf(londres)
    }

}