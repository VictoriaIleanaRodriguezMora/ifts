Algoritmo ejercicio_31
    Dimension numeros[25]  
    Definir suma, promedio Como Real
    suma = 0  
	
	Para i = 1 Hasta 25 Con Paso 1
        numeros[i] = AZAR(100) + 1 
		Escribir  "El n�mero aleatorio es ", numeros[i]
        suma = suma + numeros[i]    
    FinPara
	
    promedio = suma / 25
	
    Escribir "La suma de los n�meros es: ", suma
    Escribir "El promedio de los n�meros es: ", promedio
FinAlgoritmo
