USE comercio_electronico;
# ✅ 3 . Obtener el nombre del cliente que realizó la venta con idVenta = 2:
/* -- este intento me devolvió algo pero no estaba correcto
-- SELECT ventas.idCliente FROM ventas RIGHT JOIN clientes ON ventas.idCliente WHERE ventas.idCliente = 2 AND clientes.idCliente = 2;
*/
/* -- EJ 03
SELECT clientes.nombreCliente FROM clientes 
LEFT JOIN ventas
ON ventas.idCliente = clientes.idCliente
WHERE ventas.idCliente = 2 AND clientes.idCliente = 2
;
*/
/* ERRORES QUE TUVE y PAGINAS QUE ME AYUDARON CON ESOS ERRORES
Error Code: 1052. Column 'idCliente' in field list is ambiguous
https://usavps.com/blog/16560/
Error Code: 1066. Not unique table/alias: 'ventas'
https://stackoverflow.com/questions/8084571/not-unique-table-alias
*/

# 4. Obtener el total de ventas realizadas por cada cliente:
/* -- EJERCICIO 04
SELECT 
-- vd.idVentaDetalle,
 vd.idVenta
-- , vd.cantidad
-- , pr.precioVenta
, SUM(vd.cantidad * pr.precioVenta) AS 'cantidad * precioVenta'
FROM ventas_detalle  AS vd
JOIN productos AS pr
ON vd.idProducto = pr.idProducto
GROUP BY vd.idVenta
;
*/

-- ¿De compras?
-- Clientes - idCliente | Ventas - idVenta | 
-- ventas_detalle - idVentaDetalle, idVenta, idProducto, cantidad
-- productos | idProducto, precioCompra, precioVenta

/*(SELECT clientes.nombreCliente FROM clientes 
LEFT JOIN ventas
ON ventas.idCliente = clientes.idCliente)
UNION */

/* NOTAS PARA EL EJERCICIO # 04
¿Qué es una columna agregada? "nonagreggated column"
Es una columna que se procesa usando una función de agregación, como:
SUM(), AVG, COUNT, MAX, MIN, 
〰️
EJEMPLO: 
SELECT idCliente, SUM(cantidad) FROM ventas GROUP BY idCliente;
En este caso: SUM(cantidad) es una columna agregada.
idCliente no está agregada, pero sí está en el GROUP BY, por eso no hay error.
〰️
¿Qué es una columna no agregada?
Es cualquier columna que aparece en el SELECT pero no está dentro de una función de agregación ni en el GROUP BY.

〰️
EJEMPLO:
SELECT idCliente, nombreCliente, SUM(cantidad) FROM ventas GROUP BY idCliente;
nombreCliente es no agregada (no está en SUM, ni en GROUP BY)
Y como no está en el GROUP BY, SQL no sabe qué valor mostrar si hay más de un nombre asociado a un idCliente.
〰️

‼️‼️ SQL necesita saber qué hacer con cada columna que aparece en el SELECT
Entonces: Cada columna que aparece en el SELECT debe estar:
1) en una función de agregación (como SUM(), COUNT(), etc.)
2) en el GROUP BY


*/
/* ERRORES que obtuve
Error Code: 1222. The used SELECT statements have a different number of columns
Error Code: 1055. Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'comercio_electronico.vd.cantidad' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
ELECT vd.idVenta, vd.cantidad, pr.precioVenta,
COUNT(vd.cantidad * pr.precioVenta) AS 'contador id'
FROM ventas_detalle  AS vd
LEFT JOIN productos AS pr
ON vd.idVentaDetalle = pr.idProducto
GROUP BY vd.idVenta
Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'comercio_electronico.vd.idVentaDetalle' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by
*/
/* INTENTOS DE ESTE EJERCICIO
-- no está mal, pero no es agrupar por idVentaDetalle lo q necesito
SELECT vd.idVentaDetalle
, vd.idProducto
, vd.idVenta
, vd.cantidad
, pr.precioVenta
, pr.idProducto
, SUM(cantidad * precioVenta) AS 'cantidad * precioVenta'
-- COUNT(vd.cantidad * pr.precioVenta) AS 'contador id'
FROM ventas_detalle  AS vd
LEFT JOIN productos AS pr
ON vd.idProducto = pr.idProducto
GROUP BY vd.idVentaDetalle
;


SELECT vd.idVentaDetalle
, vd.idProducto
, vd.idVenta
, vd.cantidad
, pr.precioVenta
, pr.idProducto
, SUM(cantidad * precioVenta) AS 'cantidad * precioVenta'
FROM ventas_detalle  AS vd
LEFT JOIN productos AS pr
ON vd.idProducto = pr.idProducto
GROUP BY vd.idVentaDetalle
;
*/

