package com.example.sensores


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = LastMeasurementPreferences(applicationContext)

        setContent {
            MaterialTheme {
                var currentMeasurementState by remember {
                    mutableStateOf<ObjetoAccelerometerMeasurement?>(
                        null
                    )
                } // un estado observable

                // savedMeasurementState no necesita rememberSaveable porque es un dato que viene de sharedpreferences
                var savedMeasurementState by remember { mutableStateOf(preferences.getUltimaMedicion()) }
                var sensorAvailableState by remember { mutableStateOf(true) }
                val accelerometerReaderState = remember { AccelerometerReader(applicationContext) }

                // ejecutar código cuando el composable aparece/desaparece
                // "ejecutá este bloque cuando el composable entra en composición"
                /*  - Cuando aparece la pantalla
                    1. empezar a escuchar el acelerómetro
                    2. cada medición nueva: actualizar currentMeasurement
                    - Cuando desaparece la pantalla
                    dejar de escuchar el sensor */
                DisposableEffect(Unit) {
                    sensorAvailableState = accelerometerReaderState.iniciarLecturaDelSensor { // empieza a escuchar el sensor.
                        measurement -> currentMeasurementState = measurement // REDIBUJA LA UI
                    }

                    onDispose { accelerometerReaderState.stopReading() } // deja de escuchar. "limpiá recursos cuando salga"
                    // sin esto la app seguiría escuchando sensores: aunque se cierre la pantalla, aunque se navegue a otra, aunque el composable desaparezca
                }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Introducción a sensores") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = colorResource(id = R.color.purple_500) // fondo
                            )
                        )
                    }
                ) { paddingValues ->

                    SensorScreen( // que es sensor screen?
                        paddingValues = paddingValues,
                        sensorAvailable = sensorAvailableState,
                        currentMeasurementView = currentMeasurementState,
                        savedMeasurementView = savedMeasurementState,
                        onSaveMeasurementView = {
                            currentMeasurementState?.let { measurement ->
                                preferences.guardarUltimaMedicion(measurement)
                                savedMeasurementState = measurement
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SensorScreen(
    paddingValues: PaddingValues,
    sensorAvailable: Boolean,
    currentMeasurementView: ObjetoAccelerometerMeasurement?,
    savedMeasurementView: ObjetoAccelerometerMeasurement?,
    onSaveMeasurementView: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Acelerómetro",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Esta app lee el acelerómetro del dispositivo y permite guardar la última medición seleccionada usando SharedPreferences.",
            style = MaterialTheme.typography.bodyMedium
        )

        if (!sensorAvailable) {
            Text(
                text = "Este dispositivo no tiene acelerómetro disponible.",
                color = MaterialTheme.colorScheme.error
            )
        }

        // 1° tarjeta
        MeasurementCard(
            title = "Medición actual",
            measurement = currentMeasurementView
        )

        Button(
            onClick = onSaveMeasurementView,
            enabled = currentMeasurementView != null && sensorAvailable,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Guardar medición actual") }

        MeasurementCard(
            title = "Última medición guardada",
            measurement = savedMeasurementView
        )

        Text(
            text = "Nota: el acelerómetro incluye la aceleración de la gravedad. Por eso, aunque el teléfono esté quieto, normalmente se observa un valor cercano a 9.8 m/s² en alguno de los ejes.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun MeasurementCard(
    title: String,
    measurement: ObjetoAccelerometerMeasurement?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            if (measurement == null) {
                Text("No hay medición disponible.")
            } else {
                // se muestran los valores de la ultima medición
                Text("X: ${formatNumber(measurement.x)} m/s²")
                Text("Y: ${formatNumber(measurement.y)} m/s²")
                Text("Z: ${formatNumber(measurement.z)} m/s²")
                Text("Hora: ${formatTime(measurement.timeStampMillis)}")
            }
        }
    }
}

fun formatNumber(value: Float): String {
    return String.format(Locale.getDefault(), "%.2f", value)
}

fun formatTime(timestampMillis: Long): String {
    val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return formatter.format(Date(timestampMillis))
}