CREATE DATABASE after_class_practica;

USE after_class_practica;

SELECT * FROM comercio_electronico.clientes;

#Este es un comentario de línea

/* Este es un comentario en 
bloque Puedo seguir escribiendo */

CREATE TABLE IF NOT EXISTS categorias(
  idCategoria INT(2) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombreCategoria VARCHAR(30)
  );
  
CREATE TABLE IF NOT EXISTS productos(
  idProducto INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idCategoria INT(2) NOT NULL,
  nombreProducto VARCHAR(35),
  stock INT(4),
  precio DECIMAL(10,2),
  FOREIGN KEY(idCategoria) REFERENCES categorias(idCategoria)
  );

# Maneras de hacer inserts  
INSERT INTO categorias (idCategoria, nombreCategoria) VALUES (1,'Electrónico');
INSERT INTO categorias (nombreCategoria) VALUES ('Hogar');
INSERT INTO categorias (nombreCategoria) VALUES 
('Bazar'),
('Decoración');

DELETE FROM categorias;

DESCRIBE productos;


# GENERAR INFORMACION EN LA TABLA PRODUCTOS
INSERT INTO productos (idCategoria,nombreProducto,stock,precio) VALUES 
(1,'Toshiba',10,700000) , 
(2,'Cooler' , 2 , 10000),
(1,'Teclado Gammer', 4, 150000),
(2,'Mouse LG' , 5 , 2000), 
(2,'Monitor Samsung 19 "' , 20 , 19000.50);


SELECT COUNT(*) FROM categorias;
  
SELECT nombreProducto, stock, precio, nombreCategoria 
FROM productos INNER JOIN categorias ON productos.idCategoria = categorias.idCategoria LIMIT 10;




/* Entornos de trabajo en la mayoria de las empresas.

DESARROLLO - Los programadores pueden ejecutar todo tipo de sentencias SQL
Generalmente la información está desensibilizada.
Se suele hacer back UP de manera eventual.

TEST - Los programadores tiene algunas restricciones de uso.
Generalmente la información está desensibilizada, pero podría no estarlo.
Se suele hacer backup de manera semanal. O incluso diario.

PRODUCCION - Los programadores no deberíamos tener acceso.
La inforamción es confidencial, no está desensibilizada. Es peligroso tener acceso a ella.
Idealmente se hace backup diario o mas de una vez por dia.