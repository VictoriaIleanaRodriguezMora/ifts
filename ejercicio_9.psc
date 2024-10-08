Algoritmo ejercicio_9
	
	Definir minsUser, horas, mins Como Real
	Definir tiempoTotal Como Caracter
	
	Escribir "ingrese la cantidad de minutos a convertir"
	Leer minsUser
	horas = Trunc(minsUser / 60)
	minutos = minsUser MOD 60
	
	Escribir minsUser, " minutos, son ", horas, " horas y ", minutos, " minutos " 
	
FinAlgoritmo