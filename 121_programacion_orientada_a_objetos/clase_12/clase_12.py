from abc import abstractmethod
from abc import ABCMeta

# Técnicamente es una Clase Abstracta, pero su intención de uso puede ser una Interfaz Formal
class Mando(metaclass=ABCMeta):
    # abstractmethod es si solo define el QUÉ, no el CÓMO
    # Sin @abstractmethod, por más que tenga pass, cuando se implemente Mando, no va a estar obligado a implementar el método si no se especifica @abstractmethod
    @abstractmethod
    def siguiente_canal(self):
        pass

    @abstractmethod
    def canal_anterior(self):
        pass

    @abstractmethod
    def subir_volumen(self):
        pass

    @abstractmethod
    def bajar_volumen(self):
        pass

