# Docker
Es una plataforma de contenedores, permite:
- empaquetar apps con sus dependencias
- facilita el despliegue y la portabilidad
- basado en tecnologia de contenedores

- ligero, eficiente
- portabilidad entre entornos
- aislamiento de apps
- rapido despliegue
- amplio ecosistema de imgs

# alcance de docker
- estandarizar entornos
- optimizacion de recursos
- escalabilidad
- soporte para multiples lenguajes
  
# limitaciones
- curva de aprendizaje alta
- menor aislamiento que una VM
- depende del so
- gestion de seguridad adicional 

# contenedor vs maquina virtual
contenedores
- comparten el mismo so
- son mas livianos
- es mas rapido para despliegue

maquinas virtuales
- incluyen un so completo
- mayor aislamiento


# Contenedores, imagenes y volumenes
los contenedores son nuestro desarrollo, lo que va a correr va a ser el contenedor

ventajas del contenedor por sobre una VM

tenemos un desarrollo web/app en python 

para poder generar este contenedor que va a tener la app, vamos a generar un dockerfile donde se incluye la ruta de: donde está el codigo, se aclara el lenguaje, version 
9.00
le vamos a decir qué imagen, (una imagen es el template que va a usar para correr esta app). le digo que img necesita. 

una vez que está, se corre la imagen y se genera el contenedor. 

el contenedor descarga las dependencias que necesita nuestra app, atraves de esta "VM", necesita nuestra app, la img que necesita correr y las dependencias


con una vm estamos levantando todo un SO, un monton de servicios que no vamos a usar

con docker, se levanta una app, con lo que precisa y se ejecuta. nada mas 

esto lo que tiene, es que tiene una restriccion, aislamiento, que no permite que se comuniquen los contenedores con el so de manera libre, ni entre contenedores. hay que configurarlo 


docker soluciona cuando tenes un desarrollo que queres desplegart, y no funciona. porque uno cuando hace el desarrollo, aparte de las librerias que uno incluye, versiones de pythogn, cmd, etc solo vive en mi equipo, y no donde se despliega 

en docker elegimos una imagen que tenga la version de python que necesito y ver si corre o no o si requiere otra dependencia 

podrias descargar una imagen de mac para ver cómo se comporta la app en un so mac









