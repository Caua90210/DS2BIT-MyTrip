package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var nome: String = "",
    var telefone: String = "",
    var email: String = "",
    var senha: String = "",
    var isMaiorDeIdade: Boolean = false
)
