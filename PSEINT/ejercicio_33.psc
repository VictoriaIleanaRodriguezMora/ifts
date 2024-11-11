Algoritmo ejercicio_33
    Dimension notas[50]
    Definir i Como Entero
    Para i = 1 Hasta 45 Con Paso 1
        notas[i] <- Azar(10) 
    FinPara
    Escribir "Ingrese la nota del alumno 46: "
    Leer notas[46]
	Escribir "Las notas de los alumnos son:"
    Para i = 1 Hasta 46 Con Paso 1
        Escribir "Alumno ", i, ": ", notas[i]
    FinPara
FinAlgoritmo
