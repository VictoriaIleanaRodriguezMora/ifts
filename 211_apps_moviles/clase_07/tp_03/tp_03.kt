package com.example.tp_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

// esta es la clase principal de la app de Android que hereda de componentActivity. Trabaja bien con Jetpack Compsose
class MainActivity : ComponentActivity() {
    // Sobreescribe el método onCreate, es uno de los primeros métodos que ejecuta android cómo punto de partida de la app
    // savedInstanceState puede almacenar el estado de la actividad en caso de recreación
    override fun onCreate(savedInstanceState: Bundle?) {
        // llamo a la implementación de la clase padre ComponentActivity
        super.onCreate(savedInstanceState)
        // aprovecha toda la pantalla de la app
        enableEdgeToEdge()

        // indica que la interdaz de esta actividad se va a construir con Compose. Todo lo que esté adentro define la UI
        setContent {
            // aplica el tema de material design, como bootstrap por defecto
            MaterialTheme{
                // scaffold - andamio, estructura de pantalla tipica de material
                Scaffold(modifier = Modifier.fillMaxSize()) { // le digo que ocupe todo el ancho disponible
                    // innerPadding representa los rellenos que Scaffold puede ir generando. ajusta los rellenos
                        innerPadding -> PantallaOperacionesContainer( // llamo al Composable contenedor de la pantalla (SEPARAMOS LOGICA DE LA VISTA)
                    modifier = Modifier.padding(innerPadding) //scaffold calcula un espaciado, y se lo pasa cómo parametro al modificador. DUDA: sigo sin entender que funcion cumple el modifier
                )
                    // PantallaOperacionesContainer tiene que ser un Composable en algún lado
                }
            }
        }
    }
}

// funciones - logica

// ES UN OBJETO
data class EstadoOperacion(
    // valores constantes
    val nota1: Int = 0,
    val nota2: Int = 0,
    val mensaje: String = "",

    val promedio: Int = 0,
    // val nombre_alumno: String = ""
)
fun promedio(n1: Int, n2: Int): Int{
    return (n1 + n2) / 2
}

// fn VALIDAR - PAIR devuelve un par ordenado de valores
// el signo ? es *null safe*. Pair<Int, Int>? yo indico que el valor es o Pair o null con el ?. Me aseguro que o es Pair o sí o sí es null
fun validarNros(texto1: String, texto2: String): Pair<Int, Int>? { // devuelve UN PAR DE ENTEROS. Si no, devuelve un NULL
    if (texto1.isBlank() || texto2.isBlank()) { // Si texto 1 o 2 están en blanco,
        return null
    }
    // intenta convertir los strings a nros enteros
    val n1 = texto1.toIntOrNull()
    val n2 = texto2.toIntOrNull()

    return if (n1 != null && n2 != null){
        Pair(n1, n2)
    } else {
        null
    }
}

fun validarString(nombreAlumno: String): String? {
    return if (nombreAlumno.isBlank()) null else nombreAlumno
}

fun realizarPromedio(nota1: String, nota2: String, nombre: String): EstadoOperacion{

    val nombreValido = validarString(nombre)

    if (nombreValido == null) {
        return EstadoOperacion(
            mensaje = "Ingrese un nombre válido"
        )
    }

    val numeros_o_null = validarNros(nota1, nota2) // esto es o null o el PAR de numeros
    return if (numeros_o_null == null) {
        EstadoOperacion( // a un nuevo objeto EstadoOperacion, le asigna un mensaje
            mensaje = "Ingrese dos números válidos"
        )
    } else {
        // caso que todo salió bien

        // DESESTRUCTURACIÓN
        val(n1, n2) = numeros_o_null // hace referencia a lo que devuelve. A Pair<n1, n2>

        // vuelve a crear un objeto EstadoOperacion
        EstadoOperacion(
            promedio = promedio(n1, n2), // esto cambia en cada operacion
            mensaje = "Operación resuelta"
        )
    }
}


