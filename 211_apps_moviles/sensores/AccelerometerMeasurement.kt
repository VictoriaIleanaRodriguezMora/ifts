package com.example.sensores

// Es un objeto
// representa una medición del acelerometro
data class ObjetoAccelerometerMeasurement (
    val x: Float, // decimal
    val y: Float,
    val z: Float,
    //  System.currentTimeMillis() es el valor default
    // El Long tipo de datos puede almacenar números enteros desde -9223372036854775808 hasta 9223372036854775807.
    val timeStampMillis: Long = System.currentTimeMillis() //tiempo en segundos transcurridos desde 01/01/1970 - 1779833274
    // no entiendo para que necesito timeStampMillis
)

// el  acelerometro entrega 3 valores: eje x,y,z