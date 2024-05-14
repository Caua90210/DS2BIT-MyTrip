package br.senai.sp.jandira.mytrips.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.mytrips.model.Usuarios
import br.senai.sp.jandira.mytrips.model.Viagem

@Dao
interface ViagemDAO {

        @Insert
        fun salvar(viagem: Viagem): Long

        @Update
        fun atualizar(viagem: Viagem): Int

        @Delete
        fun excluir(viagem: Viagem)

        @Query("SELECT * FROM tbl_viagem ORDER BY destino ASC")
        fun listarTodosAsViagens(): List<Viagem>

        @Insert
        fun salvarUsuario(usuarios: Usuarios): Long

        @Query("SELECT * FROM tbl_usuarios")
        fun listarTodosOsUsuarios(): List<Usuarios>

        @Query("select * from tbl_usuarios where email = :email")
        fun buscarUsuarioPeloEmail(email: String): Usuarios?

}
