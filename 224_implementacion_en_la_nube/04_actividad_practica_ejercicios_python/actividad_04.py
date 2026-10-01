'''
La resolución de los ejercicios deberá incluir el código en un archivo .txt.
Ejercicio 1 - Primer programa
Crear un archivo llamado app.py que muestre por pantalla un mensaje de bienvenida al sistema. Utilizar la función print. El mensaje debe hacer referencia a Python o al desarrollo web.

Ejercicio 2 - Variables y tipos de datos
Declarar variables para nombre, edad y email. Mostrar un mensaje combinando dichos datos en una frase legible.

Ejercicio 3 - Entrada de datos
Solicitar por consola los datos de un usuario simulando un formulario web. Mostrar un mensaje confirmando la carga de datos.

Ejercicio 4 - Operaciones básicas
Solicitar tres números. Calcular la suma total y el promedio. Mostrar ambos resultados.

Ejercicio 5 - Estructuras condicionales
Solicitar la edad del usuario y validar el acceso. Mayor o igual a 18: acceso permitido. Caso contrario: acceso denegado.

Ejercicio 6 - Estados lógicos
Solicitar un número entero y determinar si es par o impar utilizando el operador módulo.

Ejercicio 7 - Listas y recorridos
Crear una lista con al menos cinco usuarios, recorrerla mostrando cada uno y luego indicar la cantidad total.
'''

# 1  – Primer programa
print("¡Bienvenido al sitio web de Empresa!")

# 2 – Variables y tipos de datos
name_user = "Nombre"
age_user = int(22)
email_user = "user@email.com"

mns_user = (f"Hola! Mi nombre es {name_user}, tengo {age_user} años y mi correo es {email_user}. :)")
print(mns_user)

# 3 – Entrada de datos
name_form = input("Hola! Ingresá tu nombre ")
age_form = int(input("Ahora ingresá tu edad "))
consulta_form = input("Decinos tu consulta ")

mns_form = (f"Usd ingresó los siguientes datos: \n Nombre: {name_form} \n Edad: {age_form} \n Consulta: {consulta_form}")
print(mns_form)

# 4 - Operaciones básicas
num_a = int(input("Ingresá un nro para operar "))
num_b = int(input("Ingresá otro nro para operar "))
num_c = int(input("Ingresá un último nro para operar "))

suma_nros = num_a + num_b + num_c
promedio_nros = suma_nros / 3

print(f"El rtado de sumar {num_a} + {num_b} + {num_c} es: {promedio_nros} ")


# 5 – Estructuras condicionales
age_user_5 = int(input("Ingresá tu edad "))
if age_user_5 >= 18:
    print("+18 Acceso permitido")
else: 
    print("No tenes 18 años, Acceso denegado")


#  6 – Estados lógicos
num = int(input("ingresá un num para ver si es par o impar "))

if (num % 2 == 0):
    print(f"El número {num} es PAR ");
else:
    print(f"El número {num} es IMPAR ")

#  7 – Listas y recorridos
lista_usuarios = ["Fulano", "Mengano", "Sultano", "Primo fulano", "Primo mengano"]
contador_usuarios = 0

for name in lista_usuarios:
    contador_usuarios += 1
    print("Nombre del usuario:", name)

print(f"Hay {contador_usuarios} usuarios")