# 5. Obtener todos los productos de la categoría "Electrónica" con su nombre de categoría:
# (Hecho en clase)
/* -- EJ 05
SELECT * -- trae TODO de todas las tablas
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
*/


# 6. Obtener el nombre y la dirección de todos los clientes que han realizado ventas:
 -- EJ 06
 /*
SELECT ventas.idVenta, clientes.nombreCliente, clientes.direccionCliente
	FROM ventas
INNER JOIN clientes -- INNER JOIN pq necesito unicamente los clientes con ventas. no ventas sin clientes
	ON ventas.idCliente = clientes.idCliente
;
*/

# 7. Obtener los detalles de ventas de la venta con idVenta = 1, incluyendo el nombre del producto y su precio de venta:
/* -- EJ 07  
SELECT v.idVenta
, c.nombreCliente
, c.direccionCliente
-- , vd.idVentaDetalle
-- , p.idProducto
, p.nombreProducto
, p.precioVenta
	FROM ventas AS v
INNER JOIN clientes AS c -- INNER JOIN pq necesito unicamente los clientes con ventas. no ventas sin clientes
	ON v.idCliente = c.idCliente
INNER JOIN ventas_detalle AS vd
	ON vd.idVenta = v.idVenta
INNER JOIN productos AS p
	ON vd.idProducto = p.idProducto
		WHERE v.idVenta = 1
;
*/

# 8. Obtener el total de ventas realizadas por cada cliente, mostrando el nombre del cliente y la cantidad total de ventas:
/* -- EJERCICIO 08
SELECT 
-- v.idVenta,
 c.nombreCliente
-- , c.direccionCliente
-- , p.nombreProducto
-- , p.precioVenta
, SUM(p.precioVenta * cantidad) AS 'suma de las ventas de cada cliente'
# JUAN compró: 2 iphone de 1000 c/u y 1 macbook pro de 2000 = 4000
# María compró; 3 Airpods pro de 250 c/u y 2 pantalon azul de 45 = 840
	FROM ventas AS v
INNER JOIN clientes AS c 
	ON v.idCliente = c.idCliente
INNER JOIN ventas_detalle AS vd
	ON vd.idVenta = v.idVenta
INNER JOIN productos AS p
	ON vd.idProducto = p.idProducto
GROUP BY (c.nombreCliente)
;
*/

# 9. Obtener los nombres de las categorías y la cantidad de productos vendidos en cada categoría:
/* -- EJERCICIO 09
SELECT c.nombreCategoria
-- , p.idProducto
-- , vd.cantidad
, COUNT(vd.cantidad)
	FROM ventas_detalle AS vd
INNER JOIN productos AS p
	ON p.idProducto = vd.idProducto
INNER JOIN categorias AS c
	ON c.idCategoria = p.idCategoria
GROUP BY (c.nombreCategoria)
;
*/

# 10. Obtener el nombre de cada cliente y el total gastado en compras por cada cliente, incluyendo aquellos clientes que no han realizado compras:
SELECT nombreCliente
-- , vd.idVenta
, vd.idVentaDetalle
, vd.idProducto, vd.cantidad, p.precioCompra,
 SUM(p.precioCompra * vd.cantidad) AS 'precio * cantidad'
	FROM clientes AS c
JOIN ventas AS v
	ON c.idCliente = v.idCliente
JOIN ventas_detalle AS vd
	ON vd.idVenta = v.idVenta
JOIN productos AS p
	ON p.idProducto = vd.idProducto
GROUP BY nombreCliente
;