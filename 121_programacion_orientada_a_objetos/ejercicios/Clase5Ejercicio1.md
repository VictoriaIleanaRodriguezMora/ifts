# Consigna 

Ejercicio POO con encapsulamiento y uso de atributos de instancia y de clase

- Crear una clase llamada Password con las siguientes condiciones:
1. Dos `atributos` de _`clase`_ **privados**:
   
`LONGITUD`. Cuyo valor sea ```8``` (numérico).
   
`CARACTERES_VALIDOS`. Cuyo valor sea
`"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ<=>@#%
&+"`

1. Dos `atributos` de _`instancia`_ **privados**:

`longitud`. Por defecto, será igual al valor del atributo de clase LONGITUD. Y su valor no
podrá ser inferior a 6 caracteres ni mayor a 15 caracteres.

`contraseña`. Su valor aleatorio deberá ser asignado en el método `generarPassword()`.

3. Un método inicializador de instancias, con el parámetro longitud cuyo valor _se asignará al atributo de **instancia**_. 
`Generará` una contraseña aleatoria con esa longitud invocando al método generarPassword().

4. Dos métodos de instancia públicos, cuya implementación deberá ser:
   
`esFuerte()`: devuelve un booleano si es fuerte o no. Para que sea fuerte debe tener:
   - más de 1 mayúscula
   - 1 carácter especial
   - más de 1 minúscula 
   - más de 1 números.

`generarPassword()`: genera la contraseña del objeto cuyo valor de tipo string tendrá una longitud igual al valor del atributo de instancia “longitud”. Para la generación de la clave puede usar los métodos random.choice() y string.join() de Python.

- Incluir métodos `públicos` que permitan obtener y asignar valores (`getters y setters`) a los
atributos de instancia privados.

- Sobreescribir el método de instancia __str__(), para que retorne la clave generada y el valor booleano que devuelve el método “es_fuerte()”.
Luego, agregar sentencias de código Python que permitan:
1. Crear una lista de objetos de tipo Password.
   
2. Crear instancias de Password y agregarlas a la lista. Para cada objeto, se debe ingresar la
longitud de la clave por teclado. Si el valor ingresado es cero, no se pasará ningún valor
como argumento al método inicializador.

1. Mostrar cada una de las contraseñas creadas y si es o no fuerte (usar un bucle). Para ello,
usar este simple formato:
contraseña1 - valor_booleano1
contraseña2 - valor_bololeano2
