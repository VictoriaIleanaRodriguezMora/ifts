# Decoradores 

# La intención de uso es que se reciba una función como parametro, cómo poder, puede recibir cualquier cosa. 
def saluda_antes_de_hablar(una_func):
    print('Buenas tardes') # Funcionalidad adicional
    una_func() # Comenzando a hablar

def hablar():
    print('Comenzando a hablar')

saluda_antes_de_hablar(hablar)
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
funcion_a_decorar = nuevo_decorador(funcion_a_decorar) # funcion_interna es lo que se termina asignando a funcion_a_decorar

# Esa variable, al asignarsele una funcion; Eso la convierte en una funcion que puede ser ejecutada ⬇
funcion_a_decorar() # recien aca se ejecuta funcion_interna, porque recien aca se ejecuta funcion_a_decorar(), cuyo valor es nuevo_decorador(funcion_a_decorar). Cuyo return es funcion_interna. Ahí, se ejecita funcion_interna 

print()

# @decorador
# """

def saluda_antes_de_hablar(una_func):
    print('Buenas tardes') 
    una_func() 

def hablar():
    print('Comenzando a hablar')

saluda_antes_de_hablar(hablar)
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

funcion_a_decorar() 
# """

print()
print('Clase')
print()

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
var1()

print()
print('Con decorador')
print()

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


hablar()
trabajar()

