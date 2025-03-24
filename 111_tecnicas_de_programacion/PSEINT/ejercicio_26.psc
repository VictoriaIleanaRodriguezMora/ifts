Algoritmo ejercicio_26
	Definir ventaRefacciones, ventaServicio, ventaAutosCamiones, promedio Como Real
	Escribir  "ingrese el monto de las ventas de refacciones"
	Leer ventaRefacciones
	Escribir "ingrese el monto de las ventas de servicio"
	Leer ventaServicio
	Escribir  "ingrese el monto de las ventas de autos y camiones"
	Leer ventaAutosCamiones
	
	promedio = (ventaRefacciones + ventaServicio + ventaAutosCamiones) / 3
	
	Si(promedio >= 50000)
		Escribir "Se alcanzó el objetivo"
	Sino 
		Escribir "Buscar nuevas estrategias de ventas"
	FinSi
	
FinAlgoritmo