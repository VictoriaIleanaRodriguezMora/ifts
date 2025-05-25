CREATE DATABASE comercio_electronico;
USE comercio_electronico;

-- Creamos la tabla de categorias
CREATE TABLE categorias (
  idCategoria INT(3) AUTO_INCREMENT PRIMARY KEY,
  nombreCategoria VARCHAR(50)
);


-- Creamos la tabla de subcategorias
CREATE TABLE subcategorias (
  idSubcategoria INT(3) AUTO_INCREMENT PRIMARY KEY,
  idCategoria INT(3),
  nombreSubcategoria VARCHAR(50),
  FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria)
);

-- Creamos la tabla de marcas de productos
CREATE TABLE marcas (
  idMarca INT(3) AUTO_INCREMENT PRIMARY KEY,
  nombreMarca VARCHAR(50)
);

-- Creamos la tabla de clientes
CREATE TABLE clientes (
  idCliente INT(6) AUTO_INCREMENT PRIMARY KEY,
  nombreCliente VARCHAR(50),
  apellidoCliente VARCHAR(50),
  direccionCliente VARCHAR(100),
  telefonoCliente VARCHAR(15)
);


-- Creamos la tabla de productos
CREATE TABLE productos (
  idProducto INT(3) AUTO_INCREMENT PRIMARY KEY,
  nombreProducto VARCHAR(50),
  idMarca INT(3),
  precioCompra FLOAT(6,2),
  precioVenta FLOAT(6,2),
  idCategoria INT(3),
  idSubcategoria INT(3),
  FOREIGN KEY (idMarca) REFERENCES marcas(idMarca),
  FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria),
  FOREIGN KEY (idSubcategoria) REFERENCES subcategorias(idSubcategoria)
);

-- Creamos la tabla de ventas
CREATE TABLE ventas (
  idVenta INT(3) AUTO_INCREMENT PRIMARY KEY,
  fechaVenta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  idCliente INT(6)
);


-- Creamos la tabla de ventas_detalle (anteriormente pedidos)
CREATE TABLE ventas_detalle (
  idVentaDetalle INT(8) AUTO_INCREMENT PRIMARY KEY,
  idVenta INT(3),
  idProducto INT(3),
  cantidad INT(3),
  FOREIGN KEY (idVenta) REFERENCES ventas(idVenta),
  FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);


-- Insertar datos en la tabla categorias
INSERT INTO categorias (idCategoria, nombreCategoria) VALUES
(1, 'Electrónica'),
(2, 'Ropa');

-- Insertar datos en la tabla subcategorias
INSERT INTO subcategorias (idSubcategoria, idCategoria, nombreSubcategoria) VALUES
(1, 1, 'Teléfonos'),
(2, 1, 'Computadoras'),
(3, 2, 'Camisetas'),
(4, 2, 'Pantalones');


-- Insertar datos en la tabla marcas
INSERT INTO marcas (idMarca, nombreMarca) VALUES
(1, 'Samsung'),
(2, 'Apple'),
(3, 'Nike'),
(4, 'Adidas');


-- Insertar datos en la tabla clientes
INSERT INTO clientes (idCliente, nombreCliente, apellidoCliente, direccionCliente, telefonoCliente) VALUES
(1, 'Juan', 'Pérez', 'Calle 123, Ciudad', '555-1234'),
(2, 'María', 'Gómez', 'Avenida X, Ciudad', '555-5678');


-- Insertar datos en la tabla productos
INSERT INTO productos (idProducto, nombreProducto, idMarca, precioCompra, precioVenta, idCategoria, idSubcategoria) VALUES
(1, 'iPhone 12', 2, 800.00, 1000.00, 1, 1),
(2, 'Galaxy S21', 1, 700.00, 900.00, 1, 1),
(3, 'MacBook Pro', 2, 1500.00, 2000.00, 1, 2),
(4, 'AirPods Pro', 2, 200.00, 250.00, 1, 1),
(5, 'Camiseta Negra', 3, 20.00, 30.00, 2, 3),
(6, 'Pantalón Azul', 4, 30.00, 45.00, 2, 4);

-- Insertar datos en la tabla ventas
INSERT INTO ventas (idVenta, fechaVenta, idCliente) VALUES
(1, '2023-05-14 10:00:00', 1),
(2, '2023-05-15 14:30:00', 2);

-- Insertar datos en la tabla ventas_detalle
INSERT INTO ventas_detalle (idVentaDetalle, idVenta, idProducto, cantidad) VALUES
(1, 1, 1, 2),
(2, 1, 3, 1),
(3, 2, 4, 3),
(4, 2, 6, 2);


SELECT * FROM clientes;
SELECT * FROM ventas;
