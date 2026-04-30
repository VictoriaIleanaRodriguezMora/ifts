package com.example.tp_calculadora_imc

import android.annotation.SuppressLint
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun Content(
    ScaModifier: Modifier = Modifier,
) { // 'Si no me pasa nada, uso un Modifier vacío'

    // ********** ESTADOS *********

    //  USARIO ESCRIBIENDO - INPUTS
    // rememberSaveable sobrevive a rotaciones de pantalla
    var nombreUserState by rememberSaveable { mutableStateOf("") }
    var pesoKgUserState by rememberSaveable { mutableStateOf("") }
    var alturaMtsUserState by rememberSaveable { mutableStateOf("") }

    var imcResultadoState by rememberSaveable { mutableStateOf<Double?>(null) }
    // Estado de error
    var errorMensajeState by rememberSaveable { mutableStateOf<String?>(null) }

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
        Spacer(modifier = Modifier.padding(bottom = 8.dp))
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
            /*
            val peso_altura_o_null = validarPesoAltura(pesoKgUserState, alturaMtsUserState)
            if (peso_altura_o_null == null) {
                errorMensajeState =
                    "Ingrese Peso y altura VÁLIDOS" // Un Button no puede devolver un String.
                // onClick es solo una acción (side effect)
            } else {
                errorMensajeState = null
                val (pesoFn, alturaFn) = peso_altura_o_null // desestructuracion
                imcResultadoState = pesoFn / (alturaFn * alturaFn)
            }
            */

            if (pesoKgUserState.isBlank()){
                errorMensajeState = "Ingrese Peso VÁLIDO"
            } else if (alturaMtsUserState.isBlank()) {
                errorMensajeState = "Ingrese altura VÁLIDA"
            } else if(pesoKgUserState.toIntOrNull() == null){
                errorMensajeState = "Ingrese un NÚMERO para el Peso"
            }  else if(alturaMtsUserState.toIntOrNull() == null){
                errorMensajeState = "Ingrese un NÚMERO para la altura"
            }
            else {
                errorMensajeState = null

                val peso = pesoKgUserState.toDoubleOrNull()
                val altura = alturaMtsUserState.toDoubleOrNull()

                if (peso != null && altura != null) {
                    val resultado = imc(peso, altura)
                    imcResultadoState = resultado
                }
            }

        }) {
            Text("Calcular IMC")
        }

        if (imcResultadoState != null) {
            Text(
                text = "Tu IMC es: $imcResultadoState",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp)
            )
        }

    }
}
