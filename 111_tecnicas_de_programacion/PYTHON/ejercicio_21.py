nroA = int(input("Ingrese el 1er número: "))
nroB = int(input("Ingrese el 2do número: "))
nroC = int(input("Ingrese el 3er número: "))
if nroA > nroB and nroA > nroC:
    print("El más grande entre A, B y C es A:", nroA)
elif nroB > nroA and nroB > nroC:
    print("El más grande entre A, B y C es B:", nroB)
else:
    print("El más grande entre A, B y C es C:", nroC)