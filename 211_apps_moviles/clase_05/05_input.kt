package com.example.myapplication


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

// en este ejemplo la lógica esta separada del composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            FormularioSaludo()
        }
    }
}

@Composable
fun FormularioSaludo(){

    var nombreForm by remember {mutableStateOf(value = "")}
    var mensajeForm by remember {mutableStateOf(value = "")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(
            text="Ingresa tu nombre",
            fontSize = 20.sp
        )

        OutlinedTextField(
            value = nombreForm, // lo que yo escriba, guardalo en value
            onValueChange = {nombreForm = it}, // IT ES ESO, ese nuevo valor
            label = { Text(text="Nombre") }
        ) // INPUT de formulario

        Button(onClick = {mensajeForm = "Hola $nombreForm"}) {
            Text(text="Saludar")
        }

        Text(text=mensajeForm, fontSize = 24.sp)

    }

}
