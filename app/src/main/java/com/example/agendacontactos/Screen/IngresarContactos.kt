package com.example.agendacontactos.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngresarContactos(navController: NavController, contacts: MutableList<String>) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var lastName by remember { mutableStateOf(TextFieldValue()) }
    var phone by remember { mutableStateOf(TextFieldValue()) }
    var address by remember { mutableStateOf(TextFieldValue()) }

    var showError by remember { mutableStateOf(false) } // Estado para mostrar el mensaje de error

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


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



        Text("Registrar Contacto", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = {
                name = it
                showError = false // Ocultar el mensaje de error cuando el usuario cambia los valores
            },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = lastName,
            onValueChange = {
                lastName = it
                showError = false
            },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = phone,
            onValueChange = {
                phone = it
                showError = false
            },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = address,
            onValueChange = {
                address = it
                showError = false
            },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar mensaje de error si hay campos vacíos
        if (showError) {
            Text("Por favor, complete todos los campos.", style = MaterialTheme.typography.titleSmall, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Verificar si algún campo está vacío
                if (name.text.isEmpty() || lastName.text.isEmpty() || phone.text.isEmpty() || address.text.isEmpty()) {
                    showError = true // Mostrar mensaje de error si algún campo está vacío
                } else {
                    // Si todos los campos están completos, agregar el contacto a la lista
                    val contact = "Nombre: ${name.text}, Apellido: ${lastName.text}, Teléfono: ${phone.text}, Dirección: ${address.text}"
                    contacts.add(contact)

                    // Limpiar los campos después de registrar el contacto
                    name = TextFieldValue()
                    lastName = TextFieldValue()
                    phone = TextFieldValue()
                    address = TextFieldValue()

                    showError = false // Ocultar el mensaje de error
                }
            }
        ) {
            Text("Registrar Contacto")
        }
    }
}
