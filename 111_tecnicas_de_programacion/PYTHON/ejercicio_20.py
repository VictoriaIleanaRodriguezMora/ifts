nroA = int(input("Ingrese el primer número: "))
nroB = int(input("Ingrese el segundo número: "))

if nroA == nroB:
    print("El primer y el segundo número son iguales")
else:
    if nroA > nroB:
        print("El primer número:", nroA, "es mayor al segundo:", nroB)
    else:
        print("El primer número:", nroA, "es menor al segundo:", nroB)