package com.example.tarea3compose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tarea3compose.model.Ocupacion
import com.example.tarea3compose.model.Persona

@Database(
    entities = [
        Ocupacion::class,
    Persona::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}