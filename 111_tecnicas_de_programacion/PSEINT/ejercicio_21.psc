Algoritmo ejercicio_21
    Definir nroA, nroB, nroC Como Entero
    Escribir "Ingrese el 1er n�mero"
    Leer nroA
    Escribir "Ingrese el 2do n�mero"
    Leer nroB
    Escribir "Ingrese el 3er n�mero"
    Leer nroC
    
    Si (nroA > nroB Y nroA > nroC) Entonces
        Escribir "El m�s grande entre A, B y C es A: ", nroA
	SiNo
		Si (nroB > nroA Y nroB > nroC) Entonces
			Escribir "El m�s grande entre A, B y C es B: ", nroB
		SiNo
			Escribir "El m�s grande entre A, B y C es C: ", nroC
		FinSi
	FinSi
FinAlgoritmo