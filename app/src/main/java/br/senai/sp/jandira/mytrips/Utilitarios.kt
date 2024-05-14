package br.senai.sp.jandira.mytrips

import java.time.LocalDate

fun reduzirData(dataAntiga: LocalDate): String{
    val dia = dataAntiga.dayOfMonth
    val mes = dataAntiga.month.toString().substring(0..2)
    return "$dia - $mes"
}