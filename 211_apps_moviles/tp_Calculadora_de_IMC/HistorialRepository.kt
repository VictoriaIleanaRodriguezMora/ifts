package com.example.tp_calculadora_imc


import android.content.Context

data class HistorialRepository(val context: Context) {
    // Guarda datos usando SharedPreferences. crea (o abre) un archivo interno de la app
    // "historial_imc" - nombre del archivo. MODE_PRIVATE - solo mi app lo puede leer. es como un mini almacenamiento clave-valor
    private val prefSharedGuardadas =
        context.getSharedPreferences("historial_imc", Context.MODE_PRIVATE)

    companion object { // Sirve para definir constantes globales de la clase y acceder sin crear instancia. Paquete de constantes
        private const val CLAVE_HISTORIAL = "clave_historial"
        private const val SEPARADOR = "###SEP###"
    }

    // Leer historial. Es una lista de Strings
    fun obtenerHistorial(): List<String> {
        // CLAVE_HISTORIAL es "clave_historial"
        val datos = prefSharedGuardadas.getString(CLAVE_HISTORIAL, "") ?: ""
        if (datos.isBlank()) return emptyList() // devuelve una lista vacía
        // Lo vuelve lista con los datos divididos por el separador
        // datos.split("|*|*|") --> ["P=1", "P=2", "P=3"]
        return datos.split(SEPARADOR) // de string lo llevo a un array. Un array de strings
        // !!! SharedPreferences solo guarda strings, no listas
    }

    // tiene que guardar el registro en forma de string
    fun agregarRegistro(registro: String) {
        // Obtiene historial actual
        val historialActual = obtenerHistorial().toMutableList() // lista de strings
        historialActual.add(0, registro)  // Agrega el nuevo registro en el índice 0
        val ultimosCincoRegistros = historialActual.take(5) // Se queda con los últimos 5
        // Accedo a la data en máquina prefSharedGuardadas. Lo guarda como string
        // ["P=1", "P=2", "P=3"] - P=1|*|*|P=2|*|*|P=3
        prefSharedGuardadas.edit()
            .putString(CLAVE_HISTORIAL, ultimosCincoRegistros.joinToString(SEPARADOR))
            .apply()
    }

    // devuelve el string completo si lo encuentra, null si no
    fun buscarPorNombre(nombre: String): String? {
        // saltea el 1° actual que se acaba de guardar
        return obtenerHistorial().drop(1).find{ registro ->
            registro.contains("Nombre = $nombre")
        }
    }

}