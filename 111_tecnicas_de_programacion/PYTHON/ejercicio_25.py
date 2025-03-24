costo_pediatria = 2500
costo_maternidad = 3500
costo_otro_tipo = 3000
user_atencion = input("Ingrese qué tipo de atención necesita (maternidad, pediatria, otro): ").lower()
try:
    dias_internacion = int(input("Ingrese la cantidad de días de internación: "))
except ValueError:
    print("Por favor ingrese un número válido para los días de internación.")
    dias_internacion = 0
if dias_internacion > 0:
    if user_atencion == "maternidad":
        costo_total = costo_maternidad * dias_internacion
        print(f"El costo de la internación es: ${costo_total}")
    elif user_atencion == "pediatria":
        costo_total = costo_pediatria * dias_internacion
        print(f"El costo de la internación es: ${costo_total}")
    elif user_atencion == "otro":
        costo_total = costo_otro_tipo * dias_internacion
        print(f"El costo de la internación es: ${costo_total}")
    else:
        print("No ingresaste ningún tipo de atención de los disponibles.")
else:
    print("No se pudo calcular el costo debido a un valor inválido en los días de internación.")
