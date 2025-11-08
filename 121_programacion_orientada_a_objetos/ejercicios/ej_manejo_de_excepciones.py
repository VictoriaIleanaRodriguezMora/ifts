"""
# Manejo de Excepciones en Python

1. Realiza una función llamada `agregar_una_vez(lista, elem)` que reciba una lista y
un elemento. La función debe añadir el elemento al final de la lista con la condición
de no repetir ningún elemento. Si este elemento ya se encuentra en la lista se debe
invocar un error de tipo ValueError que debes capturar y mostrar el siguiente
mensaje en su lugar:

“Error: Imposible añadir elementos duplicados => [elemento]”
En una función `main()` inicializa la lista con: elementos = [1, 5, -2], luego intenta
añadir los siguientes valores a la lista: 10, -2, "Hola". Para finalizar, muestra el
contenido de la lista.
"""


def agregar_una_vez(lista, elem):
    print("lista ", lista)
    print("elem ", elem)

    try:
        print("try ")
        if elem in lista:
            print("if ")

            raise ValueError(
                f"Error: Imposible añadir elementos duplicados => [{elem}]"
            )
        print("*try ")
        
    except ValueError as error_info:
        print("error_info", error_info) # Error: Imposible añadir elementos duplicados => [{elem}]


def main():
    elementos = [1, 5, -2]
    valores = [10, -2, "Hola"]

    # agregar_una_vez(elementos, valores) # Así no funciona porque valores es un array, no es ni 10, ni -2
    for valor in valores:
        print("valor ",valor)
        agregar_una_vez(elementos, valor)
    print("elementos ", elementos)
    return elementos

main()

"""
OUTPUT
valor  10
lista  [1, 5, -2]
elem  10
try
*try
valor  -2
lista  [1, 5, -2]
elem  -2
try
if
e Error: Imposible añadir elementos duplicados => [-2]
valor  Hola
lista  [1, 5, -2]
elem  Hola
try
*try
elementos  [1, 5, -2]
"""