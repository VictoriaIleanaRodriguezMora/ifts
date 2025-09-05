# ✅ Clase 3 - Ejercicio 3
"""
Escribir una función que reciba una muestra de números en una lista y retorne su media.
"""
# """
def ej_3(array):
    suma_nros = 0
    for i in array:
        print(f"i - {i}")
        suma_nros += i
    largo_nros = len(array)        
    media_nros = suma_nros / largo_nros
    print(f"La media es: {media_nros}")
    
ej_3([3, 4, 5])
ej_3([13, 14, 15])
# """

# ✅ Clase 3 - Ejercicio 4
"""
Escribir una función que reciba una muestra de números en una lista y devuelva otra lista con sus cuadrados.
"""
# """
def ej_4(array):
    array_cuadrados = []
    for i in array:
        print(f"i - {i}")
        array_cuadrados.append(i ** 2)

    for i in array_cuadrados:
        print(f"Cuadrados: {i}")
    return array_cuadrados
    
ej_4([3, 4, 5])
# """





