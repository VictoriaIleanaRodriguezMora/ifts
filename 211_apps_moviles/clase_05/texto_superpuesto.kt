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
            Saludo("IFTS 18") // defino los parametros de la funcion. le puedo dar valores por defecto
        }
    }
}


// parte grafica

//La función saludo, como esta marcada como composable, significa que puede dibujar parte de la interfza
//Mi primer composable muestra el texto en pantalla
@Composable
fun Saludo(nombre: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            // todas estas son propiedades de este texto
            text= "ESTE ES OTRO MENSAJE", // con el signo $ toma el parametro
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }
    // box es una función, se debe importar
    Box (
        modifier = Modifier.fillMaxSize(), // hace un modificador que ocupe todo el tamaño, toda la pantalla
        contentAlignment = Alignment.Center // y todo lo que tengas adentro de esa caja, centralo
    ) {
        Text(
            // todas estas son propiedades de este texto
            text= "Hola $nombre", // con el signo $ toma el parametro
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    }
}
