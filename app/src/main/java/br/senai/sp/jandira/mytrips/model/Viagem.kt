package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_viagem")
data class Viagem(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var destino: String = "",
    var descricao: String = "",
    @ColumnInfo(name = "data_chegada") var dataChegada: String = "",
    @ColumnInfo(name = "data_partida") var dataPartida: String = "",
    @ColumnInfo(name = "imagem_path") var image: String? = null
)
