# ✅ Clase 3 - Ejercicio 1
"""
Escribir una función que permita calcular la duración en segundos de un intervalo dado en horas, minutos y segundos.
"""
# """
def c03_ej1(hs, mins, segs):
    hs_a_segs = hs * 3600
    mins_a_segs = mins * 60
    segs_totales = hs_a_segs + mins_a_segs + segs
    print(f"La duracion en segundos es: {segs_totales}")

c03_ej1(1, 15, 30)
# """

# ✅ Clase 3 - Ejercicio 2
"""
Usando la función del ejercicio anterior, escribir un programa que pida al usuario dos intervalos expresados en horas, minutos y segundos, sume sus duraciones, y muestre por pantalla la duración total en horas, minutos y segundos.
"""
# """
def c03_ej4(arr):
    hs_a_segs = 0
    mins_a_segs = 0
    segs = 0
    
    for i in arr:
        print(f"i", i)
        print(f"i[0]", i[0]) # hs
        print(f"i[1]", i[1]) # mins
        print(f"i[2]", i[2]) # segs
        hs_a_segs += i[0] * 3600
        mins_a_segs += i[1] * 60
        segs += i[2]
    
    segs_totales = hs_a_segs + mins_a_segs + segs
    print(f"La duracion en segundos es: {segs_totales}")

c03_ej4([[1, 15, 30], [2, 33, 40]])
# """