// vuelvo a declarar un Composable. CAPA INTERMEDIA
@Composable
// defino la funcion contenedor. Es el conector de ESTADO  CON LA LOGICA DE LA VISTA
fun PantallaOperacionesContainer(modifier: Modifier = Modifier) {
    // PADRE
    /*
    Son variables que:
    Guardan datos de la UI
    Cuando cambian, Compose vuelve a dibujar la pantalla
    */

    // Declaro ESTADOS observables para los campos de textos
    // remember hace que el valor sobreviva a la recomposición del Activity. Cuando roto la pantalla, al subir un archivo
    // mutableStateOf crea un estado inicial vacío
    // BY permite usarlo como variable normal

    // ES LO QUE ESCRIBE EL USUARIO
    var nota1TextoState by remember { mutableStateOf("") }
    var nota2TextoState by remember { mutableStateOf("") }
    var nombreAlumnoState by remember { mutableStateOf("") }
    var mensajeState by remember { mutableStateOf("") }
    var resultadoState by remember { mutableIntStateOf(0) }

    // Estoy llamando al Composable de vista. Ya no tengo estados. Es el HIJO
    PantallaOperacionesView( // Una Vista
        // Empiezo a pasar parámetros. DUDA. Parametros de qué?
        // IZQ paramtero | DER estado
        nro1TextoParam = nota1TextoState, // le paso a la vista el valor de nro1Texto
        nro2TextoParam = nota2TextoState,
        nombreAlumnoParam = nombreAlumnoState,
        resultadoParam = resultadoState,
        mensajeParam = mensajeState,

        // Defino qué hacer cuando cambie el primer campo -> actualiza  el estado con el nuevo texto
        onNumero1Change = { nota1TextoState = it },
        onNumero2Change = { nota2TextoState  = it }, // AGARRA EL ESTADO
        onNombreAlumnoChange = { nombreAlumnoState  = it }, // AGARRA EL ESTADO

        // Acciones de los botones
        onPromedioClick = {
            val estadoDeOperacion = realizarPromedio(
                nota1TextoState,
                nota2TextoState,
                nombreAlumnoState
            )
            resultadoState = estadoDeOperacion.promedio
            mensajeState = estadoDeOperacion.mensaje
        },

        onLimpiarClick = {
            nota1TextoState = ""
            nota2TextoState = ""
            nombreAlumnoState = ""
            resultadoState = 0
            mensajeState = ""
        },
        // IZQ parametro de la view | DER parametro del container
        modifier = modifier// que es esto?
    )
}

// Declara la vista principal, DIBUJA LA UI
@Composable
fun PantallaOperacionesView(
    nro1TextoParam: String,
    nro2TextoParam: String,
    nombreAlumnoParam: String,
    resultadoParam: Int,
    mensajeParam: String,
    // Parámetro que recibe una función callback
    // onNumero1Change --> Qué hago cuando el número cambia?
    onNumero1Change: (String) -> Unit, // es una función que recibe un String y no devuelve nada
    onNumero2Change: (String) -> Unit, // recibo un string y devuelvo un unit
    onPromedioClick: () -> Unit, // DUDA. de donde viene?
    onNombreAlumnoChange: (String) -> Unit,
    onLimpiarClick: () -> Unit,

    // En kotlin Unit equivale a "nos devuelve un valor útil", es análogo a un VOID. Nada. Pongo algo, por poner

    // LA VISTA NO DECIDE COMO GUARDAR EL DATO. Sólo avisa que cambió el texto. El contenedor sí sabe que hacer con ese nuevo valor
    modifier: Modifier = Modifier // ??
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TP N°3: Promedio y nombre de estudiante",
            style = MaterialTheme.typography.headlineSmall
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp
        )

        OutlinedTextField( // campo de formulario. NOTA
            value = nro1TextoParam,
            onValueChange = onNumero1Change,
            label = { Text("Primera NOTA") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField( // campo de formulario. NOTA
            value = nro2TextoParam,
            onValueChange = onNumero2Change,
            label = { Text("Segunda NOTA") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField( // campo de formulario. NOMBRE ALUMNO
            value = nombreAlumnoParam,
            onValueChange = onNombreAlumnoChange,
            label = {Text("Nombre alumno: $nombreAlumnoParam") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp
        )

        Button(onClick = onPromedioClick) { // DUDA. de donde viene?
            Text("Calcular promedio")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onLimpiarClick) {
            Text("Limpiar")
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 1.dp
        )

        Text(
            text = "Resultado: $resultadoParam",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Nombre alumno: $nombreAlumnoParam",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}