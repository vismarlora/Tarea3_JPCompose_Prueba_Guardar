package com.example.tarea3compose.ui.theme.ocupacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea3compose.data.repository.OcupacionRepository
import com.example.tarea3compose.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class OcupacionViewModel @Inject constructor(
    val ocupacionRepository: OcupacionRepository
):ViewModel() {

    var nombre by mutableStateOf("")

    fun Guardar(){
        viewModelScope.launch {
            ocupacionRepository.insertar(
                Ocupacion(
                    nombres = nombre
                )
            )
        }
    }
}
