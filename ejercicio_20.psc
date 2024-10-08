Algoritmo ejercicio_20
	Definir nroA, nroB Como Entero
	Escribir "ingrese el primer nro"
	Leer nroA
	Escribir "ingrese el segundo nro"
	Leer nroB
	
	Si (nroA == nroB) Entonces
		Escribir "El primer y el segundo nro son iguales"
	SiNo
		Si (nroA > nroB) Entonces
			Escribir "El primer nro: ", nroA, " es mayor al 2do: ", nroB
		SiNo
			Escribir "El primer nro: ", nroA, ", es menor al 2do: ", nroB
		FinSi
	FinSi	
FinAlgoritmo