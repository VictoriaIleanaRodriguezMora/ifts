Algoritmo ejercicio_25
	Definir Pediatria, Maternidad, OtroTipo, userAtencion Como Caracter
	Definir costoPediatria, costoMaternidad, costoOtroTipo, diasInternacion, costoTotal Como Entero
	costoPediatria = 2500
	costoMaternidad = 3500
	costoOtroTipo = 3000
	
	Escribir "ingrese que tipo de atención necesita"
	Leer userAtencion
	
	Escribir "Ingrese la cantidad de días de internación"
	Leer diasInternacion
	
	Segun userAtencion Hacer
		Caso "maternidad":
			costoTotal = costoMaternidad * diasInternacion
			Escribir "El costo de la internacion es: $", costoTotal
		Caso "pediatria":
			costoTotal = costoPediatria * diasInternacion
			Escribir "El costo de la internacion es: $", costoTotal
		Caso "otro":
			costoTotal = costoOtroTipo * diasInternacion
			Escribir "El costo de la internacion es: $", costoTotal
		De Otro Modo:
			Escribir "no ingresaste ningun tipo de caso de los disponibles"
	FinSegun

FinAlgoritmo