Algoritmo ejercicio_28
	
    Definir rangoInferior, rangoSuperior, contador Como Entero
    rangoInferior = 500
    rangoSuperior = 700
    contador = 0
	
    Si (rangoInferior < rangoSuperior) Entonces
        Mientras (rangoInferior <= rangoSuperior) Hacer
            Si (rangoInferior % 2 <> 0) Entonces
                Escribir rangoInferior, " es impar"
                contador = contador + 1
            FinSi
            rangoInferior = rangoInferior + 1
        FinMientras
    Sino // Este else es por si el 1er número que ingresara un usuario fuera 
		// menor que el segundo nro. Así el código se ejecutaría sin errores.
        Mientras (rangoInferior >= rangoSuperior) Hacer
            Si (rangoInferior % 2 <> 0) Entonces
                Escribir rangoInferior, " es impar"
                contador = contador + 1
            FinSi
            rangoInferior = rangoInferior - 1
        FinMientras
    FinSi
	
    Escribir "Cantidad de números impares: ", contador
	
FinAlgoritmo