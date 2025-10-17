# Que es un decorador
> Es un patrón de diseño que permite modificar o extender la funcionalidad de una funcion o método existente, sin cambiar su código fuente.


> Se podría decir que son funciones que modifican la funcionalidad de otras funciones.


> Es una nueva función que toma a otra función como argumento de entrada y devuelve otra función modificada, que ya posee la funcionalidad original más la nueva.

En vez de recibir un string, un nro, un array, va a recibir el nombre de una función ya existente cómo parametro. Dentro, se va a ejecutar esa función que se recibe cómo argumento, y además se va a añadir una neuva funcionalidad.

@el_decorador_que_se_aplica
def funcion_decorada:

funcion_decorada()


# Alteran dinámicamente una funcion, método o clase sin tener que cambiar el codigo legacy para ser decoradas
Algunos casos de uso son:
- Autorización en frameworks como Flask y Django
- Logging
- Medición de ejecución de tiempo
- Sincronización


