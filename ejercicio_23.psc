Algoritmo ejercicio_23
	Definir montoPorHs, hsTrabajadas, hsExtras, sueldoTotal Como Entero
	Escribir "ingrese las hs de trabajo"
	Leer hsTrabajadas
	Escribir "ingrese el monto de la hs de trabajo"
	Leer montoPorHs
	
	Si(hsTrabajadas > 160)
		hsExtras = hsTrabajadas - 160
		sueldoTotal = (hsExtras * (montoPorHs * 2)) + (160 * montoPorHs)
		Escribir "El sueldo es: ", sueldoTotal
	SiNo
		sueldoTotal = hsTrabajadas * montoPorHs
		Escribir "El sueldo es: ", sueldoTotal
	FinSi
FinAlgoritmo
