package com.example.clase_09


import android.content.Context

data class HistorialRepository(val context: Context) {
    // Guarda datos usando SharedPreferences. crea (o abre) un archivo interno de la app
    // "historial_gases" - nombre del archivo. MODE_PRIVATE - solo mi app lo puede leer. es como un mini almacenamiento clave-valor
    private val prefSharedGuardadas = context.getSharedPreferences("historial_gases", Context.MODE_PRIVATE)

    companion object { // Sirve para definir constantes globales de la clase y acceder sin crear instancia. Paquete de constantes
        private const val CLAVE_HISTORIAL = "clave_historial"
        private const val SEPARADOR = "|*|*|"
    }

    fun agregarRegistro(registro: String) {
        // Obtiene historial actual
        val historialActual = obtenerHistorial().toMutableList()
        // Agrega el nuevo registro en el índice 0
        historialActual.add(0, registro)
        // Se queda con los últimos 5
        val ultimosCincoRegistros = historialActual.take(5)
        // Lo guarda como string
        prefSharedGuardadas.edit()
            // ["P=1", "P=2", "P=3"] - P=1|*|*|P=2|*|*|P=3
            .putString(CLAVE_HISTORIAL, ultimosCincoRegistros.joinToString(SEPARADOR))
            .apply()
    }

    // Leer historial. Es una lista de Strings
    fun obtenerHistorial(): List<String> {
        // CLAVE_HISTORIAL es "clave_historial"
        val datos = prefSharedGuardadas.getString(CLAVE_HISTORIAL, "") ?: ""
        if (datos.isBlank()) return emptyList() // devuelve una lista vacía
        // Lo vuelve lista con los datos divididos por el separador
        // datos.split("|*|*|") --> ["P=1", "P=2", "P=3"]
        return datos.split(SEPARADOR)
        // !!! SharedPreferences solo guarda strings, no listas
    }

}