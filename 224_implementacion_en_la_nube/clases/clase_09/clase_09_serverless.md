# Clase 09
# Serverless

Servicios que nos ofrece la nube: IaaS, Saas, Pass

todo esto se está adaptando a una categoria nueva,  que seria serverless

# Serverless - FaaS
hacer esta gestion, sin una máquina en la nube
elimina la gestion de infra, delegando servidores y escalando al proveedor de la nube

### Funciones como Servicio
las funciones pequeñas se ejecutan solo cuando son invocadas, optimiznado recursos y costos

facilita el diseño modular y reduce complejidad para mantimiento y evolucion del software

se integra facilmente con bdd y sistemas de autenticacion

### Abstracción de servidores
eliminar la necesidad de gestionar servidores, dejando esa responsabilidad al proveedor de nube 
(al contratar un servicio serveless no vamos a tener una máquina en la nube )


### ejecucion bajo demanda
se ejecutan solo cuando ocurren eventos, optimizando recursos y costos

### arquitecturas desacopladas y escalables
el enfoque serverlesss favorece arquitecturas resilientes, escalables y fáciles de mantener

## caracteristicas
los clientes no gestionan servidores ni infra, las asume el proveedor de cloud

escala automaticamente, segun la demanda, sin intervencion manual

se activa solo cuando ocurre un evento definido, optimiza

## responsabilidades
- el proveedor gestiona infra completa, hard, red, so y seguridad
- el cliente gestiona el codigo, logica de negocio, eventos, dependencias, seguridad nivel app 
- colaboran mutuamente para diseñar apps seguras y eficientes

## ventajas
- reduccion de costos operativos, permite pagar por el uso real. eliminando servidores inactivos y optimizando el gasto tecnico
- rapidez en desarrollo y despliegue. elimina la gestion de infra, acelera el desarrollo. reduce el tiempo de salidas a prd
- escalabilidad automatica. escala inmediatamente bajo demanda, reduce fallos. reduce perdida de $$ 

# ejemplos de serverless
- aws lambda
  ejecuta funciones en respuesta a eventos integrandose con multiples servicios de aws, para máxima eficiencia
- azure functions
  ofrece serverless integrada nativamente, con servicios dentro del ecosistema azure
- google cloud functions y firebase
  proporcionan soluciones serverless con integracion para apps moviles y analisis de datos


# calculadoras de precios
- https://azure.microsoft.com/es-mx/pricing/details/functions/
- https://aws.amazon.com/es/lambda/pricing/


> [!NOTE] 
> Las soluciones que simplifican todo, salen mas

