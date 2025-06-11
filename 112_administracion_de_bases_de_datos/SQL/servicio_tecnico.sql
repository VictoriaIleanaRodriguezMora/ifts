/*
Prof: Emanuel Odstrcil para IFTS18
Base de datos Servicio técnico.
Ejercicios de varios nueveles
Ultima actualización 2023.06.28
*/

-- Eliminar una base de datos
DROP DATABASE IF EXISTS servicio_tecnico;

-- Crear una base de datos
CREATE DATABASE servicio_tecnico;

-- Utilizar una base de datos determinada
USE servicio_tecnico;


-- Crear la tabla "contadores"
CREATE TABLE contadores (
  id_contador INT(1) PRIMARY KEY,
  cantidad_marcas INT(10),
  cantidad_clientes INT(10),
  cantidad_ordenes INT(10),
  cantidad_equipos INT(10)
);

-- Insertar el contador inicial
INSERT INTO contadores (id_contador, cantidad_clientes, cantidad_ordenes, cantidad_equipos)
VALUES (1, 0, 0, 0);



-- Crear la tabla lookup de "marcas"
CREATE TABLE marcas (
  id_marca INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  marca VARCHAR(50)
);


-- Crear la tabla lookup de "estados"
CREATE TABLE estados (
  id_estado TINYINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "Puede is de 0 a 255",
  estado VARCHAR(50)
);

-- Crear la tabla "tecnicos"
CREATE TABLE tecnicos (
  id_tecnico INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(25),
  apellido VARCHAR(25),
  telefono VARCHAR(25),
  email VARCHAR(50),
  contrasena VARCHAR(20)
);


-- Crear la tabla "Clientes"
CREATE TABLE clientes (
  id_cliente INT(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(25),
  apellido VARCHAR(25),
  direccion VARCHAR(50),
  telefono VARCHAR(20),
  email VARCHAR(50),
  contrasena VARCHAR(15),
  ultimoIngreso DATETIME DEFAULT CURRENT_TIMESTAMP()
);


-- Crear la tabla "equipos"
CREATE TABLE equipos (
  id_equipo INT(7) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_marca INT(3),
  modelo VARCHAR(255),
  numero_serie VARCHAR(50),
  descripcion VARCHAR(255),
  FOREIGN KEY (id_marca) REFERENCES marcas(id_marca)
);


-- Crear la tabla "ordenes"
CREATE TABLE ordenes (
  id_orden INT(7) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descripcion_del_problema VARCHAR(255),
  fecha_ingreso DATE,
  id_cliente INT(4),
  id_equipo INT(7),
  id_tecnico INT(3),
  id_estado TINYINT,
  reparacionRealizada VARCHAR(255),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
  FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo),
  FOREIGN KEY (id_tecnico) REFERENCES tecnicos(id_tecnico),
  FOREIGN KEY (id_estado) REFERENCES estados(id_estado)
);





# Insertar registros en la tabla "estados"
INSERT INTO estados (id_estado, estado)
VALUES
  (1, 'Ingresado'),
  (2, 'En reparación'),
  (3, 'En espera'),
  (4, 'Entregado reparado'),
  (5, 'Entregado Sin reparación');
  
  

# Insertar registros en la tabla "marcas"
INSERT INTO marcas (id_marca, marca)
VALUES
  (1, 'Asus'),
  (2, 'HP'),
  (3, 'Lenovo'),
  (4, 'Dell'),
  (5, 'Apple'),
  (6, 'Samsung'),
  (7, 'Genérica');



#Creo 20 registros de clientes

# De esta manera se ingresan de a uno
INSERT INTO clientes (nombre, apellido, direccion, telefono, email, contrasena)
VALUES ('Juan', 'Gómez', 'Calle 123', '1234567890', 'juan.gomez@example.com', 'contraseña123');

# De esta manera se pueden ingresar todos Juntos

INSERT INTO clientes (nombre, apellido, direccion, telefono, email, contrasena)
VALUES
    ('Juan', 'Gómez', 'Calle 123', '1234567890', 'juan.gomez@hotmail.com', 'contraseña123'),
    ('María', 'López', 'Avenida 456', '0987654321', 'maria.lopez@gmail.com', 'abc123'),
    ('Pedro', 'Fernández', 'Calle Principal 789', '9876543210', 'pedro.fernandez@outlook.com', 'qwerty'),
    ('Laura', 'Rodríguez', 'Avenida Secundaria 12', '0123456789', 'laura.rodriguez@hotmail.com', '123456'),
    ('Martín', 'González', 'Calle Central 34', '8765432109', 'martin.gonzalez@gmail.com', 'password'),
    ('Ana', 'Pérez', 'Avenida Principal 56', '5678901234', 'ana.perez@outlook.com', 'abcd1234'),
    ('Lucas', 'Sánchez', 'Calle 789', '5432109876', 'lucas.sanchez@hotmail.com', 'qazwsx'),
    ('Carolina', 'Torres', 'Avenida 101112', '3210987654', 'carolina.torres@gmail.com', '987654321'),
    ('Fernando', 'Mendoza', 'Calle 131415', '6789012345', 'fernando.mendoza@outlook.com', 'pass123'),
    ('Sofía', 'Luna', 'Avenida 161718', '4321098765', 'sofia.luna@hotmail.com', 'abcd123'),
    ('Javier', 'Castro', 'Calle 192021', '8901234567', 'javier.castro@gmail.com', 'qwe123'),
    ('Valentina', 'Ríos', 'Avenida 222324', '2109876543', 'valentina.rios@outlook.com', 'passw0rd'),
    ('Gustavo', 'Silva', 'Calle 252627', '5432109876', 'gustavo.silva@hotmail.com', 'qazwsx123'),
    ('Camila', 'Herrera', 'Avenida 282930', '6789012345', 'camila.herrera@gmail.com', 'pass123'),
    ('Luis', 'Morales', 'Calle 313233', '1234567890', 'luis.morales@outlook.com', 'abc123'),
    ('Mariana', 'Ortega', 'Avenida 343536', '0987654321', 'mariana.ortega@hotmail.com', 'qwerty'),
    ('Ricardo', 'Navarro', 'Calle Principal 373839', '9876543210', 'ricardo.navarro@gmail.com', '123456'),
    ('Alejandra', 'Cabrera', 'Avenida Secundaria 4041', '0123456789', 'alejandra.cabrera@outlook.com', 'password'),
    ('Gonzalo', 'Rojas', 'Calle Central 424344', '8765432109', 'gonzalo.rojas@gmail.com', 'abcd1234'),
    ('Paula', 'Cruz', 'Avenida Principal 454647', '5678901234', 'paula.cruz@hotmail.com', 'qazwsx');
  
  -- Insertar registros en la tabla "tecnicos"
INSERT INTO tecnicos (nombre, apellido, telefono, email, contrasena) VALUES
    ('Eduardo', 'García', '1234509876', 'eduardo.garcia@example.com', 'contraseña456'),
    ('Lucía', 'Martínez', '9876540123', 'lucia.martinez@example.com', 'abc123456'),
    ('Roberto', 'López', '4567890123', 'roberto.lopez@example.com', 'qwerty789'),
    ('María', 'Rodríguez', '8901234567', 'maria.rodriguez@example.com', '123456abc'),
    ('Luis', 'Pérez', '5678901234', 'luis.perez@example.com', 'password123');
  

  
# Insertar registros en la tabla "equipos"

-- Equipos PC - Asus
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (1, 'ROG Strix G15', 'ABC123', 'Equipo PC - Asus ROG Strix G15'),
  (1, 'VivoMini VC66', 'DEF456', 'Equipo PC - Asus VivoMini VC66');

-- Equipos PC - HP
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (2, 'HP Pavilion Gaming Desktop', 'GHI789', 'Equipo PC - HP Pavilion Gaming Desktop'),
  (2, 'HP EliteDesk 800 G6', 'JKL012', 'Equipo PC - HP EliteDesk 800 G6');

-- Equipos PC - Lenovo
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (3, 'Lenovo Legion Tower 5i', 'MNO345', 'Equipo PC - Lenovo Legion Tower 5i'),
  (3, 'Lenovo ThinkCentre M75q Gen 2', 'PQR678', 'Equipo PC - Lenovo ThinkCentre M75q Gen 2');

-- Equipos PC - Dell
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (4, 'Dell XPS 8940', 'STU901', 'Equipo PC - Dell XPS 8940'),
  (4, 'Dell OptiPlex 7080', 'VWX234', 'Equipo PC - Dell OptiPlex 7080');

-- Equipos PC - Apple
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (5, 'iMac (última generación)', 'YZA567', 'Equipo PC - Apple iMac (última generación)'),
  (5, 'Mac Pro (última generación)', 'BCD890', 'Equipo PC - Apple Mac Pro (última generación)');

  
# NOTEBOOKS  
-- Notebooks - Asus
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (1, 'Asus ZenBook 14', 'EFG123', 'Notebook - Asus ZenBook 14'),
  (1, 'Asus ROG Zephyrus G14', 'HIJ456', 'Notebook - Asus ROG Zephyrus G14');

-- Notebooks - HP
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (2, 'HP Spectre x360', 'KLM789', 'Notebook - HP Spectre x360'),
  (2, 'HP ENVY 13', 'NOP012', 'Notebook - HP ENVY 13');

-- Notebooks - Lenovo
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (3, 'Lenovo ThinkPad X1 Carbon', 'QRS345', 'Notebook - Lenovo ThinkPad X1 Carbon'),
  (3, 'Lenovo Yoga C940', 'TUV678', 'Notebook - Lenovo Yoga C940');

-- Notebooks - Dell
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (4, 'Dell XPS 13', 'WXY901', 'Notebook - Dell XPS 13'),
  (4, 'Dell Latitude 7410', 'ZAB234', 'Notebook - Dell Latitude 7410');

-- Notebooks - Apple
INSERT INTO equipos (id_marca, modelo, numero_serie, descripcion)
VALUES
  (5, 'MacBook Pro (última generación)', 'CDE567', 'Notebook - Apple MacBook Pro (última generación)'),
  (5, 'MacBook Air (última generación)', 'FGH890', 'Notebook - Apple MacBook Air (última generación)');

  

-- Inserciones en la tabla "ordenes"
INSERT INTO ordenes (descripcion_del_problema, fecha_ingreso, id_cliente, id_equipo, id_tecnico, id_estado, reparacionRealizada)
VALUES
  ('Problema de arranque', '2020-01-01', 1, 1, 1, 1, 'Reparación exitosa'),
  ('Pantalla rota', '2020-02-02', 2, 2, 2, 2, 'Se requiere reemplazo de pantalla'),
  ('Sobrecalentamiento', '2020-03-03', 3, 3, 3, 3, 'Limpieza y cambio de pasta térmica realizado'),
  ('Batería no carga', '2020-04-04', 4, 4, 4, 4, 'Se reemplazó la batería'),
  ('Teclado no funciona', '2020-05-05', 5, 5, 5, 5, 'Se realizó la reparación del teclado'),
  ('Problemas de conectividad', '2020-06-06', 6, 6, 1, 1, 'Reparación exitosa'),
  ('No enciende', '2020-07-07', 7, 7, 2, 2, 'Se requiere cambio de fuente de poder'),
  ('Problema de sonido', '2020-08-08', 8, 8, 3, 3, 'Se realizaron pruebas y ajustes en el sistema de audio'),
  ('Lentitud extrema', '2020-09-09', 9, 9, 4, 4, 'Se optimizó el sistema operativo'),
  ('Pantalla parpadeante', '2020-10-10', 10, 10, 5, 5, 'Se reemplazó el cable de video'),
  ('Problema de arranque', '2020-11-11', 11, 1, 1, 1, 'Reparación exitosa'),
  ('Pantalla rota', '2020-12-12', 12, 2, 2, 2, 'Se requiere reemplazo de pantalla'),
  ('Sobrecalentamiento', '2021-01-13', 13, 3, 3, 3, 'Limpieza y cambio de pasta térmica realizado'),
  ('Batería no carga', '2021-02-14', 14, 4, 4, 4, 'Se reemplazó la batería'),
  ('Teclado no funciona', '2021-03-15', 15, 5, 5, 5, 'Se realizó la reparación del teclado'),
  ('Problemas de conectividad', '2021-04-16', 16, 6, 1, 1, 'Reparación exitosa'),
  ('No enciende', '2021-05-17', 17, 7, 2, 2, 'Se requiere cambio de fuente de poder'),
  ('Problema de sonido', '2021-06-18', 18, 8, 3, 3, 'Se realizaron pruebas y ajustes en el sistema de audio'),
  ('Lentitud extrema', '2021-07-19', 19, 9, 4, 4, 'Se optimizó el sistema operativo'),
  ('Pantalla parpadeante', '2021-08-20', 20, 10, 5, 5, 'Se reemplazó el cable de video'),
  ('Problema de arranque', '2021-09-21', 11, 1, 1, 1, 'Reparación exitosa'),
  ('Pantalla rota', '2021-10-22', 12, 2, 2, 2, 'Se requiere reemplazo de pantalla'),
  ('Sobrecalentamiento', '2021-11-23', 13, 3, 3, 3, 'Limpieza y cambio de pasta térmica realizado'),
  ('Batería no carga', '2021-12-24', 14, 4, 4, 4, 'Se reemplazó la batería'),
  ('Teclado no funciona', '2022-01-25', 15, 5, 5, 5, 'Se realizó la reparación del teclado'),
  ('Problemas de conectividad', '2022-02-26', 16, 6, 1, 1, 'Reparación exitosa'),
  ('No enciende', '2022-03-27', 17, 7, 2, 2, 'Se requiere cambio de fuente de poder'),
  ('Problema de sonido', '2022-04-28', 18, 8, 3, 3, 'Se realizaron pruebas y ajustes en el sistema de audio'),
  ('Lentitud extrema', '2022-05-29', 19, 9, 4, 4, 'Se optimizó el sistema operativo'),
  ('Pantalla parpadeante', '2022-06-30', 20, 10, 5, 5, 'Se reemplazó el cable de video'),
  ('Problema de arranque', '2022-07-01', 11, 1, 1, 1, 'Reparación exitosa'),
  ('Pantalla rota', '2022-08-02', 12, 2, 2, 2, 'Se requiere reemplazo de pantalla'),
  ('Sobrecalentamiento', '2022-09-03', 13, 3, 3, 3, 'Limpieza y cambio de pasta térmica realizado'),
  ('Batería no carga', '2022-10-04', 14, 4, 4, 4, 'Se reemplazó la batería'),
  ('Teclado no funciona', '2022-11-05', 15, 5, 5, 5, 'Se realizó la reparación del teclado'),
  ('Problemas de conectividad', '2022-12-06', 16, 6, 1, 1, 'Reparación exitosa'),
  ('No enciende', '2023-01-07', 17, 7, 2, 2, 'Se requiere cambio de fuente de poder'),
  ('Problema de sonido', '2023-02-08', 18, 8, 3, 3, 'Se realizaron pruebas y ajustes en el sistema de audio'),
  ('Lentitud extrema', '2023-03-09', 19, 9, 4, 4, 'Se optimizó el sistema operativo'),
  ('Pantalla parpadeante', '2023-04-10', 20, 10, 5, 5, 'Se reemplazó el cable de video');
-- Continúa con más inserciones...




###########################
# STORE PROCEDURES -------#
###########################

# 1 Crear un store procedure para mostrar la lista de cliente
DELIMITER //

CREATE PROCEDURE sp_listar_clientes()
BEGIN
  SELECT * FROM clientes;
END //

DELIMITER ;


# llamar al Store procedure ListarClientes
CALL sp_listar_clientes();


# Borrar el sp sp_listar_clientes
DROP PROCEDURE sp_listar_clientes;




# 2 Crear un Store procedure para agregar Marcas
DELIMITER //

CREATE PROCEDURE sp_agregar_marca(
  IN marca_nombre VARCHAR(50)
)
BEGIN
  INSERT INTO marcas (marca) VALUES (marca_nombre);
  SELECT * FROM marcas;
END //

DELIMITER ;


# llamar al Store procedure sp_agregar_marca
CALL sp_agregar_marca('Nueva Marca');

# Borrar el sp sp_listar_clientes
DROP PROCEDURE sp_agregar_marca;




# 3 Crear un Store procedure para eliminar una marca por ID
DELIMITER //

CREATE PROCEDURE sp_eliminar_marca(
  IN marca_id INT
)
BEGIN
  DELETE FROM marcas WHERE id_marca = marca_id;
  SELECT * FROM marcas;
END //

DELIMITER ;

# llamar al Store procedure sp_eliminar_marca
CALL sp_eliminar_marca(8);

# Borrar el sp sp_eliminar_marca
DROP PROCEDURE sp_eliminar_marca;

SELECT * FROM marcas;







###########################
# FUNCIONES --------------#
###########################

