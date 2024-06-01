package br.senai.sp.jandira.mytrips.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.senai.sp.jandira.mytrips.model.Usuarios
import br.senai.sp.jandira.mytrips.model.Viagem


@Database(entities = [Viagem::class, Usuarios::class], version = 3)
@TypeConverters(Converters::class)
abstract class ViagemDB : RoomDatabase() {

    abstract fun viagemDao(): ViagemDAO
    abstract fun UsuarioDAO(): UsuarioDAO

    companion object {
        private lateinit var instancia: ViagemDB

        fun getBancoDeDados(context: Context): ViagemDB {
            instancia = Room
                .databaseBuilder(
                    context,
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
