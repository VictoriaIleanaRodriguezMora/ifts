USE comercio_electronico;
# 3 . Obtener el nombre del cliente que realizó la venta con idVenta = 2:
-- este intento me devolvió algo pero no estaba correcto
-- SELECT ventas.idCliente FROM ventas RIGHT JOIN clientes ON ventas.idCliente WHERE ventas.idCliente = 2 AND clientes.idCliente = 2;
SELECT clientes.nombreCliente FROM clientes 
LEFT JOIN ventas
ON ventas.idCliente = clientes.idCliente
WHERE ventas.idCliente = 2 AND clientes.idCliente = 2
;
/* ERRORES QUE TUVE y PAGINAS QUE ME AYUDARON CON ESOS ERRORES
Error Code: 1052. Column 'idCliente' in field list is ambiguous
https://usavps.com/blog/16560/
Error Code: 1066. Not unique table/alias: 'ventas'
https://stackoverflow.com/questions/8084571/not-unique-table-alias
*/

# 4. Obtener el total de ventas realizadas por cada cliente:
# 5. Obtener todos los productos de la categoría "Electrónica" con su nombre de categoría:
# 6. Obtener el nombre y la dirección de todos los clientes que han realizado ventas:
# 7. Obtener los detalles de ventas de la venta con idVenta = 1, incluyendo el nombre del producto y su precio de venta:
# 8.Obtener el total de ventas realizadas por cada cliente, mostrando el nombre del cliente y la cantidad total de ventas:
# 9. Obtener los nombres de las categorías y la cantidad de productos vendidos en cada categoría:
# 10. Obtener el nombre de cada cliente y el total gastado en compras por cada cliente, incluyendo aquellos clientes que no han realizado compras:

