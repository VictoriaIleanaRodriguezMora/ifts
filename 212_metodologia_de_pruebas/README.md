### METODOLOGIA DE PRUEBAS DE SISTEMAS
# Trabajo Practico de Clase Nro 1 - Pruebas unitarias


El siguiente trabajo consiste en cumplir las dos consignas realizando pruebas unitarias sobre el
ejemplo que se adjunta en el siguiente TP o bien sobre un modelo que el grupo decida emplear
para las pruebas, en ambos casos las pruebas realizadas deben documentarse debidamente sobre
Test Case y con una breve descripción de como valida cada consigna con las pruebas realizadas.

**Entregable**: Informe de pruebas con: Test Case – Codigo de la herramienta de prueba utilizada (por
ejemplo: Pytest). Recordar que para cada Test Case se debe describir que se está validando de
acuerdo a las consignas del trabajo practico. El informe debe incluir la información básica necesaria
sobre el alumno o grupo que presenta el informe (apellido, nombre, grupo nro, integrantes etc)

**Presentación por equipo**: un integrante por equipo expone a partir del jueves 7 de mayo.

### **Consigna 1: Validación de reglas de negocio**

Desarrolle al menos **tres prueba unitariass** que verifiquen el correcto funcionamiento de las **reglas de negocio principales** del sistema que haya implementado.

Las pruebas deben cubrir al menos:

- Caso **válidos** (comportamiento esperado correcto)
- Caso **inválidos o de error** (datos incorrectos, estados no permitidos, etc.)
- Validación de **restricciones** propias del dominio (por ejemplo: cantidades negativas,
estados inválidos, datos obligatorios)

Cada prueba debe centrarse en un único comportamiento y ser independiente del resto.

### **Consigna 2: Cobertura de escenarios y estados del sistema**
Diseñe e implemente al menos **tres pruebas unitarias** que contemplen distintos **escenarios de uso del sistema**, verificando cómo cambian los estados internos de los objetos involucrados.

Las pruebas deben incluir:

- Escenarios **normales** (flujo principal)
- Escenarios **alternativos** (variaciones del flujo)
- Escenarios **de fallo** (cuando una operación no puede completarse)
Se debe validar no solo el resultado de las operaciones, sino también los **efectos secundarios**, como cambios de estado, modificaciones de datos o interacción entre objetos.

### EJEMPLO para la practica:
Modelo de negocio: compra simple dentro de un marketplace:
un usuario registrado navega el catálogo de productos disponibles, selecciona un producto
específico, lo agrega a su carrito de compras y luego inicia el proceso de pago. El carrito permite acumular uno o más productos, calcular el total de la compra y validar que los productos seleccionados tengan stock suficiente antes de confirmar la operación. Para finalizar la compra, el usuario utiliza una plataforma externa de pagos denominada Plataforma X, la cual permite abonar mediante tres medios posibles: tarjeta de crédito, tarjeta de débito o transferencia desde una cuenta bancaria previamente asociada a dicha plataforma. La compra solo se considera aprobada si el usuario existe, el carrito no está vacío, los productos tienen stock disponible, el medio de pago es válido y la Plataforma X confirma correctamente la transacción. En caso contrario, la operación debe ser rechazada o quedar pendiente según el problema detectado. Este modelo está pensado para trabajar pruebas unitarias sobre clases relacionadas entre sí, validando comportamientos concretos como agregar productos al carrito, calcular totales, controlar stock, validar medios de pago y confirmar o rechazar una compra.


# Instalar pytest
https://docs.pytest.org/en/stable/getting-started.html#install-pytest
```bash
cd 212_metodologia_de_pruebas
```
```bash
pip install  pytest
```
```bash
pytest
```