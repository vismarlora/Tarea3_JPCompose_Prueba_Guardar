package com.example.tarea3compose.ui.theme.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tarea3compose.ui.theme.ocupacion.OcupacionViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuOcupacion() {
    val types = listOf("Ingeniero", "Administrador", "Contable", "Licenciado")
    val default = 0

    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf(types[default]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedType,
            onValueChange = { },

            label = { Text(text="Ocupacion") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            types.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedType = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}


@Composable
fun RegistroPersona(
    navHostController: NavHostController,
    viewModel: PersonaViewModel = hiltViewModel()
){

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas") })
        },

        //scaffoldState = scaffoldState

    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "Nombres")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it},
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
                onValueChange = {viewModel.email = it},
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
                onValueChange = {viewModel.salario = it.toFloat()},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {

                    Icon(imageVector = Icons.Default.NewLabel, contentDescription =null )
                    Text(text = "Nuevo")

                }

                OutlinedButton(
                    onClick = {
                        viewModel.Guardar()

                        navHostController.navigateUp()

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Save, contentDescription =null )
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {


                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }
}