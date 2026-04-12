    package com.example.clase_05

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
    import androidx.compose.material3.Divider
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
    import kotlin.random.Random
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
                            modifier = Modifier.padding(innerPadding) //scaffold calcula un espaciado, y se lo pasa cómo parametro al modificador. DUDA: sigo sin entender qupe funcion cumple el modifier
                         )
                        // PantallaOperacionesContainer tiene que ser un Composable en algún lado
                    }
                }
            }
        }
    }

    // funciones - logica

    // declaro un data class que se llama EstadoOperacion. agrupa el rtado  de una operación, el nombre, resultado, etc.
    // me sirve para devolver varios valores juntos
    // ES UN OBJETO
    data class EstadoOperacion( // OBJETO
        // valores constantes
        val resultado: Int = 0,
        val ultimaOperacion: String = "Ninguna",
        val mensaje: String = ""
    )

    fun sumar(n1: Int, n2: Int): Int{
        return n1 + n2
    }

    fun restar(n1: Int, n2: Int): Int{
        return n1 - n2
    }

    fun multiplicar(n1: Int, n2: Int): Int{
        return n1 * n2
    }

    // Forma resumida
    /* fun restar(n1: Int, n2: Int): Int = n1 - n2 */

    fun generarNroRandom(): Int{
        return Random.nextInt(1, 11) // 1 - 10
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

    // fn realizarSuma es de más alto nivel, porque dentro usa una que ya declaramos antes. EstadoOperacion es un OBJETO
    fun realizarSuma(texto1: String, texto2: String): EstadoOperacion {
        val numeros_o_null = validarNros(texto1, texto2) // esto es o null o el PAR de numeros
        return if (numeros_o_null == null) {
            // caso que es null
            EstadoOperacion( // a un nuevo objeto EstadoOperacion, le asigna un mensaje
                    mensaje = "Ingrese dos números válidos"
                )
            } else {
                // caso que todo salió bien

                // DESESTRUCTURACIÓN
                val(n1, n2) = numeros_o_null // hace referencia a lo que devuelve. A Pair<n1, n2>

            // vuelve a crear un objeto EstadoOperacion
                EstadoOperacion(
                    resultado = sumar(n1, n2), // esto cambia en cada operacion
                    ultimaOperacion = "Suma",
                    mensaje = "Operación resuelta"
                )
            }
    }

    // vuelvo a declarar un Composable. CAPA INTERMEDIA
    @Composable // funcion dibujable
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
        var nro1Texto by remember { mutableStateOf("") }
        var nro2Texto by remember { mutableStateOf("") }
        var resultado by remember { mutableIntStateOf(0) }
        var mensaje by remember { mutableStateOf("") }
        var ultimaOperacion by remember { mutableStateOf("") }

        // Estoy llamando al Composable de vista. Ya no tengo estados. Es el HIJO
        PantallaOperacionesView( // Una Vista
            // Empiezo a pasar parámetros. DUDA. Parametros de qué?
            // IZQ paramtero | DER estado
            nro1TextoParam = nro1Texto, // le paso a la vista el valor de nro1Texto
            nro2TextoParam = nro2Texto,
            resultado = resultado,
            ultimaOperacion = ultimaOperacion,
            mensaje = mensaje,

            // Defino qué hacer cuando cambie el primer campo -> actualiza  el estado con el nuevo texto
            onNumero1Change = {
                nro1Texto = it
            }, // It: agarrá eso, lo que se está escribiendo y asignaselo a nro1Texto. AGARRA EL ESTADO
            onNumero2Change = { nro2Texto = it }, // AGARRA EL ESTADO

            // Acciones de los botones
            onSumarClick = {
                // Llama a la lógica.
                // A realizarSuma, yo le tengo que pasar 2 paramétros, de donde los saco? Del composable
                // realizarSuma DEVUELVE UN ESTADO DE OPERACION
                val estadoDeOperacion = realizarSuma(
                    nro1Texto,
                    nro2Texto
                ) // esto cambia en las distintas operaciones
                resultado = estadoDeOperacion.resultado // estan usando, sacando los valores de la variable de arriba
                ultimaOperacion = estadoDeOperacion.ultimaOperacion
                mensaje = estadoDeOperacion.mensaje

            },

            onLimpiarClick = {
                nro1Texto = ""
                nro2Texto = ""
                resultado = 0
                ultimaOperacion = "Ninguna"
                mensaje = ""
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
        resultado: Int,
        ultimaOperacion: String,
        mensaje: String,

        // Parámetro que recibe una función callback
        // onNumero1Change --> Qué hago cuando el número cambia?
        onNumero1Change: (String) -> Unit, // es una función que recibe un String y no devuelve nada
        onNumero2Change: (String) -> Unit, // recibo un string y devuelvo un unit
        onSumarClick: () -> Unit, // DUDA. de donde viene?
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
                text = "App de operaciones",
                style = MaterialTheme.typography.headlineSmall
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )

            OutlinedTextField( // campo de formulario
                value = nro1TextoParam,
                onValueChange = onNumero1Change,
                label = { Text("Primer número") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )

            OutlinedTextField( // campo de formulario
                value = nro2TextoParam,
                onValueChange = onNumero2Change,
                label = { Text("Segundo número") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )

            Button(onClick = onSumarClick) { // DUDA. de donde viene?
                Text("Sumar")
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
                text = "Resultado: $resultado",
                style = MaterialTheme.typography.headlineMedium
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )
            Text(
                text = "Última operación: $ultimaOperacion",
                style = MaterialTheme.typography.bodyLarge
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )

            Text(
                text = mensaje,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }