CREATE TABLE Clientes (
  id_cliente INT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  dni VARCHAR(20) NOT NULL,
  dirección VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL
);

CREATE TABLE Productos (
  id_producto INT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  código VARCHAR(20) NOT NULL,
  precio_compra DECIMAL(10, 2) NOT NULL,
  precio_venta DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Proveedores (
  id_proveedor INT PRIMARY KEY,
  cuit VARCHAR(20) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  dirección VARCHAR(100) NOT NULL
);

CREATE TABLE Ventas (
  id_venta INT PRIMARY KEY,
  id_cliente INT NOT NULL,
  id_producto INT NOT NULL,
  fecha_venta DATE NOT NULL,
  cantidad INT NOT NULL,
  precio_venta DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

CREATE TABLE Suministros (
  id_suministro INT PRIMARY KEY,
  id_proveedor INT NOT NULL,
  id_producto INT NOT NULL,
  fecha_suministro DATE NOT NULL,
  cantidad INT NOT NULL,
  FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id_proveedor),
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);