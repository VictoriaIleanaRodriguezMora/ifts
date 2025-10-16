# ✅ Ejercicio 3
"""
Escribe un programa en Python que solicite al usuario 5 números enteros. Luego imprimir el máximo y el mínimo de los valores ingresados. El programa deberá permitir el ingreso de valores iguales.
"""
# """
def ej_3():
    rango_a_5 = range(0, 4) # 5 nros
    user_num = int(input("Ingresá un nro "))
    nros_ingresados = []
    for i in rango_a_5:
        user_num = int(input("Ingresá otro nro "))
        nros_ingresados.append(user_num)
    num_max = max(nros_ingresados)
    num_min = min(nros_ingresados)
    print(f"El nro maximo es {num_max} y el mínimo {num_min} ")
ej_3()
# """

# Ejercicio 4
"""
Escribe un programa en Python que solicite 5 números enteros al usuario. El mismo debe indicar si entre dichos valores hay números duplicados o no, imprimiendo por pantalla “HAY DUPLICADOS” o “SON TODOS DISTINTOS”.
"""
# """
def ej_4():
    rango_a_5 = range(0, 5) # 5 nros
    nros_ingresados = []
    son_distintos = False
    
    for i in rango_a_5:
        user_num = int(input("Ingresá otro nro "))
        nros_ingresados.append(user_num)
    
    for i in nros_ingresados:
        # i es cada elemento de mi array nros_ingresados, empezando en la posicion cero
        if i != nros_ingresados[0]:
            print(f"IF - i ", i)
            print(f"nros_ingresados[0] ", nros_ingresados[0])
            son_distintos = True
            # Acá podría poner un break, porque con que entre una vez, ya me basta. 
            # De hecho lo tengo que poner, no funciona bien sino. Y si encuentra, otro, que mas adelante/ el último sea igual, devuelve False cuando sí serian todos distintos
            break
        else:
            # Tenia un print mal aca que me estaba confundiendo
            print(f"ELSE - i ", i)
            print(f"nros_ingresados[0] ", nros_ingresados[0])
            son_distintos = False
            
    if (son_distintos):
        print("SON TODOS DISTINTOS")
        return "SON TODOS DISTINTOS"
    else:
        print("HAY DUPLICADOS")
        return "HAY DUPLICADOS"
ej_4()
# """





