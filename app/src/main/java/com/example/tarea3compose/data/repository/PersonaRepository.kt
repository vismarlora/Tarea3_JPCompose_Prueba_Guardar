package com.example.tarea3compose.data.repository

import com.example.tarea3compose.data.PersonaDao
import com.example.tarea3compose.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
) {
    suspend fun insertar(persona: Persona){
        personaDao.insertar(persona)
    }

    suspend fun eliminar(persona: Persona){
        personaDao.eliminar(persona)
    }

    fun buscar(personaId: Int): Flow<Persona> {
        return personaDao.buscar(personaId)
    }

    fun getList(): Flow<List<Persona>> {
        return personaDao.getList()
    }
}