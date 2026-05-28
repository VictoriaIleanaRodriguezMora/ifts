package com.example.sensores


import android.content.Context

//con esta parte, la interfaz grafica no sabe como guardar los datos, sólo sabe cómo llamarlos

// esta clase lo que va a hacer es guardar en shared preferences mi ultima medicion
class LastMeasurementPreferences(context: Context) {
    // Crea un almacenamiento tipo clave-valor (como un JSON interno)
    // sensor_prefs nombre del archivo en modo privado.
    // 'abrí este archivo sensor_prefs, si no existe crealo'
    private val sensor_prefs = context.getSharedPreferences("sensor_prefs", Context.MODE_PRIVATE)

    // Guarda datos
    // AccelerometerMeasurement
    fun guardarUltimaMedicion(medicionParam: ObjetoAccelerometerMeasurement) {
        sensor_prefs.edit()
            // putFloat para guardar decimales
            .putFloat(KEY_X, medicionParam.x) // clave - valor
            .putFloat(KEY_Y, medicionParam.y)
            .putFloat(KEY_Z, medicionParam.z)
            .putLong(KEY_TIMESTAMP, medicionParam.timeStampMillis) // put - tipo de dato
            .apply() // aplicar los cambios, los seteos de valores !
    }

    fun getUltimaMedicion(): ObjetoAccelerometerMeasurement? {

        if(!sensor_prefs.contains(KEY_TIMESTAMP)){ // esta parte no entendí
            return null
        }

       var miMedicion = ObjetoAccelerometerMeasurement (
            x = sensor_prefs.getFloat(KEY_X, 0f), // 0f es el valor que retorna por defecto, y con f marco que es float
            y = sensor_prefs.getFloat(KEY_Y, 0f),
            z = sensor_prefs.getFloat(KEY_Y, 0f),
            timeStampMillis = sensor_prefs.getLong(KEY_TIMESTAMP, 0L) // acá es long el tipo de dato
        )

        return miMedicion

    }

    companion object {
        // Sirve para definir constantes globales de la clase y acceder sin crear instancia. Paquete de constantes
        private const val KEY_X = "last_x"
        private const val KEY_Y = "last_y"
        private const val KEY_Z = "last_z"
        private const val KEY_TIMESTAMP = "last_timestamp"
    }
}