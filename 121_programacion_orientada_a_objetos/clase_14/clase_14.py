import sqlite3

bd = sqlite3.connect("./121_programacion_orientada_a_objetos/clase_14/example.db")
print("Base de datos abierta")

cur = bd.cursor()

# Crear una tabla
cur.execute('''CREATE TABLE IF NOT EXISTS stocks
               (date text, trans text, symbol text, qty real, price real)''')

# Insertar un registro
cur.execute("INSERT INTO stocks VALUES ('2020-01-05','BUY','RHAT',100,35.14)")

# Guardar los cambios
bd.commit()

#Seleccionar el primer registro coincidente
t = ['RHAT']
cur.execute('SELECT * FROM stocks WHERE symbol=?', t)
print(cur.fetchone())

# En este caso, se insertan muchos registros a la vez
purchases = [['2006-03-28', 'BUY', 'SONY', 1000, 45.00],
             ('2006-04-05', 'BUY', 'MSFT', 1000, 72.00) ,
             ('2006-04-06', 'SELL', 'IBM', 500, 53.00),
            ]
cur.executemany('INSERT INTO stocks VALUES (?,?,?,?,?)', purchases)

#Sentencia para eliminar
symbol = 'SONY'
sentencia = "DELETE FROM stocks WHERE symbol = ?;"

#Eliminar el REGISTRO
#cur.execute(sentencia, [symbol])
#bd.commit()
#print("Eliminado con éxito")

#Sentencia para actualizar
qty = 1500
price = 85.00
symbol = 'MSFT'
sentencia = "UPDATE stocks SET qty = ?, price = ? WHERE symbol = ?;"

#Actualizar datos
cur.execute(sentencia, [qty, price, symbol])
bd.commit()
print("Datos guardados")

# Este ejemplo usa la forma con un iterador
for row in cur.execute('SELECT * FROM stocks ORDER BY price'):
    print(row)

# Se recomienda cerrar la conexión a la BD si hemos terminado.
# Solo debemos asegurarnos de que se hayan aplicado los cambios o se perderán.
bd.close()