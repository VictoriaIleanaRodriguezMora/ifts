# class Clase(object): ---> Todas las clases heredan el object, ponerlo o no ponerlo es lo mismo. Entre ellas hereda el metodo __str__ que yo estoy modificando la implementacion. Sobreescribiendo el código heredado
class Clase:
    atributo_clase = "Hola"

    def __init__(self, atributo_instancia):
        self.instance_atrb = atributo_instancia


mi_clase = Clase("Que tal")
print(mi_clase.atributo_clase)      # 'Hola'
print(mi_clase.instance_atrb)  # 'Que tal'



class Circulo:
    # Atributo de clase
    PI = 3.14159

    def __init__(self, radio):
        # Atributo de instancia
        self.radio = radio

    def area(self):
        return Circulo.PI * self.radio ** 2

    def __str__(self):
        return f'Radio: {self.radio}'

c1 = Circulo(2)
print(c1.area()) # 12.56636

c2 = Circulo(3)
print(c2.area()) # 28.27431

print(Circulo.PI) # 3.14159  A los atributos de clase los puedo acceder sin una instancia de la clase

# Atributo dinámico
c1.color_fondo = "gris"
print(c1.color_fondo) # ✅ gris
# print(c2.color_fondo) # ❌

# Mostrar el valor del objeto vars y .__dict__

# Por defecto, es esto: Por eso se ve asi 
print('estado del objeto c1', c1.__str__) #  Radio: 2
print('estado del objeto c1', c1) #  Radio: 2


print('estado del objeto c1', vars(c1)) #  {'radio': 2, 'color_fondo': 'gris'}
print('estado del objeto c2', (c2).__dict__) # {'radio': 3}

# Eliminar atributos dinamicamente
del(c1.color_fondo)
print('Despues de del, estado del objeto c1', vars(c1)) #  {'radio': 2}

