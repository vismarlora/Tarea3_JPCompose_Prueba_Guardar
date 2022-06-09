package com.example.tarea3compose.ui.theme.persona

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tarea3compose.ui.theme.ocupacion.OcupacionViewModel

var selectedOcupacion: String? = null

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuOcupacion(
    viewModelP: PersonaViewModel = hiltViewModel(),
    viewModel: OcupacionViewModel = hiltViewModel()
) {
    val lista = viewModel.ocupacion.collectAsState(initial = emptyList())


    var expended by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf("") }

    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(6.dp)
        ) {
            Text(text = selectedType, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false }) {
                lista.value.forEach { ocupacion ->
                    DropdownMenuItem(onClick = {
                        viewModelP.ocupacionId = ocupacion.ocupacionId
                        expended = false
                        selectedType = ocupacion.nombres
                        selectedOcupacion = ocupacion.nombres
                    }) {
                        Text(text = ocupacion.nombres)
                    }
                }

            }
        }
    }
}

@Composable
fun RegistroPersona(
    navHostController: NavHostController,
    viewModel: PersonaViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas") })
        },

        //scaffoldState = scaffoldState

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        ) {
            OutlinedTextField(
                label = {
                    Text(text = "Nombres")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = viewModel.nombre,
                onValueChange = { viewModel.nombre = it },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                modifier = Modifier.fillMaxWidth()
            )

            MenuOcupacion()

            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = null)
                },
                value = viewModel.salario.toString(),
                onValueChange = { viewModel.salario = it.toFloat() },
                modifier = Modifier.fillMaxWidth()
            )

            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Icon(imageVector = Icons.Default.NewLabel, contentDescription = null)
                    Text(text = "Nuevo")

                }

                OutlinedButton(
                    onClick = {
                        viewModel.Guardar()

                        navHostController.navigateUp()

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Save, contentDescription = null)
                    Text(text = "Guardar")
                }

                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    Text(text = "Eliminar")
                }
            }
        }
    }
}