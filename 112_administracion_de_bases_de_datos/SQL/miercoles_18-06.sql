USE comercio_electronico;
/* # Cuenta la cantidad de prods de categoría electronica
SELECT COUNT(productos.idCategoria) 
	FROM productos
JOIN categorias 
	ON categorias.idCategoria = productos.idCategoria 
WHERE productos.idCategoria = 1
;
*/

# Funcion IN
SELECT * FROM productos  WHERE idMarca = 1 OR  idMarca = 4 OR  idMarca = 3;
SELECT * FROM productos  WHERE idMarca IN(1, 4, 3); -- Es equivalente


-- SELECT * FROM productos LIMIT 3,2;
-- SELECT * FROM productos LIMIT 5;
/* Arranca a partir de lo que le digo 1ero, sin incluirlo y de ahi me trae lo que le paso del 2do
0, 2 "no te muevas nada y traeme 2" */