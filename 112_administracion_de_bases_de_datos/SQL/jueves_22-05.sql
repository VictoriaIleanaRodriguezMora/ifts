USE comercio_electronico;

DESCRIBE clientes;
# AND &&
-- SELECT * FROM productos WHERE precioCompra >= 200 AND precioCompra <= 800;

# OR |
/* Son importantes los parentesis, así cómo está la sentencia pareciera que no funciona, 
pero en realidad sí, sólo que en este ejemplo no se nota.
Pero tenerlo todo asi de corrido, sin parentesis, lo que hace es LIKE y el primer AND por un lado, 
y despues, de esos, los que tmb sean menores a 800. Pero no es eso lo que quiero lograr

*/
-- SELECT * FROM productos WHERE nombreProducto LIKE "%i%" AND precioCompra >= 200 AND precioCompra <= 800;
/* Así está correctamente escrita. Los parentesis cómo en la programación habitual y la matematica */
 -- SELECT * FROM productos WHERE nombreProducto LIKE "%i%" AND (precioCompra >= 200 AND precioCompra <= 800);
 
 # OPERADORES MATEMATICOS/FUNCIONES DE AGREGACION
  -- SELECT SUM(preciocompra) AS 'suma del precio de compra' FROM productos;
  
# ¿Qué ganancia tengo si vendo todo? Precioventa - preciocompra (no entiendo porque esa cuenta)
-- SELECT (SUM(precioVenta) - SUM(preciocompra)) AS 'Ganancia total' FROM productos;
-- SELECT (SUM(preciocompra) / COUNT(*) ) AS 'Promedio precio de compra' FROM productos;
-- SELECT AVG(preciocompra)  AS 'Promedio precio de compra' FROM productos;

# Quiero ver los idCategoria, a qué categoria pertenecen
-- Categoria es una tabla lookup
SELECT nombreProducto, nombreCategoria, nombreSubcategoria
FROM productos 
JOIN categorias -- quiero unir tabla 1 con tabla2
ON productos.idCategoria = categorias.idCategoria -- unir las tablas por un campo en comun: idCategoria. Un campo que tengan las 2 tablas
JOIN subcategorias
ON productos.idSubcategoria = subcategorias.idSubcategoria
# Ahora quiero ver tambien la subcategoria
/* Pero esto está mal, porque: Sí, idCategoria y idSubcategoria tienen 1, 2, 3 de id, un telefono, 
no es computadora y telefono a la vez. Yo en realidad, quiero ver la subcategoria, 
comparando con productos

JOIN subcategorias
ON categorias.idCategoria = subcategorias.idCategoria*/
;
 
 
 # CRUD
 -- INSERT INTO categorias (idCategoria, nombreCategoria) VALUES (3, "Comestibles");
 -- INSERT INTO categorias (nombreCategoria) VALUES ("Juguetes");
 
 # Esto funciona pero es + seguro actualizar por ID
 -- UPDATE categorias SET nombreCategoria = "Adornos" WHERE nombreCategoria = "Juguetes";
 
 -- SELECT * FROM categorias;
 # Si en vez de OR pongo AND, no va a borrar nada, pq nunca un id es = a 3 y 4 a la vez
 -- DELETE FROM categorias WHERE idCategoria = 3 OR idCategoria = 4;
 
# EJERCICIOS
# 1. Obtener todos los productos de la categoria "Electronica"
-- SELECT * FROM productos; Productos NO tiene un campo nombreCategoria
-- SELECT * FROM productos WHERE nombreCategoria = "Electronica" Entonces esto es incorrecto

/* ¿Qué JOIN hago? ¿Qué es lo que quiero?
Quiero los productos que su categoria sea electronica. Solo quiero los que coincida
la categoria, los demas no los quiero. Tampoco quiero ver otras categorias.
Por eso seria INNER
*/
/* -- RESOLUCION EJ 1
SELECT nombreProducto, nombreCategoria FROM productos
INNER JOIN categorias
ON productos.idCategoria = categorias.idCategoria
WHERE nombreCategoria = "Electronica"
;
*/
-- Sin el WHERE, me trae todas los productos y categorias que tengan un id en comun, sino, no.

# 2. Obtener todos los detalles de ventas con idVenta = 1
-- SELECT nombreProducto, precioVenta, cantidad, nombreCliente, apellidoCliente
SELECT *
	FROM ventas_detalle 
INNER JOIN productos
	ON ventas_detalle.idProducto = productos.idProducto
INNER JOIN ventas 
	ON ventas.idVenta = ventas_detalle.idVenta
INNER JOIN clientes -- ¿Con qué lo vinculo? Tengo que vincularlo con la tabla detalle, porque detalle_ventas, no tiene nada para vincular con clientes
-- Traje a clientes, porque me pedian los datos, para hacer la factura. Nombre, apellido
	ON clientes.idCliente = ventas.idCliente
WHERE ventas_detalle.idVenta = 1
;

/* ERRORES
- Este errore significa que hay tantas referencias a idVenta en distintas tablas, que no sabe a cual
tiene que hacer referencia
Error Code: 1052. Column 'idVenta' in where clause is ambiguous
WHERE idVenta = 1,

*/


