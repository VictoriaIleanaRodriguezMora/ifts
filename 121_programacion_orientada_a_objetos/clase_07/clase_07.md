# Encapsulamiento en POO (Python)

- **Clases y Objetos**:  
  - Una clase define atributos y métodos.  
  - Un objeto es una instancia de una clase.  

- **Método `__init__`**:  
  - Funciona como inicializador (constructor).  
  - Puede estar presente o no (Python crea uno implícito si no se define).  

- **Encapsulamiento**:  
  - Impide el acceso directo a ciertos atributos o métodos.  
  - Define qué puede usarse desde fuera de la clase.  
  - En Python no hay modificadores de acceso explícitos (`public`, `private`).  
  - Se usa convención en los nombres:  
    - `__atributo` → privado  
    - `atributo` → público  
    - `__metodo__` → método especial (no privado)  

- **Getters y Setters**:  
  - **Getter**: permite acceder al valor de un atributo privado.  
  - **Setter**: permite asignar un valor controlado (validación).  

- **Ejemplo práctico (clase `Fecha`)**:  
  - Atributo privado `__dia`.  
  - `getDia()` → devuelve el valor.  
  - `setDia(dia)` → valida antes de asignar.  

- **Encapsulamiento protege**:  
  - Evita valores inválidos.  
  - Da seguridad y consistencia.  
  - Controla el acceso desde fuera de la clase.  
