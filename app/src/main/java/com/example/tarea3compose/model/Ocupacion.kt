package com.example.tarea3compose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ocupaciones")
data class Ocupacion(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId: Int=0,
    val nombres: String
)

