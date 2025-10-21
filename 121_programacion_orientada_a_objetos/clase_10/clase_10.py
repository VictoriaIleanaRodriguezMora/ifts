# Decoradores 

# La intención de uso es que se reciba una función como parametro, cómo poder, puede recibir cualquier cosa. 
def saluda_antes_de_hablar(una_func):
    print('Buenas tardes') # Funcionalidad adicional
    una_func() # Comenzando a hablar

def hablar():
    print('Comenzando a hablar')

# saluda_antes_de_hablar(hablar)
# Buenas tardes
# Comenzando a hablar

# nuevo_decorador es una funcion que retorna otra funcion: funcion_interna
def nuevo_decorador(la_func): # la_func es funcion_a_decorar
    # la funcion interna es la que se retorna en nuevo_decorador
    def funcion_interna():
        print('Haciendo algo antes de llamar a la_func')
        la_func() # funcion_a_decorar()
        print('Haciendo algo despues de llamar a la_func')
    # El return es de nuevo_decorador, no de funcion_interna
    # Devuelve una función, el return, no un valor
    return funcion_interna # Sin esta línea, funcion interna no tiene uso

def funcion_a_decorar():
    print('Soy la funcion que necesita ser decorada')


# A funcion_a_decorar se la envuelve con el decorador creado

# funcion_a_decorar = nuevo_decorador(funcion_a_decorar) # funcion_interna es lo que se termina asignando a funcion_a_decorar

# Esa variable, al asignarsele una funcion; Eso la convierte en una funcion que puede ser ejecutada ⬇

# funcion_a_decorar() # recien aca se ejecuta funcion_interna, porque recien aca se ejecuta funcion_a_decorar(), cuyo valor es nuevo_decorador(funcion_a_decorar). Cuyo return es funcion_interna. Ahí, se ejecita funcion_interna 

# print()

# @decorador
# """

def saluda_antes_de_hablar(una_func):
    print('Buenas tardes') 
    una_func() 

def hablar():
    print('Comenzando a hablar')

# saluda_antes_de_hablar(hablar)

# Buenas tardes
# Comenzando a hablar

def nuevo_decorador(la_func): 
    def funcion_interna():
        print('Haciendo algo antes de llamar a la_func')
        la_func() 
        print('Haciendo algo despues de llamar a la_func')
 
    return funcion_interna 

@nuevo_decorador
def funcion_a_decorar():
    print('Soy la funcion que necesita ser decorada')

# funcion_a_decorar() 

# """

# print()
# print('Clase')
# print()

# NO decorador
def saluda_antes_de_cualquier_cosa(var_fun):
    def nueva_funcion():
        print("Buen día!")
        var_fun()
    return nueva_funcion

def hablar():
    print("Comenzando a hablar...")

def trabajar():
    print("Comenzando a trabajar...")

# var1 = saluda_antes_de_cualquier_cosa(45) # TypeError: 'int' object is not callable 
var1 = saluda_antes_de_cualquier_cosa(trabajar)
# var1()

# print()
# print('Con decorador')
# print()

# Funcion que actua como decorador
def saluda_antes_de_cualquier_cosa(var_fun):
    def nueva_funcion():
        print("Buen día!")
        var_fun()
    return nueva_funcion

@saluda_antes_de_cualquier_cosa
def hablar():
    print("Comenzando a hablar...")

@saluda_antes_de_cualquier_cosa
def trabajar():
    print("Comenzando a trabajar...")


# hablar()
# trabajar()


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



class Calculadora:
    valor_clase = 0

    @staticmethod
    def multiplicar(x, y):
        return x * y


# Usando el método estático
resultado = Calculadora.multiplicar(2, 4)
print(f"Resultado de la multiplicación: {resultado}")
