class Ejemplo:
    def met_publico(self):
        print("Público")
    def __met_privado(self):
        print("Privado")

ej = Ejemplo()
ej.met_publico()
# ej.__met_privado() # AttributeError: 'Ejemplo' object has no attribute '__met_privado'


class Fecha():
    def __init__(self):
        self.__dia = 1
    def getDia(self):
        return self.__dia
    def setDia(self, diaParam):
        if diaParam > 0 and diaParam < 31:
            self.__dia = diaParam
            print(f"Día {diaParam} asignado")
        else:
            print("Error")

mi_fecha = Fecha()
mi_fecha.setDia(33)
mi_fecha.setDia(2) # Día 2 asignado
# mi_fecha.__dia = (33) # Error

print((mi_fecha)) # <__main__.Fecha object at 0x00000280B8D26BA0>


