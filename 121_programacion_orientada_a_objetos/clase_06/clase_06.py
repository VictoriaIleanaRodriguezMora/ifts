class Coche:
    def __init__(self, gasolina):
        self.gasolina = gasolina
        self.combustible = gasolina
        edad =  20
        print(f"Tenemos {gasolina} litros")
    
    def arrancar(self):
        # ...
        print(f"Tenemos {gasolina} litros")
        print(f"Tenemos {edad} litros")


    
    def conducir(self):
        # ...
        print(f"Tenemos {self.gasolina} litros")

class persona:
    def __init__(self, nombre, apellido):
        self.nombre_completo = nombre + '' + apellido
        edad = 20
        print(f"Tenemos {nombre} litros")
