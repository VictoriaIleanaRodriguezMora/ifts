class Producto:
    def __init__(self, id_product, name, price, stock):
        self.id_producto = id_product
        self.nombre = name
        self.precio = price
        self.stock = stock

    def hay_stock(self, cantidad):
        # si la cantidad del Producto es mayor o igual a la cantidad pedida, retorna true, sino, false
        return self.stock >= cantidad

    def descontar_stock(self, cantidad):
        if cantidad <= 0:
            raise ValueError("La cantidad debe ser mayor a cero")

        if not self.hay_stock(cantidad):  # llama a metodo de clase
            raise ValueError("Stock insuficiente")

        self.stock -= cantidad  # descuenta el stock


class Usuario:
    def __init__(self, id_user, name, email):
        self.id_usuario = id_user
        self.nombre = name
        self.email = email


class Carrito:
    def __init__(self, id_user):
        self.usuario = id_user  # recibe un id user
        self.items = []  # items del carrito

    # Carrito > agregar_producto recibe 2 parametros de método
    def agregar_producto(self, producto, cantidad):
        if cantidad <= 0:
            raise ValueError("La cantidad debe ser mayor a cero")

        # En el test, producto, es una instancia de Producto
        if not producto.hay_stock(cantidad):
            raise ValueError("Stock insuficiente")

        self.items.append({"producto": producto, "cantidad": cantidad})

    def esta_vacio(self):
        # si self.items es exactamente cero, devuelve true = está vacío
        return len(self.items) == 0

    def calcular_total(self):
        total = 0

        # recorro el array de items
        for item in self.items:
            producto = item["producto"]
            cantidad = item["cantidad"]
            total += producto.precio * cantidad

        return total

    def confirmar_compra(self):
        if self.esta_vacio():  # metodo de Carrito
            # si está vacío. NO confirma la compra
            raise ValueError("El carrito está vacío")

        for item in self.items:
            producto = item["producto"]
            cantidad = item["cantidad"]

            # En el test, producto, es una instancia de Producto
            producto.descontar_stock(cantidad)  # metodo de Producto


class PlataformaPagoX:
    MEDIOS_VALIDOS = ["credito", "debito", "transferencia"]

    def validar_medio_pago(self, medio_pago):
        return medio_pago in self.MEDIOS_VALIDOS

    def procesar_pago(self, monto, medio_pago):
        # No se procesa el pago, si el monto de la compra es menor a cero
        if monto <= 0:
            return False

        # No se procesa el pago, si el medio de pago, no es uno de los permitidos
        if not self.validar_medio_pago(medio_pago):
            return False

        return True


class Compra:
    def __init__(self, usuario, carrito, plataforma_pago):
        self.usuario = usuario
        self.carrito = carrito
        self.plataforma_pago = plataforma_pago
        self.estado = "pendiente"

    def finalizar_compra(self, medio_pago):
        if self.carrito.esta_vacio():
            self.estado = "rechazada"
            return False

        total = self.carrito.calcular_total()  # Método de carrito
        
        # Método de PlataformaPagoX
        pago_aprobado = self.plataforma_pago.procesar_pago(total, medio_pago)

        if not pago_aprobado:
            self.estado = "rechazada"
            return False

        self.carrito.confirmar_compra()
        self.estado = "aprobada"
        return True
