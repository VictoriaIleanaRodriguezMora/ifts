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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit


//El MainActivity es el punto de entrada de mi app
// el nombre de la clase tiene que ser exactamente igual al nombre del archivo
// los : indican HERENCIA, MainActivity HEREDA de ComponentActivity
class MainActivity : ComponentActivity() {

    //Cuando crea la pantalla, ejecuta onCreate()
    // el metodo onCreate, es parte del ciclo de vida de mi activity
    // override es ANULAR. pq este metodo onCreate, existe en la clase padre, entonces lo estoy sobreescribiendo
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState) //el super, el constructor de la clase? duda?
        //Dentro de setContent le indicamos a Composable cual va a ser la interfaz que vamos a mostrar
        // seteando contenido
        setContent {
            PantallaPrincipal(nombre="IFTS 18") // defino los parametros de la funcion. le puedo dar valores por defecto
        }
    }
}


// parte grafica

@Composable
fun PantallaPrincipal(nombre: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Mensaje(texto="Hola android", tamano=30.sp, color = Color.Blue)
        Mensaje(texto="Hola android 2", tamano=25.sp, color = Color.Green)
        Mensaje(texto="Hola android 3", tamano=20.sp, color = Color.Red)
    }
}

@Composable
fun Mensaje(texto: String, tamano: TextUnit, color: Color){
    Text(
        text= texto,
        color = color,
        fontSize = tamano
    )
}






