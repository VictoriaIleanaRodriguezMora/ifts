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
import androidx.compose.ui.platform.LocalContext
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SensorApp()
            }
        }
    }
}

@Composable
fun SensorApp() {
    val context = LocalContext.current
    // instancia de LastMeasurementPreferences
    // esta clase lo que va a hacer es guardar en shared preferences mi ultima medicion
    val Shared_Preferences = remember { LastMeasurementPreferences(context) }
    // la medicion actual, es de tipo ObjetoAccelerometerMeasurement
    var currentMeasurementState by remember {
        mutableStateOf<ObjetoAccelerometerMeasurement?>(null)
    }
    // ultimaMedicionGuardadaState es traer de shared pref. mi ultima medición guardada, con getUltimaMedicion
    var ultimaMedicionGuardadaState by remember { mutableStateOf(Shared_Preferences.getUltimaMedicion()) }
    var sensorAvailableState by remember { mutableStateOf(true) } // true o false
    // lector de sensor, es una instancia de AccelerometerReader
    val accelerometerReader = remember { AccelerometerReader(context) }

    DisposableEffect(Unit) {
        // DisposableEffect = Cuando este composable aparezca en pantalla, ejecutá este bloque. Cuando desaparezca, ejecutá la limpieza.
        // iniciarLecturaDelSensor devuelve false si el dispositivo no tiene acelerometro
        // iniciarLecturaDelSensor devuelve true, si pudo operar con la funcion que recibió, al recibir nuevos datos
        // iniciarLecturaDelSensor guarda la funcion que le llega por parametro en la propiedad de clase this, para poder invocarla en onSensorChanged
        // onSensorChanged es el método que ejecuta ANDROID automaticamente, cada vez que se mueve el telefono, cada vez que se registra un nuevo valor de aceletrometro
        // esta lambda no se ejecuta inmediatamente, sino más tarde, cuando Android detecta un cambio en el acelerómetro
        sensorAvailableState = accelerometerReader.iniciarLecturaDelSensor (
            // lo unico que hace esta funcion lambda es asignarle el valor de la medicion que detectó android, a currentMeasurementState. para poder manipularlo. en onSaveMeasurementView guardarlo en shared preferences y mostrarlo en la ui. por eso no devuelve nada
            onMedicionChangedParam =  { measurement: ObjetoAccelerometerMeasurement ->
                currentMeasurementState = measurement
            })
        // onDispose es la función que Compose ejecutará cuando el DisposableEffect se destruya.
        // Cuando ya no necesites este efecto, ejecutá esto
        onDispose { accelerometerReader.stopReading() }
    }

    Scaffold { paddingValues ->
        SensorScreenView(
            // le paso valores a la vista
            paddingValuesView = paddingValues,
            sensorAvailableView = sensorAvailableState, // Boolean
            currentMeasurementView = currentMeasurementState, // ObjetoAccelerometerMeasurement?
            savedMeasurementView = ultimaMedicionGuardadaState, // ObjetoAccelerometerMeasurement?
            onSaveMeasurementView = {
                // currentMeasurementState es una propiedad mutable (var), Kotlin no puede garantizar que siga siendo no nula en la siguiente línea
                val medicionActual = currentMeasurementState
                if (medicionActual != null){
                    Shared_Preferences.guardarUltimaMedicion(medicionActual)
                    ultimaMedicionGuardadaState = medicionActual
                }
            }
        )
    }
}
@Composable
fun SensorScreenView(
    paddingValuesView: PaddingValues,
    sensorAvailableView: Boolean,
    currentMeasurementView: ObjetoAccelerometerMeasurement?,
    savedMeasurementView: ObjetoAccelerometerMeasurement?,
    onSaveMeasurementView: () -> Unit // ?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValuesView)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text( text = "Acelerómetro", style = MaterialTheme.typography.headlineMedium )

        Text(
            text = "Esta app lee el acelerómetro del dispositivo y permite guardar la última medición seleccionada usando SharedPreferences.",
            style = MaterialTheme.typography.bodyMedium
        )

        if (!sensorAvailableView) {
            Text( text = "Este dispositivo no tiene acelerómetro disponible.", color = MaterialTheme.colorScheme.error )
        }

        // 1° tarjeta - Medición actual
        MeasurementCard(
            title = "Medición actual",
            measurement = currentMeasurementView
        )

        Button(
            onClick = onSaveMeasurementView,
            enabled = currentMeasurementView != null && sensorAvailableView,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Guardar medición actual") }

        // 2° tarjeta - Última medición guardada
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

// este componente recibe un titulo, y una medicion: x, y,z
@Composable
fun MeasurementCard(
    title: String,
    measurement: ObjetoAccelerometerMeasurement?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // ?
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