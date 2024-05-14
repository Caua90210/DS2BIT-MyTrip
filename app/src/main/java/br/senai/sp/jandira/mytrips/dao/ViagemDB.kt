package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mytrips.model.Usuarios
import br.senai.sp.jandira.mytrips.model.Viagem

@Database(entities = [Viagem::class, Usuarios::class], version = 1)
abstract class ViagemDB : RoomDatabase() {

    abstract fun viagemDao(): ViagemDAO

    companion object {
        private lateinit var instancia: ViagemDB

        fun getBancoDeDados(context: Context): ViagemDB {
            instancia = Room
                .databaseBuilder(
                    context.applicationContext,
                    ViagemDB::class.java,
                    "db_viagens"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return instancia
        }
    }
}