package br.senai.sp.jandira.mytrips.repository

import android.content.Context
import androidx.compose.runtime.Composable
import br.senai.sp.jandira.mytrips.dao.ViagemDB
import br.senai.sp.jandira.mytrips.model.Usuarios

class UsuariosRepository(context: Context) {
    private val db = ViagemDB.getBancoDeDados(context).viagemDao()

    fun salvar(usuarios: Usuarios): Long {
        return db.salvarUsuario(usuarios)
    }

    @Composable
    fun listarTodosUsuarios(): List<Usuarios> {
        return db.listarTodosOsUsuarios()
    }


    fun verificarEmailSenha(email:String, senha: String): Boolean{
        val usuario = db.buscarUsuarioPeloEmail(email)
        return usuario != null && usuario.senha == senha
    }
}