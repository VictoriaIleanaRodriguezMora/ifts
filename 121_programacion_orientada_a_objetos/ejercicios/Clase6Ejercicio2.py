class Persona:
    def __init__(self, p_edad, p_nombre, p_dni):
        # self. invocan a los setters
        self.edad = p_edad 
        self.nombre  = p_nombre 
        self.dni = p_dni 

    def mostrar_edad(self):
        print("Método mostrar_edad")
        return self.edad

    def es_mayor_edad(self):
        print("Método es_mayor_edad")
        la_edad = self.edad
        if (la_edad > 18):
            return True
        
        return False

    @property
    def edad(self):
        print("Retorno la edad: ")
        return self.__edad # este es un getter, solo retorna un valor, de un atributo privado
        
    def edad(self, value): 
        print("Asigno la edad: ")
        self.__edad = value # asigna valor

    @property
    def nombre(self):
        print("Retorno el nombre: ")
        return self.__nombre 
        
    def nombre(self, value): 
        print("Asigno el nombre: ")
        self.nombre = value # asigna valor


    @property
    def dni(self):
        print("Retorno el dni: ")
        return self.__dni 
        
    def dni(self, value): 
        print("Asigno el dni: ")
        self.dni = value # asigna valor



    

persona = Persona(25, "Victoria", 12345678)
print(persona.mostrar_edad())
print(persona.es_mayor_edad())