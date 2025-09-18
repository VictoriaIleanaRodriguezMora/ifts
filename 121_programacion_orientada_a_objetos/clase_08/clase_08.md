# Resumen: Información sobre el Examen Parcial y Repaso de Encapsulamiento en POO (Python)

## Información sobre el Examen Parcial
- **Fecha y Hora**: Próximo jueves a las 18:30.
- **Modalidad**: Presencial, en el IFTS.
- **Contenido**: Entrarán todos los temas vistos hasta la clase actual, incluido el contenido de hoy.
- **Formato del Examen**:
  - Mayormente preguntas de opción múltiple (multiple choice).
  - Algunas preguntas pueden requerir analizar un fragmento de código y responder en función de él.
  - Puede incluir ejercicios donde deban completar una línea o sentencia de código.
- **Consejos para Estudiar**:
  - Aprovechen que el examen es de opción múltiple y que los temas vistos son pocos.
  - Repasen la teoría vista en clase y los materiales disponibles en Classroom.
  - Refuercen la práctica con los ejercicios propuestos, ya que es lo más importante.

## Repaso de Conceptos de POO (Encapsulamiento, Atributos y Métodos)

### Tipos de Atributos
- **Atributos de Instancia**:
  - Pertenecen a cada objeto (instancia) de la clase.
  - Se definen dentro del método `__init__` usando `self`.
  - Son particulares de cada instancia, por lo que su valor (estado) puede variar entre objetos.
  - Pueden ser **públicos** o **privados**. Su naturaleza (instancia) no cambia por su visibilidad.

- **Atributos de Clase**:
  - Pertenecen a la clase, no a las instancias.
  - Se definen fuera del método `__init__`, directamente dentro del cuerpo de la clase.
  - Son compartidos por todos los objetos de la clase.
  - Suelen usarse para almacenar valores constantes (aunque en Python no son inmutables por defecto).
  - Los objetos **sí pueden acceder** a los atributos de clase.
  - También pueden ser **públicos** o **privados**.

- **Atributos Dinámicos**:
  - Se crean y asignan a un objeto específico *después* de su instanciación, en tiempo de ejecución.
  - Solo existen para ese objeto en particular; otros objetos de la misma clase no los poseen.
  - **No son una buena práctica** porque rompen la estructura definida en la clase.
  - Python permite esta flexibilidad, pero otros lenguajes como Java no lo permiten.

### Encapsulamiento
- Es el principio de ocultar los detalles internos (atributos y métodos) de una clase para que no puedan ser accedidos o modificados directamente desde el exterior.
- En Python, se logra mediante una convención de nombres:
  - **Público**: Nombre normal (e.g., `atributo`, `metodo()`). Accesible desde cualquier lugar.
  - **Privado**: Nombre que comienza con doble guión bajo (e.g., `__atributo`, `__metodo()`). El intérprete de Python lo "manglea" (cambia su nombre internamente) para dificultar el acceso desde fuera de la clase. Solo accesible desde dentro de la misma clase.
- Un atributo o método privado **sí puede ser accedido por otros métodos dentro de la misma clase**.

### Métodos Especiales
- `__init__(self, ...)`: Método inicializador. Se ejecuta automáticamente al crear un nuevo objeto para inicializar sus atributos de instancia. Aunque comienza y termina con `__`, *no* es un método privado; es un método mágico con un propósito específico.
- `__str__(self)`: Método que define la representación en cadena de texto de un objeto. Cuando se hace `print(objeto)`, Python llama internamente a este método. Por defecto, imprime la dirección de memoria del objeto. Se puede sobrescribir para personalizar la salida.

### Acceso a Atributos
- **Desde un Objeto**:
  - Puede acceder a sus propios atributos de instancia (públicos).
  - Puede acceder a los atributos de clase (públicos).
- **Desde la Clase**:
  - Puede acceder a los atributos de clase (públicos).
  - **No puede acceder** directamente a los atributos de instancia, ya que estos pertenecen a los objetos, no a la clase.

### Métodos de Instancia
- Son métodos que operan sobre una instancia específica de la clase.
- Siempre tienen `self` como primer parámetro, que hace referencia al objeto que invoca el método.
- Pueden acceder y modificar los atributos de la instancia y llamar a otros métodos de la misma clase.
- `self` es una convención, no una palabra reservada, pero su uso es una práctica estándar y altamente recomendada.
- **Importante**: Aunque `__init__` tiene `self`, se considera un método inicializador con un propósito específico, no un método de instancia genérico en el contexto de algunas preguntas de examen.

### Estado de un Objeto
- El **estado** de un objeto es el conjunto de valores que tienen sus atributos en un momento dado.
- Dos objetos de la misma clase pueden tener estados diferentes si los valores de sus atributos difieren.

### Funciones Útiles
- `vars(objeto)`: Retorna un diccionario con los nombres y valores de los atributos del objeto. Es útil para inspeccionar su estado.
- `del objeto.atributo`: Permite eliminar un atributo (incluyendo los dinámicos) de un objeto en tiempo de ejecución.

### Getter y Setter
- Son métodos públicos que se utilizan para acceder (getter) y modificar (setter) de forma controlada los valores de los atributos privados. Esto permite mantener el encapsulamiento mientras se proporciona una interfaz segura para interactuar con los datos internos del objeto.