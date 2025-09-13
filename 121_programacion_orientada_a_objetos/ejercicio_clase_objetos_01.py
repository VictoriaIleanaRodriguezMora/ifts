"""
Crear una clase llamada Persona.
Con los siguientes atributos privados:
•nombre
•edad
•dni
Y los siguientes métodos públicos:
•mostrar_edad(): retorna la edad de la persona
•es_mayor_edad(): retorna True si edad es mayor o igual a 18, o False si es menor a 18.
El método constructor __init__ de la clase debe recibir y asignar los valores a cada uno de los atributos privados de la clase.
"""

class Persona:
    # Atributos de Clase
    # nombre_mascota = 'Firulais'
    # Persona.nombre_mascota
    
    # Metodo Constructor. Inicializa y define los parametros 
    def __init__(self, nombre, edad, dni):
        # Atributos de instancia. Solo pueden ser accedidos dentro de la clase
        self.__nombre = nombre
        self.__edad = edad
        self.__dni = dni

    # Metodos publicos, que usan atributos privados
    def mostrar_edad(self):
        return self.__edad

    def es_mayor_edad(self):
        return self.__edad >= 18



