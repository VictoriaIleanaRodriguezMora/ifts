package com.example.myapplication


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

// en este ejemplo la lógica esta separada del composable

class MainActivity : ComponentActivity() {

    //Cuando crea la pantalla, ejecuta onCreate()
    // el metodo onCreate, es parte del ciclo de vida de mi activity
    // override es ANULAR. pq este metodo onCreate, existe en la clase padre, entonces lo estoy sobreescribiendo
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState) //el super, el constructor de la clase? duda?
         // seteando contenido
        setContent {
            PantallaPrincipal()
        }
    }
}

// funcion de lógica
fun generarNumeroAleatorio(): Int{ // marco que va a devolver un valor de tipo entero
    // var es un contenido variable
    return Random.nextInt(from = 1, until = 101) // HASTA sin incluir
}

// parte grafica
@Composable
fun PantallaPrincipal(){ // este es el intermediario, el que está pendiente de que valorse cambian para avisarle a la vista que tiene que renderizar de nuevo
    // crea una variable que se llama numero
    // remember lo que hace es que Composable, recuerde el valor entre COMPOSICIONES
    // pq sino lo resetea. lo guarda en memoria pq lo voy a llavar en otro lado

    // de la composición PantallaPrincipal, estoy pasando la variable numero a la composicion VistaNumeroAleatorio

    // mutableStateOf indica que el valor puede cambiar
    // mutableIntStateOf es mas especifico aun acerca del valor que va a cambiar

    // numero es una variable de estado. que cambia de estado
    var numero by remember { mutableIntStateOf(value = 0) } // linea nueva

    VistaNumeroAleatorio(
        numeroVista = numero,
        onGenerarClick = { // accion que llamo cuando hago click
            numero = generarNumeroAleatorio() // es una funcion que devuelve un entero, ese entero lo estoy guardando en numeroVista = numero. al hacer = numero, estoy indicando que numeroVista es una variable de estado
        }
    )
}

// acá decido como se muestra el numero

@Composable
fun VistaNumeroAleatorio(
    numeroVista : Int, // la fn recibe como parametro un nro entero
    onGenerarClick: () -> Unit // es una fn sin parametro, que no devuelve nada y que se ejecuta al tocar el boton. Unit es un genérico
    // es una funcion lambda: una fn que recibe otra funcion como parametro.
) {
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Text (
        text = "Numero random: $numeroVista",
        fontSize = 30.sp
    )

    Button(onClick = onGenerarClick) {
        Text (
            text = "Generá tu nro",
            fontSize = 30.sp
        )
    }

  }
}


/*
se llama a numero aleatorio
se obtiene un nuevo numero
ese numero se guarda en `numero` (estado en PantallaPrincipal)
como `numero` es estado, compose recompone la interfaz en cada click y text se actualiza dinamicamente
Se vuelve a ejecutar VistaNumeroAleatorio
numeroVista recibe el nuevo valor
Text se actualiza automáticamente

generarNumeroAleatorio --> tiene la logica
pantallaNumeroAleatorio --> maneja el estado
vistaNumeroAleatorio() --> muestra la interfaz

El estado se encuentra en PantallaPrincipal.
Cuando cambia, Compose recompone la UI y pasa el nuevo valor a VistaNumeroAleatorio, que se encarga de renderizarlo.

tengo una funcion que genera el numero, una funcion que guarda el estado actual (el nuevo valor) y una funcion que lo dibuja, lo imprime. cuando el usuario toca el botón, cambia el estado y Compose lo redibuja en la interfaz con el nuevo valor


 */