Algoritmo ejercicio_29
	Definir codigoCorrecto Como Cadena
	Definir codigoIngresado Como Cadena
	Definir intentos, i Como Entero
	Definir logueoExitoso Como L�gico
	codigoCorrecto <- 'ABC123'
	logueoExitoso <- Falso
	Escribir 'Ingrese la cantidad de intentos permitidos:'
	Leer intentos
	Para i<-1 Hasta intentos Con Paso 1 Hacer
		Escribir 'Ingrese el c�digo alfanum�rico:'
		Leer codigoIngresado
		Si codigoIngresado=codigoCorrecto Entonces
			Escribir 'Logueo Exitoso!!!'
			logueoExitoso <- Verdadero
			i <- intentos
		SiNo
			Escribir 'Verifique su c�digo y vuelva a cargarlo'
		FinSi
	FinPara
	Si logueoExitoso=False Entonces
		Escribir 'Ha sido bloqueado por superar la cantidad de intentos posibles'
	FinSi
FinAlgoritmo
