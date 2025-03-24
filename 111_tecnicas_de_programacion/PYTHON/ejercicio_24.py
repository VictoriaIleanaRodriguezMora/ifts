valor30kw = 6.03
valor90kw = 6.19
valor80kw = 6.78
valorsig200kw = 7.24
costoTotal = 0
kwUser = float(input("Ingrese los kW consumidos: "))
if kwUser <= 30:
    costoTotal = kwUser * valor30kw
    print("El costo es: $", costoTotal)
elif kwUser <= 120:
    costoTotal = (30 * valor30kw) + ((kwUser - 30) * valor90kw)
    print("El costo es: $", costoTotal)
elif kwUser <= 200:
    costoTotal = (30 * valor30kw) + (90 * valor90kw) + ((kwUser - 120) * valor80kw)
    print("El costo es: $", costoTotal)
else:
    costoTotal = (30 * valor30kw) + (90 * valor90kw) + (80 * valor80kw) + ((kwUser - 200) * valorsig200kw)
    print("El costo es: $", costoTotal)