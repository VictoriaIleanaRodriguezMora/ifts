Intentá convertir. Si falla usá 0 por defecto
"123".toIntOrNull()   // → 123
"0".toIntOrNull()     // → 0
"-5".toIntOrNull()    // → -5
"abc".toIntOrNull()   // → null
"12.5".toIntOrNull()  // → null
"".toIntOrNull()      // → null

"abc".toInt() // CRASHEA la app (lanza excepción)

una forma más optima sería una fn que reciba qué operación se quiere acer, compare en un objeto y ejecuta la funcion correspondiente a la opracion ingresada