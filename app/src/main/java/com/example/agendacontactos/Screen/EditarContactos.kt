package com.example.agendacontactos.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditarContactos(navController: NavController, contacts: MutableList<String>) {

    // Estado que almacenará el contacto seleccionado para editar
    var selectedContact by remember { mutableStateOf<String?>(null) }

    // Campos de edición
    var newName by remember { mutableStateOf("") }
    var newLastName by remember { mutableStateOf("") }
    var newPhone by remember { mutableStateOf("") }
    var newAddress by remember { mutableStateOf("") }

    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar el contenido
    ) {


        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = {
            navController.navigate("homeContactos") // Volver a HomeContactos
        },
            Modifier.align(Alignment.Start)) {
            Icon(
                imageVector = Icons.Default.ArrowBack, // Ícono de flecha
                contentDescription = "Volver a Home"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Editar Contactos:", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        if (selectedContact == null) {
            // Mostrar lista de contactos para seleccionar
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre elementos
            ) {
                items(contacts) { contact ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = contact,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Botón para seleccionar el contacto a editar
                            Button(onClick = {
                                selectedContact = contact
                                // Separar el contacto en sus partes
                                val parts = contact.split(", ")
                                newName = parts.getOrNull(0)?.removePrefix("Nombre: ") ?: ""
                                newLastName = parts.getOrNull(1)?.removePrefix("Apellido: ") ?: ""
                                newPhone = parts.getOrNull(2)?.removePrefix("Teléfono: ") ?: ""
                                newAddress = parts.getOrNull(3)?.removePrefix("Dirección: ") ?: ""
                            }) {
                                Text("Editar")
                            }
                        }
                    }
                }
            }
        } else {
            // Formulario para editar el contacto seleccionado
            Text("Editar Contacto", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = newName,
                onValueChange = { newName = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = newLastName,
                onValueChange = { newLastName = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = newPhone,
                onValueChange = { newPhone = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = newAddress,
                onValueChange = { newAddress = it },
                label = { Text("Dirección") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar mensaje de error si algún campo está vacío, pero fuera del formulario
            if (showError) {
                Text(
                    text = "Por favor, complete todos los campos.",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Button(onClick = {
                // Validar que todos los campos estén completos antes de guardar
                if (newName.isEmpty() || newLastName.isEmpty() || newPhone.isEmpty() || newAddress.isEmpty()) {
                    showError = true // Mostrar mensaje de error si algún campo está vacío
                } else {
                    val newContact = "Nombre: $newName, Apellido: $newLastName, Teléfono: $newPhone, Dirección: $newAddress"
                    val index = contacts.indexOf(selectedContact)
                    if (index != -1) {
                        contacts[index] = newContact
                    }
                    showError = false // Ocultar mensaje de error si la operación es exitosa
                    selectedContact = null // Limpiar la selección después de guardar
                }
            }) {
                Text("Guardar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para cancelar la edición
            Button(onClick = {
                selectedContact = null // Cancelar edición
            }) {
                Text("Cancelar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (contacts.isEmpty()) {
            Text(text = "No hay Contactos Registados")

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("ingresarContactos")
                },
                modifier = Modifier.align(Alignment.CenterHorizontally) // Centrar el botón
            ) {
                Text("Ingresar Contacto")
            }
        }
    }
}
