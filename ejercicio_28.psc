// 28. 
Algoritmo ejercicio_28
	
	Definir rangoInferior, rangoSuperior Como Entero
	rangoInferior = 500
	rangoSuperior = 700
	
	Mientras (rangoInferior < rangoSuperior)
		Si(rangoInferior % 2 <>  0)
			//Escribir rangoInferior, " es impar"
			contador = contador + 1
		FinSi
		rangoInferior = rangoInferior + 1
	FinMientras
	Escribir "Cantidad de números impares: ", contador
	
FinAlgoritmo
