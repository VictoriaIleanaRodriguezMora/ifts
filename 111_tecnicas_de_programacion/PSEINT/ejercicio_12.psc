Algoritmo ejercicio_12
    
    Definir userRadicando, userIndice, resultado Como Real 
    Escribir "Ingrese el radicando: "
    Leer userRadicando
    Escribir "Ingrese el índice de la raíz: "
    Leer userIndice
	
    Si userIndice = 0 Entonces
        Escribir "El índice no puede ser cero."
    Sino
        resultado <- userRadicando ^ (1 / userIndice)
        Escribir "La raíz ", userIndice, "-ésima de ", userRadicando, " es: ", resultado
    FinSi
FinAlgoritmo
