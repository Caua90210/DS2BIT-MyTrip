package br.senai.sp.jandira.mytrips.model

import androidx.compose.ui.graphics.painter.Painter
import java.time.LocalDate

data class categoria(
    var id: Int = 0,
    var categoria: String = "",
    var image: Painter? = null
)

