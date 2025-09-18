# Clase 05

### Estructuras de programación:

- Secuenciales

- Decisión: if, match (equivalente a switch en otros lenguajes).

- Iteración: while, for.
- 
- while: cuidado con los bucles infinitos → siempre modificar las variables de la condición.
  
- for: recorre elementos de una colección, generalmente conocemos de antemano la cantidad de iteraciones.

###  Tipos de datos y variables:

Python es de tipado dinámico:
- No es necesario declarar el tipo de la variable.

- El tipo se asigna automáticamente según el valor que recibe en el momento de la asignación.

### Funciones:

- Vimos funciones de la librería estándar: len(), max(), min(), print(), random (requiere import).

- Podemos crear funciones propias usando def.
 
- Se pueden definir argumentos con valores por defecto, argumentos variables, etc.

## Programación Orientada a Objetos (POO)
### Clases y Objetos

> Clase: plantilla genérica que define atributos y métodos.

> Objeto: entidad que surge de una clase, con:

> Estado → atributos (variables).

> Funcionalidad → métodos (funciones dentro de la clase).

### Definición de una clase en Python
```py
class Coche:
    def __init__(self, gasolina):
        self.gasolina = gasolina
        print(f"Tenemos {gasolina} litros")
    
    def arrancar(self):
        ...
    
    def conducir(self):
        ...
```
    

> Palabra reservada: class.

Nombre de la clase:
- Singular.
- Primera letra en mayúscula (buena práctica).
- Cuerpo identado, como en cualquier estructura Python.

### Métodos

> Una función dentro de una clase se denomina método.

> Método especial __init__:

Se ejecuta automáticamente al crear (instanciar) un objeto.
- Se usa para inicializar atributos.
- Siempre recibe el primer parámetro self.
- Ejemplo de atributos:

```py
self.gasolina = gasolina → asigna el valor recibido al atributo del objeto.
```

> Diferencia entre gasolina (variable local del método) y self.gasolina (atributo del objeto).

> Al terminar el método, las variables locales desaparecen, pero los atributos permanecen en memoria mientras viva el objeto.

### El parámetro self

- No es palabra reservada, pero se usa por  convención.
- Refiere al objeto actual.
- Permite acceder a sus atributos y métodos.
- No se le pasa ningún valor al crear el objeto (Python lo gestiona automáticamente).

### Instanciación de objetos

- Crear un objeto = usar el nombre de la clase con paréntesis.

- Los argumentos dentro de los paréntesis se envían al método __init__.

Ejemplo:
```py
mi_coche = Coche(3)
```
Proceso:

1) Se ejecuta lo que está a la derecha (Coche(3)).

2) Se llama automáticamente a __init__ → asigna self.gasolina = 3.

3) Se imprime: "Tenemos 3 litros".

4) Finaliza __init__, desaparece la variable local gasolina, pero queda self.gasolina = 3 como atributo.

5) Finalmente, el objeto creado se asigna a la variable mi_coche.