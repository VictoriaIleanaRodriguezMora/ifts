Algoritmo ejercicio_12
    
    Definir userRadicando, userIndice, resultado Como Real 
    Escribir "Ingrese el radicando: "
    Leer userRadicando
    Escribir "Ingrese el �ndice de la ra�z: "
    Leer userIndice
	
    Si userIndice = 0 Entonces
        Escribir "El �ndice no puede ser cero."
    Sino
        resultado <- userRadicando ^ (1 / userIndice)
        Escribir "La ra�z ", userIndice, "-�sima de ", userRadicando, " es: ", resultado
    FinSi
FinAlgoritmo
