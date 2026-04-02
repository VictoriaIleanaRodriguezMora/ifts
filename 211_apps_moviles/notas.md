EMPTY ACTIVITY

![alt text](image.png)

Name: Nombre del proyecto
package name: reverse domain, es un dominio al reves. tiene que ser unico.
localmente puede tener el nombre que quiera, aunque ya exista. pero cuando lo quiera publicar en  playstore no me va a dejar publicarlo porque ya existe un dominio con ese nombre

tiene que ver tambien con como se nombran los paquetes en java

Save location: Ubicacion donde se va a crear el proyecto

Minimum SDK: Android API Level - muy importante
API 27 Corresponde a android 8.1
el mínimo api level, el minimo SDK que yo voy a elegir paara que corra mi dispositivo va a ser android 8. osea alguien con android 7.99 no lo va a poder ejecutar 

esto reestringe el mercado

![alt text](image-1.png) esta parte me dice las caracteristicas que tengo con esta version. los logs de version 

la default es android 8 

https://apilevels.com/


build: transformar el codigo fuente y empaquetar toda la aplicacion y dejarlo listo para correr en codigo maquina 

# VISTAS
hay varias vistas. al tocar en el desplegable android se despliegan vistas 
![alt text](image-2.png)

app > kotlin + java > tengo carpetas con el nombre de mi package 
![alt text](image-3.png)


kotlin y java estan intrinsicamente relacionados. comparten caracteristicas

![alt text](image-6.png)

KOtlin es mas formal en su forma de trabajar que python


todos estos imports son las librerias que yo necesito para trabajar
![alt text](image-7.png)

# Parte lógica y reactiva
![alt text](image-8.png)

siempre vamos a trabajar con composable, todo es un composable 
son funciones de kotlin 

# clases en kotlin

no me figura esta línea
![alt text](image-9.png)

# scaffold/andamio - android
es la estructura de la que yo voy a partir
va a contener a mi aplicación 
![alt text](image-10.png)

en la clase defino los parametros y en el composable SELECCIONO LA FUNCION, que quiero que haga y uso los parametros

# Correr el proyecto 
Device manager > + > Create virtual device > 
![alt text](image-11.png)

los que tienen el ícono de google playstore quiere decir que tienen todos los servicios de google, entonces nos vamos a poder loguear con nuestra cuenta de gmail, en la tienda.

![alt text](image-12.png)
![alt text](image-13.png)
`API`. Que version de android va a tener el dispositivo
![alt text](image-14.png)
`SERVICES`
![alt text](image-15.png)
En `System image`, me dice que tengo que bajarme la imagen para la virtualización de este dispositivo
`Additional settings`
![alt text](image-16.png)
Emulated performance
![alt text](image-17.png)

finish

en device manager tengo ahora este dispositivo. le doy play
![alt text](image-18.png)
y voy al de abajo, a `RUNNING DEVICES`


# ESTO ES LO BASICO CON LO QUE PUEDO CORRER LA APP
![alt text](image-19.png)

# cambiar tamaño de fuente
![alt text](image-20.png)

# BUILD REAL
la 1ra compilacion es de mentirita, es un build de dependencias, pero no es un build de la app
![alt text](image-21.png)

ÍCONO DE BUILD
![alt text](image-22.png)
BUILD SUCCESSFUL in 1m
35 actionable tasks: 35 executed
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.3.1/userguide/configuration_cache_enabling.html

Build Analyzer results available

# logs
con el filtro package:mine, veo las cosas de solamente mi paquete
![alt text](image-23.png)

dentro de setcontent le indico a composable cual va a ser la interfaz que va a mostrar 

la funcion saludo, está marcada como Composable, con el decorador @composable, significa que puede dibujar partes de la interfaz

finalmente, el primer composable meustra el texto en pantalla

# hot reload, solo compila lo que cambié
![alt text](image-24.png)

01.15.00
hacer que las cosas cambien al hacer click

01.20.00 los textos se superponen porque tengo un Column y un Box  ocupando el ancho maximo
![alt text](image-25.png)
![alt text](image-26.png)

para  solucionar esa competencia, saco el  box, y pongo los  textos dentro de la columna
![alt text](image-27.png)

+ formal es dividir en composables

# funcion para reutilizar las propiedades del texto
![alt text](image-28.png)

01.30.00
usando las variables del activity main
![alt text](image-29.png)

01.34.00 - variables de android
