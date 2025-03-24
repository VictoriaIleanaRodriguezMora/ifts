montoCompra = float(input("Ingrese el monto de la compra: "))
if montoCompra >= 300:
    montoConDescuento = montoCompra * 0.85  # Aplica un descuento del 15%
    print("El nuevo monto con el descuento es: $", montoConDescuento)
else:
    print("No se aplica descuento, el monto es: $", montoCompra)