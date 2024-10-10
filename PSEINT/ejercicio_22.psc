Algoritmo ejercicio_22
	Definir montoCompra, montoConDescuento Como Real
	Escribir "ingrese el monto de la compra"
	Leer montoCompra
	Si (montoCompra >= 300)		
		montoConDescuento = montoCompra * 0.15
		Escribir "El nuevo monto con el descuento es: $", montoConDescuento		
	FinSi
FinAlgoritmo
