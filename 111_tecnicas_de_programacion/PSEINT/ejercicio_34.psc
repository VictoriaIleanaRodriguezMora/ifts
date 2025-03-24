Algoritmo ejercicio_34
    Dimension notas[50]  
    Definir i, j, totalNotas Como Entero
    totalNotas <- 46  
    Definir seEliminoNota Como Logico
    seEliminoNota <- Falso
	Para i <- 1 Hasta totalNotas Con Paso 1 Hacer
        notas[i] <- Azar(10) + 1 // daba error pq podía dar cero un valor
    FinPara
	Repetir
        seEliminoNota <- Falso 
        Para i <- 1 Hasta totalNotas Con Paso 1 Hacer
            Si notas[i] < 4 Entonces
                Para j <- i Hasta totalNotas - 1 Con Paso 1 Hacer
                    notas[j] <- notas[j + 1]
                FinPara
                totalNotas <- totalNotas - 1
                seEliminoNota <- Verdadero
                i <- totalNotas 
            FinSi
        FinPara
    Hasta Que No seEliminoNota
    Escribir "Las notas finales de los alumnos son:"
    Para i <- 1 Hasta totalNotas Con Paso 1 Hacer
        Escribir "Alumno ", i, ": ", notas[i]
    FinPara
FinAlgoritmo
