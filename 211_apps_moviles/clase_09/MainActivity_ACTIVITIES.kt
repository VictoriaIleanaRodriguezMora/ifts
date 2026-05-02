package com.example.clase_09

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { Toolbar() }
            ) { paddingScaffold ->
                PantallaIngreso(myScaffoldModifier = Modifier.padding(paddingScaffold))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text("Ley de los gases ideales") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.teal_700) // fondo
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaIngreso(myScaffoldModifier: Modifier = Modifier) { // Es la pantalla donde el usuario escribe los datos.
    // En una Activity puedo usar this, pero en Compose no estoy dentro de una clase entonces:
    // Context = objeto de Android que me da acceso a cosas del sistema    abrir pantallas, acceder a recursos, SharedPreferences
    // "dame el contexto actual de la app"
    val context =LocalContext.current 
    // lo necesito para Intent, startActivity, SharedPreferences

    // guarda lo que escribe el usuario y el mensaje de error
    // rememberSaveable hace que no se pierdan los datos si rota la pantalla
    var presionTextoState by rememberSaveable { mutableStateOf("") }
    var volumenTextoState by rememberSaveable { mutableStateOf("") }
    var mensajeErrorState by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = myScaffoldModifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Ingreso de parámetros", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Usaremos PV = nRT", style = MaterialTheme.typography.bodyLarge)
        Text(
            text = "Supuestos: n=1 mol, R=0.082 L*atm*mol",
            style = MaterialTheme.typography.bodyMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField( // Input
                    value = presionTextoState,
                    onValueChange = { presionTextoState = it },
                    label = { Text("Presión (atm)") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField( // Input
                    value = volumenTextoState,
                    onValueChange = { volumenTextoState = it },
                    label = { Text("Volumen (Litros)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button( // calcular
                    onClick = {
                        // Convierte texto a decimal (double), si no puede convertir devuelve null
                        val presion = presionTextoState.replace(',', '.').toDoubleOrNull()
                        val volumen = volumenTextoState.replace(',', '.').toDoubleOrNull()

                        // Validaciones. Si no son números - error Si son ≤ 0 - error
                        when { // el when es como un switch
                            presion == null || volumen == null -> {
                                mensajeErrorState = "Ingresá datos válidos"
                            }

                            presion <= 0 || volumen <= 0 -> {
                                mensajeErrorState =
                                    "La presion y el volumen deben ser mayores que cero"
                            }

                            // caso feliz
                            else -> {
                                mensajeErrorState = "Todo ok"
                                val n = 1.0
                                val r = 0.082
                                val temperatura =
                                    (presion * volumen) / (n * r) // Cálculo. fórmula de los gases ideales

                                // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                // Navegación a otra pantalla
                                val intent = Intent(
                                    context,
                                    ResultadoActivity::class.java
                                )  // 'quiero abrir la pantalla ResultadoActivity'

                                // Cambia de pantalla y le pasa datos
                                // !!!!!!!!!!!!!!!!!!!!!
                                // putExtra guarda datos dentro del intent (como un diccionario clave-valor)
                                //clave - 'extra_presion' | valor - presion
                                intent.putExtra(
                                    ResultadoActivity.EXTRA_PRESION,
                                    presion
                                ) // pero que es putExtra? que recibe?
                                intent.putExtra(ResultadoActivity.EXTRA_VOLUMEN, volumen)
                                intent.putExtra(ResultadoActivity.EXTRA_TEMPERATURA, temperatura)

                                context.startActivity(intent) // ejecuta el intent, 'abrí esa pantalla ahora'
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Calcular") }
            }
        }

        if (mensajeErrorState.isNotBlank()) {
            Text(
                text = mensajeErrorState,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}
