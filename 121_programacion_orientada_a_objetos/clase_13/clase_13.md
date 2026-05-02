# Manejo de Excepciones en Python

Sabemos que podemos cometer ciertos errores al escribir un programa, pero también
pueden ocurrir errores aunque lo hayamos escrito correctamente. Y esto sucede
cuando intentamos ejecutarlo.

Un programa de Python finaliza tan pronto como encuentra un error no controlado.
Estos errores se pueden clasificar en:

- Errores de sintaxis
- Errores lógicos (Excepciones)

### Errores de sintaxis
Este error es causado por no seguir la estructura adecuada del lenguaje, se denomina
error de sintaxis (SyntaxError). una flecha indica dónde el analizador encontró el
error de sintaxis.

### Errores de sintaxis

Los errores que ocurren en tiempo de ejecución (después de pasar la prueba de
sintaxis) se denominan excepciones o errores lógicos.

Las excepciones en Python son mecanismos que permiten detectar errores en
tiempo de ejecución y manejarlos de manera controlada.

Cuando se produce un error en Python, se genera una excepción, que **es un objeto
de tipo `“Exception”`** que encapsula información acerca del error. 

Las excepciones pueden ser generadas por el intérprete de Python o por el propio código del programa.

> [!NOTE]
> Una excepcion es un objeto de tipo `exception`

Si no se maneja correctamente, imprime un seguimiento de ese error junto con algunos detalles sobre por qué ocurrió ese error

Por ejemplo, ocurren cuando intentamos abrir un archivo (para lectura) que no existe
(`FileNotFoundError`), intentamos dividir un número por cero (`ZeroDivisionError`) o
intentamos importar un módulo que no existe (`ImportError`).

- `TypeError`: Ocurre cuando se aplica una operación o función a un dato del tipo
inapropiado.
- `ZeroDivisionError`: Ocurre cuando se intenta dividir por cero.
- `OverflowError`: Ocurre cuando un cálculo excede el límite para un tipo de dato
numérico.
- `IndexError`: Ocurre cuando se intenta acceder a una secuencia con un índice que no
existe.
- `KeyError`: Ocurre cuando se intenta acceder a un diccionario con una clave que no
existe.
- `FileNotFoundError`: Ocurre cuando se intenta acceder a un archivo que no existe en
la ruta indicada.
- `ImportError`: Ocurre cuando falla la importación de un módulo.

## Control de excepciones `try - except - else`

## Uso de finally

permite ejecutar un determinado bloque de código siempre, se haya producido o no una
excepción. 

Se trata de un bloque muy importante, y que suele ser usado para ejecutar alguna tarea de limpieza.








