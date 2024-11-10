try:
    venta_refacciones = float(input("Ingrese el monto de las ventas de refacciones: "))
    venta_servicio = float(input("Ingrese el monto de las ventas de servicio: "))
    venta_autos_camiones = float(input("Ingrese el monto de las ventas de autos y camiones: "))
except ValueError:
    print("Por favor, ingrese valores numéricos válidos.")
    venta_refacciones = 0
    venta_servicio = 0
    venta_autos_camiones = 0

promedio = (venta_refacciones + venta_servicio + venta_autos_camiones) / 3

if promedio >= 50000:
    print("Se alcanzó el objetivo")
else:
    print("Buscar nuevas estrategias de ventas")
