package com.example.clase_09


import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.activity.compose.setContent
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import java.util.Locale


class ResultadoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recibe los datos si no llega nada usa 0.0
        // getDoubleExtra hace lo inverso de putExtra. busca la clave "extra_presion", si existe, devuelve el valor. si no, devuelve 0.0
        // double es de decimal
        val presionGetExtra = intent.getDoubleExtra(EXTRA_PRESION, 0.0) // que es getdouble?
        val volumenGetExtra = intent.getDoubleExtra(EXTRA_VOLUMEN, 0.0)
        val temperaturaGetExtra = intent.getDoubleExtra(EXTRA_TEMPERATURA, 0.0)

        val registroActual =
            "P=${presionGetExtra} | V=${volumenGetExtra} | T=${temperaturaGetExtra}" // se crea en ResultadoActivity, se pasa a:

        // ! Guarda el cálculo en historial P=1.0 | V=2.0 | T=24.39
        // HistorialRepository es una clase auxiliar de kotlin que creé
        // this = la Activity. Y la Activity es un Context, entonces estoy pasando el contexto
        val historialRepository = HistorialRepository(this)
        historialRepository.agregarRegistro(registroActual) // se guarda en SharedPreferences
        // ! Guarda el cálculo en historial P=1.0 | V=2.0 | T=24.39

        val historialDesdeLaClase = historialRepository.obtenerHistorial() // se manda a la UI

        setContent { // Muestra la UI
            MaterialTheme {
                PantallaResultado( // es una función composable (UI)
                    // en Compose las pantallas son funciones, los datos se pasan como parámetros
                    presion = presionGetExtra,
                    volumen = volumenGetExtra,
                    temperatura = temperaturaGetExtra,
                    historial = historialDesdeLaClase // se manda a la UI
                )
            }
        }

    }

    // Está afuera de override. Sirve para definir constantes globales de la clase y acceder sin crear instancia. Paquete de constantes
    companion object {
        const val EXTRA_PRESION = "extra_presion"
        const val EXTRA_VOLUMEN = "extra_volumen"
        const val EXTRA_TEMPERATURA = "extra_temperatura"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaResultado(
    presion: Double,
    volumen: Double,
    temperatura: Double,
    historial: List<String> // lista de strings [ "P=1 | V=2 | T=24","P=3 | V=1 | T=36"]
) {
    // intenta convertir el context en Activity
    // as? - cast seguro (puede devolver null)
    val activity = LocalContext.current as? Activity

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultado") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700) // fondo
                )
            )
        }
    ) { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // tarjeta estática, solo muestra los valores formateados a 2 decimales con Double.formatoDecimal
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Cálculo actual",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text("Presión: ${presion.formatoDecimal(2)}") // que es formato?
                    Text("Volumen: ${volumen.formatoDecimal(2)}")
                    Text("Temperatura: ${temperatura.formatoDecimal(2)} K")
                }
            }

            // Tarjeta de HISTORIAL
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Últimos 5 cálculos",
                        style = MaterialTheme.typography.titleLarge
                    )

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

                }
            }

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
// 1.23456 → "1.23"