Algoritmo conversion_de_tiempo
	
	Definir minsUser Como Entero
	Definir horas Como Entero
	Definir minutos Como Entero
	
	Escribir "Ingrese la cantidad de minutos a convertir:"
	Leer minsUser
	
	horas = Trunc(minsUser / 60)
	minutos = minsUser MOD 60
	
	Escribir minsUser, " minutos son ", horas, " horas y ", minutos, " minutos."
	
FinAlgoritmo