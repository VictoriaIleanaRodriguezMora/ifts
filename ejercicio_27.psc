Algoritmo ejercicio_27
	Definir depto1, depto2, depto3, costoUnitario, deptoOtro Como Real
	Definir deptoUser Como Entero
	Definir nombreArticulo Como Caracter
	depto1 = 0.10
	depto2 = 0.15
	depto3 = 0.20
	otroDepto = 0.5
	Escribir "ingrese el nro de su depto"
	Leer deptoUser
	Escribir "ingrese el costo unitario"
	Leer costoUnitario
	Escribir "ingrese el nombre del articulo"
	Leer nombreArticulo
	
	Segun deptoUser Hacer
		Caso 1:
			costoUnitario = costoUnitario + (costoUnitario * depto1)
			Escribir "el nuevo costo de ", nombreArticulo, " es : $", costoUnitario
		Caso 2:
			costoUnitario = costoUnitario + (costoUnitario * depto2)
			Escribir "el nuevo costo de ", nombreArticulo, " es : $", costoUnitario
		Caso 3:
			costoUnitario = costoUnitario + (costoUnitario * depto3)
			Escribir "el nuevo costo de ", nombreArticulo, " es : $", costoUnitario
		De Otro Modo:
			costoUnitario = costoUnitario + (costoUnitario * deptoOtro)
			Escribir "el nuevo costo de ", nombreArticulo, " es : $", costoUnitario
	FinSegun
FinAlgoritmo
