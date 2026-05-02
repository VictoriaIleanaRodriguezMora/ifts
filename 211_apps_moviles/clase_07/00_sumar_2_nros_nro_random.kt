package com.example.clase_05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // scaffold - andamio
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    // PantallaSuma tiene que ser un Composable en algún lado
                        innerPadding ->
                    PantallaSuma(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// funciones
fun sumar(n1: Int, n2: Int): Int {
    return n1 + n2
}

fun generarNroRandom(): Int {
    return Random.nextInt(1, 11) // 1 - 10
}

// parte grafica
@Composable // funcion dibujable
fun PantallaSuma(modifier: Modifier = Modifier) {
    // Seteo variables
    // remember lo que hace es que Composable, recuerde el valor entre COMPOSICIONES
    // pq si no lo resetea. Lo guarda en memoria pq lo voy a llavar en otro lado
    var nro1Texto by remember { mutableStateOf("") }
    var nro2Texto by remember { mutableStateOf("") }
    var resultadoSuma by remember { mutableIntStateOf(0) }
    var resultadoRandom by remember { mutableIntStateOf(0) }
    var mensajeSuma by remember { mutableStateOf("") }
    var mensajeRandom by remember { mutableStateOf("") }

    // idea de recomposicion

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ejemplo: sumar 2 nros")

        OutlinedTextField( // nombre del campo
            value = nro1Texto,
            onValueChange = { nuevoValor -> nro1Texto = nuevoValor}, // equivalente a it
            label = { Text("1er nro") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // cuando abro en mi telefono y me aparecen solo numeros para ingresar, eso es
        )

        OutlinedTextField( // nombre del campo
            value = nro2Texto,
            onValueChange = { nro2Texto = it },
            label = { Text("2° nro") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            val n1 = nro1Texto.toIntOrNull()
            val n2 = nro2Texto.toIntOrNull()

            if (n1 == null || n2 == null) {
                mensajeSuma = "Ingresá números válidos"
            } else {
                resultadoSuma = n1 + n2
            }
        }) { Text("Sumar los dos nros") }

        Text(text = "$mensajeSuma")
        Text(text = "nro1Texto: $nro1Texto")
        Text(text = "nro2Texto: $nro2Texto")
        Text(text = "Resultado: $resultadoSuma") // sin esto no veo el rtado

        Button(onClick = {
            val random = generarNroRandom()
            resultadoRandom += random // acumulador
            mensajeRandom = "Se sumó el nro aleatorio: $random RESULTADO: $resultadoRandom . ACUMULADOR!!"
        }) { Text("Sumar número random") }


        Text(text = mensajeRandom) // ! muestro el valor de mensajeRandom en pantalla
    }
}