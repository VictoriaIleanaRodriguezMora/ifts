import random

class Password:
    LONGITUD = 8
    CARACTERES_VALIDOS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ<=>@#%&+"

    def __init__(self, paramLongitud ):
        # No entiendo, inicialmente es igual a LONGITUD, pero dsps dice que su valor es el parametro
        self.__longitud = paramLongitud
        self.__contraseña = self.generarPassword()

    # 
    def generarPassword(self):
        finalPass = ''
        for i in range(0, self.__longitud + 1):
            finalPass += random.choice(Password.CARACTERES_VALIDOS)
        print("finalPass",finalPass)
        return finalPass
    
    # esFuerte evalúa si la contraseña es segura
    def esFuerte(self):
            condicion_mas_de_1_mayuscula = 0
            condicion_1_caracter_especial = 0
            condicion_mas_de_1_minuscula = 0
            condicion_mas_de_1_numero = 0

            contra = self.__contraseña
            
            for letra in Password.CARACTERES_VALIDOS:
                for letraPass in contra:
                    if (letraPass == letra):
                        # print("letraPass == letra", letraPass)
                        if(letraPass.isupper()):
                            condicion_mas_de_1_mayuscula += 1
                            print("condicion_mas_de_1_mayuscula +1", letraPass)

                        if(letraPass.islower()):
                            condicion_mas_de_1_minuscula += 1
                            print("condicion_mas_de_1_minuscula +1", letraPass)
                        if(letraPass.isdigit()):
                            condicion_mas_de_1_numero += 1
                            print("condicion_mas_de_1_numero +1", letraPass)
                        if(not(letraPass.isupper()) and (not letraPass.islower()) and (not letraPass.isdigit()) ):
                            print("*** ", letraPass)
                            condicion_1_caracter_especial += 1
                            print("caracter especial:", letraPass)
                
            print("condicion_mas_de_1_mayuscula", condicion_mas_de_1_mayuscula)                     
            print("condicion_mas_de_1_minuscula", condicion_mas_de_1_minuscula)                     
            print("condicion_mas_de_1_numero", condicion_mas_de_1_numero)                     
            print("condicion_1_caracter_especial", condicion_1_caracter_especial)               

            if((condicion_mas_de_1_mayuscula > 1) and (condicion_mas_de_1_minuscula > 1) and (condicion_mas_de_1_numero > 1) and (condicion_1_caracter_especial >= 1)):
                return True
            else: 
                return False

    def getLongitud(self):
        print("self.__longitud",self.__longitud)
        return self.__longitud
    
    def getPassword(self):
        print("self.__contraseña",self.__contraseña)
        return self.__contraseña
    
mi_pass = Password(8)
mi_pass.getLongitud()
mi_pass.getPassword()
mi_pass.esFuerte()