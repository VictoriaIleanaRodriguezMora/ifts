
# Uso de Properties. Atributos como Propiedades.
# Uso del decorador @property
class Celsius:
    def __init__(self, param_temperature=0):
        # self.temperature es una invocación al metodo setter temperature de la línea 127. No necesito los () porque tiene aplicado un decorador de tipo property
        self.temperature = param_temperature # param_temperature va como 'value' del setter

    def to_fahrenheit(self):
        return (self.temperature * 1.8) + 32

    @property
    def temperature(self):
        print("Obteniendo valor...")
        return self.__temperature # este es un getter, solo retorna un valor, de un atributo privado

    @temperature.setter 
    def temperature(self, value): # acá llega param_temperature
        print("Asignando valor...")
        if value < -273.15:
            raise ValueError("La temperatura por debajo de -273° no es posible")
        self.__temperature = value # recien acá se está asignando un valor a un atributo. en este caso es privado y es una asignacion controlada


# Uso del decorador @classmethod
import math

class Circulo:
    # Atributo de clase
    __PI = 3.141592

    # Método de clase que crea una instancia
    @classmethod
    def new(cls):
        return cls() # Retorna una instancia de la clase, anónima. 

    # Método de clase
    @classmethod
    def area(cls, radio):
        return cls.__PI * math.pow(radio, 2) 
    # desde cls puedo acceder a los atributos de clase, sin tener que crear una instancia

    # Método de instancia
    def met_instancia(self):
        print("valor del atributo de clase PI:", self.__PI)
        print("Soy un método de instancia")

# Es una manera distinta de crear instancias. Distinta a la que veníamos usando
obj1 = Circulo.new() # crea una instancia de la clase anónima
obj1.met_instancia()

resultado = Circulo.area(10) # Ejecuto un método de clase sin tener una instancia de la clase
print(resultado) # 314.1592


class Calculadora:
    valor_clase = 0

    @classmethod
    def sumar_clase(cls, nro):
        cls.valor_clase += nro
        print(f"Nuevo valor de clase: {cls.valor_clase}")

# Usando el método de clase
Calculadora.sumar_clase(5)  # Modifica el valor de clase


# Uso del decorador @staticmethod  
class Calculadora:
    valor_clase = 0

    @staticmethod
    def multiplicar(x, y):
        return x * y

# Usando el método estático
resultado = Calculadora.multiplicar(2, 4)
print(f"Resultado de la multiplicación: {resultado}")