# Crear la funcion fn_contar_ordenes

DELIMITER //

CREATE FUNCTION fn_contar_ordenes()
RETURNS INT
BEGIN
  DECLARE cantidad_ordenes INT;
  SELECT COUNT(*) INTO cantidad_ordenes FROM ordenes;
  RETURN cantidad_ordenes;
END //

DELIMITER ;

# Ejecutar la funcion fn_contar_ordenes
SELECT fn_contar_ordenes();







###########################
# VISTAS -----------------#
###########################

# Crear vista simple que muestre los datos de la tabla equipos
CREATE VIEW v_equipos AS
SELECT * FROM equipos;

# LLamar a la vista
SELECT * FROM v_equipos;



# Crear una vista compuesta que muestre la cantidad de ordenes por cliente
CREATE VIEW v_cliente_ordenes AS
SELECT c.nombre, c.apellido, COUNT(o.id_orden) AS cantidad_ordenes
FROM clientes c
LEFT JOIN ordenes o ON c.id_cliente = o.id_cliente
GROUP BY c.id_cliente;

# LLamar a la vista
SELECT * FROM v_cliente_ordenes;







###########################
# COMANDOS GENERALES -----#
###########################

# Para mostrar todas las tablas existentes
SHOW FULL TABLES;

# Para mostrar todas las vistas existentes
SHOW FULL TABLES WHERE TABLE_TYPE = 'VIEW';

# Para mostrar los SP existentes
SHOW PROCEDURE STATUS WHERE Db = 'servicio_tecnico';

# Para mostrar todas las funciones existentes
SHOW FUNCTION STATUS WHERE Db = 'servicio_tecnico';

SHOW FUNCTION WHERE Db = 'servicio_tecnico';

# Como mostramos la estructura de las tablas.
DESCRIBE ordenes;

# Como podemos vaciar de datos una tabla y resetear sus ontadores.
TRUNCATE ordenes;

# Ver el contenido de las tablas
SELECT * FROM ordenes;



SELECT * PROCEDURES FROM 'empresa';



# Ejercicios sobre vistas

CREATE VIEW vista_clientes_equipos AS
SELECT 
    c.nombre AS nombre_cliente,
    c.apellido AS apellido_cliente,
    e.modelo AS modelo_equipo,
    e.descripcion AS descripcion_equipo
FROM 
    clientes c
JOIN 
    ordenes o ON c.id_cliente = o.id_cliente
JOIN 
    equipos e ON o.id_equipo = e.id_equipo;
    

SELECT * from vista_clientes_equipos;


#**************************
# Ejercicios con triggers
#**************************

/* Ejercicio 1: Actualizar el contador de clientes
Cuando se inserta un nuevo cliente en la tabla clientes, 
se incrementará el contador cantidad_clientes en la tabla contadores.
*/

DELIMITER $$

CREATE TRIGGER tg_incrementar_cliente
AFTER INSERT ON clientes
FOR EACH ROW
BEGIN
  UPDATE contadores
  SET cantidad_clientes = cantidad_clientes + 1
  WHERE id_contador = 1;
END $$

DELIMITER ;


/* Ejercicio 2: Actualizar la fecha de último ingreso del cliente
Cuando se actualiza un cliente en la tabla clientes, 
se actualizará la columna ultimoIngreso con la fecha y hora actuales.
*/
DELIMITER $$

CREATE TRIGGER tg_actualizar_ultimo_ingreso
BEFORE UPDATE ON clientes
FOR EACH ROW
BEGIN
  SET NEW.ultimoIngreso = CURRENT_TIMESTAMP();
END $$

DELIMITER ;

-- UPDATE clientes SET nombre = "Mario" WHERE nombre = "María" ;
-- Me da error Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
UPDATE clientes SET nombre = "Mario" WHERE id_cliente = 3;
SELECT * FROM clientes;


/*
Ejercicio 3: Validar número de serie único para equipos
Antes de insertar un nuevo equipo, se verificará que el numero_serie no exista en la tabla equipos.
*/

DELIMITER $$

CREATE TRIGGER validar_numero_serie_unico
BEFORE INSERT ON equipos
FOR EACH ROW
BEGIN
  IF (SELECT COUNT(*) FROM equipos WHERE numero_serie = NEW.numero_serie) > 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'El número de serie ya existe.';
  END IF;
END $$

DELIMITER ;