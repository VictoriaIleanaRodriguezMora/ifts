package com.example.tp_calculadora_imc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp_calculadora_imc.ui.theme.TP_calculadora_IMCTheme
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.jvm.java
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP_calculadora_IMCTheme {
                ViewContainer()
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewContainer() {
    // Cuando uso Scaffold, Android dice 'Che, tengo un TopAppBar arriba así que voy a dejar un espacio para que el contenido no quede escondido abajo de eso'
    // Ese 'espacio' me lo da en una variable  llamada innerPadding
    // Si no lo uso, el Content queda debajo del toolbar por eso no se veía
    Scaffold(
        modifier = Modifier.fillMaxSize(), // se crea el Modifier
        // andamio. molde. me permite controlar qué componentes se muestran
        topBar = { Toolbar() }
    ) { padding -> // recibo el espacio
        Content(ScaModifier = Modifier.padding(padding)) // le aplico el espacio
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text("Victoria Rodriguez TP", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.teal_700) // fondo
        )
    )
}

fun validarPesoAltura(
    pesoUser: String,
    alturaUser: String
): Pair<Int, Int>? { // devuelve UN PAR DE ENTEROS. Si no, devuelve un NULL

    if (pesoUser.isBlank() || alturaUser.isBlank()) { // si alguno de los 2 está en blanco
        return null
    }

    val n1 = pesoUser.toIntOrNull()
    val n2 = alturaUser.toIntOrNull()

    return if (n1 != null && n2 != null) {
        Pair(n1, n2)
    } else {
        null
    }
}

fun imc(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

@Composable
fun Content(ScaModifier: Modifier = Modifier) { // 'Si no me pasa nada, uso un Modifier vacío'
    //  USARIO ESCRIBIENDO - INPUTS
    // rememberSaveable sobrevive a rotaciones de pantalla
    var nombreUserState by rememberSaveable { mutableStateOf("") }
    var pesoKgUserState by rememberSaveable { mutableStateOf("") }
    var alturaMtsUserState by rememberSaveable { mutableStateOf("") }

    var imcResultadoState by rememberSaveable { mutableStateOf<Double?>(null) }

    // Estado de error
    var errorMensajeState by rememberSaveable { mutableStateOf<String?>(null) }

    // CONTEXTO DE LA APP
    val context = LocalContext.current

    // INPUTS - reciben VALUE y onValueChange sí o si
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = ScaModifier // uso el margen que me da scaffold
            .fillMaxSize()
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        Text(
            text = "Calculadora de IMC",
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            // modifier = Modifier.fillMaxWidth() // con esto puesto, no me lo centraba poqrue estaba ocupando el 100% del ancho.
            //   textAlign = TextAlign.Center //, si dejaba la prop de arriba, tenia que dejar esta tambien
        )
        Text(
            text = "Ingrese sus datos porfavor",
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        // Campo nombre
        TextField(
            value = nombreUserState,
            onValueChange = { nombreUserState = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.padding(bottom = 15.dp)
        )
        // Campo peso
        TextField(
            value = pesoKgUserState,
            onValueChange = { pesoKgUserState = it },
            label = { Text("Ingrese su peso (KG)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(bottom = 15.dp)
        )
        // Campo altura
        TextField(
            value = alturaMtsUserState,
            onValueChange = { alturaMtsUserState = it },
            label = { Text("Ingrese su altura (MTS)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(bottom = 15.dp)
        )

        Button(onClick = {

            val pesoDecimalONulo = pesoKgUserState.replace(',', '.').toDoubleOrNull()
            val alturaDecimalONulo = alturaMtsUserState.replace(',', '.').toDoubleOrNull()

            if (pesoKgUserState.isBlank() || alturaMtsUserState.isBlank() || nombreUserState.isBlank()) {
                errorMensajeState = "Ingrese todos los datos VÁLIDOS"
            } else if (pesoDecimalONulo != null && pesoDecimalONulo <= 0) {
                errorMensajeState = "El peso debe ser mayor a cero"
            } else if (alturaDecimalONulo != null && alturaDecimalONulo <= 0) {
                errorMensajeState = "La altura debe ser mayor a cero"
            }

            // caso feliz - Navegación a otra pantalla - otro activity
            else {
                errorMensajeState = null

                if (pesoDecimalONulo != null && alturaDecimalONulo != null) {
                    val resultado = imc(pesoDecimalONulo, alturaDecimalONulo)
                    imcResultadoState = resultado
                }

                val intentActivityRtado = Intent(context, ResultadoActivity::class.java)
                // mando datos
                intentActivityRtado.putExtra(ResultadoActivity.EXTRA_PESO, pesoDecimalONulo)
                intentActivityRtado.putExtra(ResultadoActivity.EXTRA_ALTURA, alturaDecimalONulo)
                intentActivityRtado.putExtra(ResultadoActivity.EXTRA_NOMBRE, nombreUserState)
                intentActivityRtado.putExtra(ResultadoActivity.EXTRA_IMC, imcResultadoState ?: 0.0)

                // si todo sale bien, iniciame este activity. AL HACER CLICK EN EL BOTÓN
                // ejecuta el intent, 'abrí esa pantalla ahora'
                context.startActivity(intentActivityRtado)
            }

        }) { Text("Calcular IMC") }

        if (errorMensajeState != null) {
            Text("$errorMensajeState")
        }

    }
}
