from tp_01 import Producto, Usuario, Carrito, PlataformaPagoX, Compra
import pytest

# ---------------------------------------------------------------------------------
# Consigna 1: Validacion de reglas de negocio
# ---------------------------------------------------------------------------------

# Cada test tiene: un objetivo, datos de entrada, una acción, y un resultado esperado (assert).
# Eso es lo que define un caso de prueba


# Caso válidos (comportamiento esperado correcto)
def test_hay_stock():
    p = Producto(1, "Mouse", 1000, 5)

    assert p.hay_stock(3) == True
    assert p.hay_stock(10) == False


# Caso inválidos o de error (datos incorrectos, estados no permitidos, etc.)
def test_descontar_stock():
    p = Producto(1, "Mouse", 1000, 5)
    # Se usa esta instruccion cuando el metodo retorna un: raise ValueError
    with pytest.raises(ValueError):
        p.descontar_stock(10)


# Validación de restricciones propias del dominio
# (por ejemplo: cantidades negativas, estados inválidos, datos obligatorios)
def test_hay_stock_invalido():
    p = Producto(1, "Mouse", 1000, 5)

    with pytest.raises(ValueError):
        p.descontar_stock(0)


# ---------------------------------------------------------------------------------
# Consigna 2: Cobertura de escenarios y estados del sistema
# ---------------------------------------------------------------------------------


# Escenarios normales (flujo principal)
def test_compra_exitosa():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)
    producto = Producto(1, "Mouse", 1000, 5)

    carrito.agregar_producto(producto, 2)

    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)

    resultado = compra.finalizar_compra("credito")

    # Se espera un flujo normal, eso significa que:
    assert resultado == True  # La compra se finalizó
    assert compra.estado == "aprobada"  # El estado de la compra es aprobada
    assert producto.stock == 3  # Si el stock era 5 inicialmente y pedí 2


# Escenarios alternativos (variaciones del flujo)
#  Camino no feliz
def test_compra_rechazada_pago():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)
    producto = Producto(1, "Mouse", 1000, 5)

    carrito.agregar_producto(producto, 1)

    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)
    # acá se produce la variacion de flujo
    resultado = compra.finalizar_compra("bitcoin")

    # Porque finalizar_compra espera False si pago_aprobado resulta en False
    assert resultado == False
    assert compra.estado == "rechazada"


# Escenarios de fallo (cuando una operación no puede completarse)
def test_compra_rechazada_carrito_vacio():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)
    # Acá no está sucediendo el paso de agregar un producto, y validar el stock
    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)

    # valida que el carrito no esté vacío
    resultado = compra.finalizar_compra("credito")

    assert resultado == False
    assert compra.estado == "rechazada"
