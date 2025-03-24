Algoritmo ejercicio_21
    Definir nroA, nroB, nroC Como Entero
    Escribir "Ingrese el 1er número"
    Leer nroA
    Escribir "Ingrese el 2do número"
    Leer nroB
    Escribir "Ingrese el 3er número"
    Leer nroC
    
    Si (nroA > nroB Y nroA > nroC) Entonces
        Escribir "El más grande entre A, B y C es A: ", nroA
	SiNo
		Si (nroB > nroA Y nroB > nroC) Entonces
			Escribir "El más grande entre A, B y C es B: ", nroB
		SiNo
			Escribir "El más grande entre A, B y C es C: ", nroC
		FinSi
	FinSi
FinAlgoritmo