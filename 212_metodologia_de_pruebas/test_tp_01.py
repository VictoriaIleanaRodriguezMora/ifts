# Consigna 1: Validacion de reglas de negocio
from tp_01 import Producto, Usuario, Carrito, PlataformaPagoX, Compra
import pytest

# Caso válidos (comportamiento esperado correcto)
def test_hay_stock():
    p = Producto(1, "Mouse", 1000, 5)

    assert p.hay_stock(3) == True
    assert p.hay_stock(10) == False


# Caso inválidos o de error (datos incorrectos, estados no permitidos, etc.)
def test_descontar_stock():
    p = Producto(1, "Mouse", 1000, 5)

    with pytest.raises(ValueError):
        p.descontar_stock(10)


# Validación de restricciones propias del dominio
# (por ejemplo: cantidades negativas, estados inválidos, datos obligatorios)
def test_hay_stock_invalido():
    p = Producto(1, "Mouse", 1000, 5)

    with pytest.raises(ValueError):
        p.descontar_stock(0)


# Consigna 2: Cobertura de escenarios y estados del sistema


# Escenarios normales (flujo principal)
def test_compra_exitosa():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)
    producto = Producto(1, "Mouse", 1000, 5)

    carrito.agregar_producto(producto, 2)

    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)

    resultado = compra.finalizar_compra("credito")

    assert resultado == True
    assert compra.estado == "aprobada"
    assert producto.stock == 3


# Escenarios alternativos (variaciones del flujo)
def test_compra_rechazada_pago():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)

    producto = Producto(1, "Mouse", 1000, 5)
    carrito.agregar_producto(producto, 1)

    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)

    resultado = compra.finalizar_compra("bitcoin")

    assert resultado == False
    assert compra.estado == "rechazada"


# Escenarios de fallo (cuando una operación no puede completarse)
def test_compra_rechazada_carrito_vacio():
    usuario = Usuario(1, "Juan", "juan@mail.com")
    carrito = Carrito(usuario)

    plataforma = PlataformaPagoX()

    compra = Compra(usuario, carrito, plataforma)

    resultado = compra.finalizar_compra("credito")

    assert resultado == False
    assert compra.estado == "rechazada"
