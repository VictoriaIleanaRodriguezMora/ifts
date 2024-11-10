try:
    hs_trabajadas = int(input("Ingrese las horas de trabajo: "))
    monto_por_hs = int(input("Ingrese el monto por hora de trabajo: "))
except ValueError:
    print("Por favor, ingrese valores numéricos válidos.")
    hs_trabajadas = 0
    monto_por_hs = 0
if hs_trabajadas > 160:
    hs_extras = hs_trabajadas - 160
    sueldo_total = (hs_extras * (monto_por_hs * 2)) + (160 * monto_por_hs)
else:
    sueldo_total = hs_trabajadas * monto_por_hs

print("El sueldo es: ${sueldo_total}")
