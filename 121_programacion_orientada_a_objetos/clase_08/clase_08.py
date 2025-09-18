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


c1 = Circulo(2)
print(c1.area())

c2 = Circulo(3)
print(c2.area())

print(Circulo.PI)

# Atributo dinámico
c1.color_fondo = "gris"
print(c1.color_fondo) # ✅
print(c2.color_fondo) # ❌
