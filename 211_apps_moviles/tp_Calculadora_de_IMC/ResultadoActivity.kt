package com.example.tp_calculadora_imc

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale


class ResultadoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pesoGetExtra = intent.getDoubleExtra(EXTRA_PESO, 0.0)
        val alturaGetExtra = intent.getDoubleExtra(EXTRA_ALTURA, 0.0)
        val nombreGetExtra = intent.getStringExtra(EXTRA_NOMBRE) ?: ""
        val imcGetExtra = intent.getDoubleExtra(EXTRA_IMC, 0.0)

        val historialRepository = HistorialRepository(this) // referencia de la clase

        val registroActualAGuardar =
            "Nombre = ${nombreGetExtra}. Peso = ${pesoGetExtra.formatoDecimal(2)}. Altura = ${
                alturaGetExtra.formatoDecimal(2)
            }. IMC = ${imcGetExtra.formatoDecimal(2)}"
        historialRepository.agregarRegistro(registroActualAGuardar) // se guarda en SharedPreferences

        val historialDesdeLaClase = historialRepository.obtenerHistorial() // se manda a la UI

        setContent {
            PantallaResultado(
                pesoUser = pesoGetExtra,
                alturaUser = alturaGetExtra,
                nombreUser = nombreGetExtra,
                imcUser = imcGetExtra,
                historial = historialDesdeLaClase,
                myHistorialRepository = historialRepository
            )
        }


    }

    companion object {
        const val EXTRA_PESO = "extra_peso"
        const val EXTRA_ALTURA = "extra_altura"
        const val EXTRA_NOMBRE = "extra_nombre"
        const val EXTRA_IMC = "extra_imc"
    }
}

fun clasificacionIMC(imc: Double): String {
    var clasificacionImc = ""
    when {
        imc < 18.5 -> clasificacionImc = "Bajo peso"
        imc > 18.5 && imc < 25 -> clasificacionImc = "Peso normal"
        imc > 25 && imc < 29.9 -> clasificacionImc = "Sobrepeso"
        imc > 30 -> clasificacionImc = "Obesidad"
        else -> clasificacionImc = "Datos invalidos para calcular"
    }
    return clasificacionImc
}

fun validarSiBajoDePeso(
    nombreActual: String, pesoActual: Double, historialRepository: HistorialRepository
): String {
    // busquedaPorNombre = "Nombre = Juan. Peso = 70.00. Altura = 1.70. IMC = 24.22"

    val busquedaPorNombre = historialRepository.buscarPorNombre(nombreActual)
    var mensajeValidacion = ""

    if (busquedaPorNombre != null) {
        // partes: ["Nombre = Juan", "Peso = 70.00", "Altura = 1.70", "IMC = 24.22"]
        // peso es la posicion 1
        val partes = busquedaPorNombre.split(". ")
        // reemplaza "Peso = " con nada: ""
        val pesoGuardadoString = partes[1].replace("Peso = ", "")
        // lo intento llevar a decimal, sino null
        val pesoGuardado = pesoGuardadoString.toDoubleOrNull()

        if (pesoGuardado != null) {
            if (pesoActual < pesoGuardado) {
                mensajeValidacion = "Bajaste de peso"
            } else if (pesoActual > pesoGuardado) {
                mensajeValidacion = "Subiste de peso"
            } else {
                mensajeValidacion = "Tu IMC se mantiene"
            }
        }

    }

    return mensajeValidacion
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaResultado(
    pesoUser: Double,
    alturaUser: Double,
    nombreUser: String,
    imcUser: Double,
    historial: List<String>,
    myHistorialRepository: HistorialRepository
) {
    // intenta convertir el context en Activity
    // as? - cast seguro (puede devolver null)
    val activity = LocalContext.current as? Activity

    val clasificacionIMC = clasificacionIMC(imcUser)
    val validacionIMC = validarSiBajoDePeso(nombreUser, pesoUser, myHistorialRepository)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultado") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700) // fondo
                )
            )
        }) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Datos actuales", fontSize = 40.sp, color = Color.Red)

            Text("Nombre: ${nombreUser}")
            Text("Peso: ${pesoUser.formatoDecimal(2)}")
            Text("Altura: ${alturaUser.formatoDecimal(2)}")
            Text("IMC: ${imcUser.formatoDecimal(2)}")

            Text("Últimos 5 registros", fontSize = 40.sp, color = Color.Blue)

            // Mostrar los elementos del historial
            if (historial.isEmpty()) {
                Text("No hay cálculos guardados")
            } else {
                // Muestra los últimos 5 cálculos
                historial.forEachIndexed { index, item -> // recorre la lista con índice
                    // 0 --> "P=1..." | 1 --> "P=3..."
                    Text("${index + 1}. $item")
                    // 1. P=1...
                    // 2. P=3...
                }
            }

            Text("Clasificacion de IMC", fontSize = 40.sp, color = Color.Green)
            Text("Tu clasificacion de imc es: $clasificacionIMC", fontSize = 20.sp)

            Text("Validacion de subida o bajada de IMC", fontSize = 40.sp, color = Color.Green)
            Text("Tu validacion de imc es: $validacionIMC", fontSize = 20.sp)


            Button(
                // Botón volver. Cierra la pantalla actual
                onClick = { activity?.finish() }, // si existe: cierra la pantalla actual. es equivalente al botón “volver”
                modifier = Modifier.fillMaxWidth()
            ) { Text("Volver") }

        }
    }
}

// función para mostrar solo 2 decimales
fun Double.formatoDecimal(decimales: Int): String {
    return "%.${decimales}f".format(Locale.US, this)
}