package br.senai.sp.jandira.mytrips.model

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var nome: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var over18: Boolean = false,
    var imageUser: Uri?
)