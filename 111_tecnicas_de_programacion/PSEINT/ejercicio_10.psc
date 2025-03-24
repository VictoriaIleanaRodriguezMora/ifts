Algoritmo ejercicio_10
	Definir radicando, indice, resultado Como Real
	
	Escribir "Ingresa el radicando (número del cual quieres obtener la raíz):"
	Leer radicando
	
	Escribir "Ingresa el índice de la raíz (2 para raíz cuadrada, 3 para cúbica, etc.):"
	Leer indice
	
	resultado = radicando^(1/indice) 
	// Esto es por ejemplo: 25 elevado a la: (1/2)
	Escribir "La raíz ", indice, " de ", radicando, " es: ", resultado
	
FinAlgoritmo