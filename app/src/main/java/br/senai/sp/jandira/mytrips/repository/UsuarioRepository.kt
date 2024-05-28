package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import br.senai.sp.jandira.mytrips.dao.ViagemDB
import br.senai.sp.jandira.mytrips.model.Usuarios
import br.senai.sp.jandira.mytrips.model.Viagem

class UsuarioRepository(context: Context) {
    private val db = ViagemDB.getBancoDeDados(context).UsuarioDAO()

    fun salvar(usuarios: Usuarios): Long{
      return db.salvar(usuarios)
    }
    @Composable
    fun listarTodasOsUsuarios(): List<Usuarios>{
        return db.listarTodosOsUsuarios()


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