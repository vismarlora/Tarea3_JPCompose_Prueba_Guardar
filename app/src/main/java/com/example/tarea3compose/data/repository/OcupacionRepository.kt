package com.example.tarea3compose.data.repository

import com.example.tarea3compose.data.OcupacionDao
import com.example.tarea3compose.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    val ocupacionDao: OcupacionDao
) {
    suspend fun insertar(ocupacion: Ocupacion){
        ocupacionDao.insertar(ocupacion)
    }

    suspend fun eliminar(ocupacion: Ocupacion){
        ocupacionDao.eliminar(ocupacion)
    }

    fun buscar(ocupacionId: Int): Flow<Ocupacion>{
        return ocupacionDao.buscar(ocupacionId)
    }

    fun getList(): Flow<List<Ocupacion>>{
        return ocupacionDao.getList()
    }
}

