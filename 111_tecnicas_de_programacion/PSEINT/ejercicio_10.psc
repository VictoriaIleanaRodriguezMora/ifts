Algoritmo ejercicio_10
	Definir radicando, indice, resultado Como Real
	
	Escribir "Ingresa el radicando (n�mero del cual quieres obtener la ra�z):"
	Leer radicando
	
	Escribir "Ingresa el �ndice de la ra�z (2 para ra�z cuadrada, 3 para c�bica, etc.):"
	Leer indice
	
	resultado = radicando^(1/indice) 
	// Esto es por ejemplo: 25 elevado a la: (1/2)
	Escribir "La ra�z ", indice, " de ", radicando, " es: ", resultado
	
FinAlgoritmo