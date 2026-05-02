package com.example.clase_06

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPerfil() // Cuando arranca la app, muestra la función composable
        }
    }
}

// Clase que  maneja persistencia local usando SharedPreferences
class PerfilPreferences(context: Context) {
    // Crea un almacenamiento tipo clave-valor (como un JSON interno)
    // perfil_prefs nombre del archivo en modo privado.
    // 'abrí este archivo perfil_prefs, si no existe crealo'
    private val prefs = context.getSharedPreferences("perfil_prefs", Context.MODE_PRIVATE)

    // Guarda datos
    fun guardarPerfil(nombreParam: String, emailParam: String, carreraParam: String) {
        prefs.edit() // prefs es el archivo
            .putString("nombre", nombreParam) // clave - valor
            .putString("email", emailParam)
            .putString("carrera", carreraParam)
            .apply() // aplicar los cambios, los seteos de valores !
    }

    // Leen lo guardado si no hay nada, devuelven ""
    fun obtenerNombre(): String = prefs.getString("nombre", "No se encontró valor") ?: "Falló"
    fun obtenerEmail(): String = prefs.getString("email", "No se encontró valor") ?: "Falló"
    fun obtenerCarrera(): String = prefs.getString("carrera", "No se encontró valor") ?: "Falló"
}

@OptIn(ExperimentalMaterial3Api::class) // ?
@Composable
fun PantallaPerfil() { // UI y lógica
    val context = LocalContext.current // Obtiene el contexto Android
    val perfilPrefs = remember(context) { PerfilPreferences(context) } // Crea UNA instancia de PerfilPreferences q no se recrea en cada recomposición

    // ESTADOS
    // State - USARIO ESCRIBIENDO - INPUTS
    // rememberSaveable sobrevive a rotaciones de pantalla
    var nombreState by rememberSaveable { mutableStateOf("") }
    var emailState by rememberSaveable { mutableStateOf("") }
    var carreraState by rememberSaveable { mutableStateOf("") }

    // PERSISTENCIA - Se carga desde SharedPreferences
    // remember no hace falta que sobreviva rotación porque ya está guardado
    var nombreGuardadoPreferencias by remember { mutableStateOf(perfilPrefs.obtenerNombre()) }
    var emailGuardadoPreferencias by remember { mutableStateOf(perfilPrefs.obtenerEmail()) }
    var carreraGuardadaPreferencias by remember { mutableStateOf(perfilPrefs.obtenerCarrera()) }

    var mensaje by rememberSaveable { mutableStateOf("") } // feedback: "Completa todos los campos" o "Perfil guardado correctamente"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil del estudiante") },
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
            Text(
                text = "Carga de perfil",
                style = MaterialTheme.typography.headlineMedium
            )

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {

                    OutlinedTextField(
                        value = nombreState,
                        onValueChange = { nombreState = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = emailState,
                        onValueChange = { emailState = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = carreraState,
                        onValueChange = { carreraState = it },
                        label = { Text("Carrera") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            // VALIDACIÓN
                            if (nombreState.isBlank() || emailState.isBlank() || carreraState.isBlank()) {
                                mensaje = "Completa todos los campos"
                            } else {
                                // Si tá todo OK GUARDA
                                perfilPrefs.guardarPerfil(nombreState, emailState, carreraState)

                                // Guarda en disco, vuelve a leer y actualiza el estado. Recompone UI
                                nombreGuardadoPreferencias = perfilPrefs.obtenerNombre()
                                emailGuardadoPreferencias = perfilPrefs.obtenerEmail()
                                carreraGuardadaPreferencias = perfilPrefs.obtenerCarrera()

                                mensaje = "Perfil guardado correctamente"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Guardar perfil") }

                    Button(
                        onClick = {
                            // Limpia borrador
                            nombreState = ""
                            emailState = ""
                            carreraState = ""
                            mensaje = "Borrador limpiado"
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Limpiar borrador") }
                }
            }

            if (mensaje.isNotBlank()) {
                Text(
                    text = mensaje,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Perfil guardado",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    // Muestra lo persistido
                    Text("Nombre: $nombreGuardadoPreferencias")
                    Text("Email: $emailGuardadoPreferencias")
                    Text("Carrera: $carreraGuardadaPreferencias")
                }
            }
        }
    }
}