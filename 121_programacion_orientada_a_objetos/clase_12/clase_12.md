# Uso de Properties. Atributos como Propiedades.
## @property
Python  proporciona un decorador `@property` incorporado que hace que
el uso de `getter` y `setters` sea mucho más fácil en la programación orientada a objetos.

Cualquier funcion donde se aplica el decorador @property se le agrega una funcionalidad, ¿Cual?
> `@property` es un decorador integrado para la función property() en Python. Se usa para otorgar una funcionalidad especial a ciertos métodos
> 
>  haciéndolos actuar como getter, setter o deleters al definir propiedades en una clase.

- En el init se inicializan los valores del obj 

## @classmethod
- Permite definir métodos de clase 
- Los métodos de clase permiten `acceder` y `modificar` atributos de clase,
crear nuevas instancias de la clase o manipular la clase en sí.
- Reciben como argumento `cls`, que hace referencia a la clase, en vez de `self`
- Sí **pueden modificar los atributos de clase.**
- Los métodos de clase son útiles cuando se necesita trabajar con la clase
en sí y modificar su estado o crear instancias.

> En general los métodos definidos con classmethod, de clase son utilitarios, comunes a cualquier objeto o instancia independiente de los objetos

## Si yo necesito modificar o acceder a un atributo de clase debo usar @classmethod, sino, @staticmethod

## @staticmethod
- Los métodos estáticos son útiles cuando se necesitan funciones de utilidad
que realicen una tarea de forma aislada,
- Los métodos estáticos se utilizan para realizar tareas que no dependen del estado de la clase o de las instancias.
- Para invocarlos no es necesario tener una instancia de una clase para llamar a un método estático; simplemente podemos llamarlo directamente desde el nombre de la clase.


# Resumen de métodos de instancia, de clase y estáticos

- Los métodos de instancia necesitan una instancia de una clase y pueden
acceder dicha instancia por medio de self.
- Los métodos de clase no necesitan una instancia de una clase. Ellos no
pueden acceder a la instancia (self), pero tienen acceso a la clase por medio
de cls.
- Los métodos estáticos no tienen acceso a cls o self. Ellos trabajan como funciones regulares pero pertenecen al namespace de la clase.
- Los métodos estáticos y de clase son útiles al momento de diseñar una clase, estos tienen muchos beneficios en el mantenimiento y lectura del código. Los **métodos de clase están vinculados a la clase** y pueden modificar su estado, mientras que los **métodos estáticos son funciones de utilidad** sin acceso al estado de la clase.


