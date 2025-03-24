Algoritmo ejercicio_32
    Dimension arregloOriginal[6]
    Dimension arregloInverso[6]    
    Para i = 1 Hasta 6 Con Paso 1
        Escribir "Ingrese la cadena de caracteres ", i, ": "
        Leer arregloOriginal[i]
    FinPara
    Para i = 1 Hasta 6 Con Paso 1
        arregloInverso[i] = arregloOriginal[6 - i + 1]
    FinPara
    Escribir "Los elementos en orden inverso son:"
    Para i = 1 Hasta 6 Con Paso 1
        Escribir arregloInverso[i]
    FinPara
FinAlgoritmo
