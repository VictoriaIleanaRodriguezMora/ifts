# Clase 02
# Plataformas Cloud y On Premise
# On Premise - servicios/equipos locales

En este tema se introducen los conceptos fundamentales de Tenant, Bosque (Forest) y Dominio, utilizados principalmente en entornos de gestión de identidades y servicios de directorio, explicando su función, alcance y relación entre sí dentro de una infraestructura tecnológica. Asimismo, se analizan las principales diferencias entre los servicios Cloud y On‑Premise, comparando aspectos como costos, escalabilidad, seguridad, mantenimiento y disponibilidad, con el objetivo de que el estudiante comprenda en qué contextos resulta más conveniente cada modelo de implementación.

¿qué son los servicios en la nube?
Definicion: Modelo de provision de recursos informáticos a traves de internet
El pago es por uso y escalabilidad bajo demanda.
por el tipo de servicio que se contrata, conexion de red, recursos del equipo.
escalabilidad, se refiere a como lo podemos/queremos ampliar. customizarlo a nuestro sistema/proyecto, a lo que este demanda
administracion delegada, total o parcial al proveedor 
la diferencia es donde va a estar ubicado el equipo
“nube” data center puntual en una locacion específica 

## Tipos de servicio que se pueden contratar en la nube: 
### IaaS - Infraestructura cómo servicio
provee la estructura básica: servidores, red y almacenamiento
el cliente gestiona el SO, middleware y apps que van a correr en este servidor 
alta flexibilidad y control


ejs de iaas
Microsoft azure virtual machines
amazon ec2
google compute engine
escenarios: datacenters virtuales, DR, testing

### PaaS - Plataforma cómo servicio
la plataforma viene lista para desarrollar y ejecutar aplicaciones
el proveedor gestiona infraestructura y SO
el cliente gestiona apps y datos
ejs de paas
azure app service
google app engine
aws elastic beanstalk
escenarios: desarrollo agil y despliegues rapidos


### SaaS - Software cómo servicio
aplicaciones completas accesibles vía web
el proveedor gestiona todo el stack
el cliente solo usa el software
ejs de SaaS 
microsoft 365
google workspace
salesforce
escenarios: correo, CRM, colaboracion

### Diferencias clave 06
A la hora de hacer un desarrollo, cómo futuros desarrolladores, vamos a requerir determinada infraestructura, para desarrollarlo, desplegar, para que lo consuman.

O mismo si necesito un equipo en la nube, un equipo virtual, solamente para hacer desarrollos.

IaaS: Mayor control, mayor responsabilidad. Persona que contrata queda a cargo. 
PaaS: balance entre control y simplicidad. A cargo de determinadas funciones del equipo, no de toda la ingraestructura
SaaS: mínima gestión, máximo enfoque en el negocio. Consumir el servicio que nos entrega

Modelos de responsabilidad compartida
la responsabilidad está asociada a un costo

IaaS: Cliente gestiona SO y apps. + economico, pero requiere mano de obra
PaaS: cliente gestiona apps y datos. + caro
SaaS: proveedor gestiona todo



Hay una 4ta herramienta que es sólo para despliegues, es más minimalista. FaaS
Estos 3, no són de un proveedor solo, es cómo se modeliza el tipo de servicio en la nube

AWS, Azure, OSI, Google todos tienen esta categorizacion y esta oferta.

19.00

Cómo servidor vamos a hacer practicas en una máquina que se llama Windows server
Vamos a configurar un Active Directory

## Active Directory. 20.00
Es un servicio de directorio de Microsoft
Gestiona usuarios, equipos y recursos (no solo una notebook, tablet, teleconferencia, inventario dentro de una empresa)
Permite autenticación y autorizacion centralizada

Gestiona identidades. Hay usuarios que tienen usuario y contraseña y equipos fisicos. No deja de ser un listado con una ramificacion de usuarios categorizados donde tienen distintos grupos, unidades organizativas, y el U tiene la contraseña cargada en este directorio activo. Sirve cómo bdd de usuarios y contraseñas, pero no se límita a eso.
Gestion de identidad pero para tener todo controlado.

usuario, contraseña, equipos
Fundamentos de Active Directory
Dominio
Controladores de Dominio 
LDAP
DNS Integrado

25.00 
no deja de ser un listado, con una ramificacion de usuarios. categorizados por categorias, donde van a tener distintos grupos, unidades organizativas. y el usuario va a tener cargada la contraseña dentro del directorio activo, cifrada, restringida. sirve cómo una bdd de usuarios y contraseñas.
no se limita a eso, si no que se puede ampliar a equipos y recursos en la red

gestion de identidad masiva de la empresa, es una de las grandes diferencias del active directory.
hago un cambio y replica en todos los usuarios, todos los equipos. es puntualmente de microsoft

la curva de aprendizaje es menor a linux, para parte empresarial no se usa interfaz gráfica

es mas facil de interpretar, tiene un IDE que sugiere cosas a la hs de configurar 
es mas simple para primer pantallazo


## ¿Qué es un Forest (Bosque)?
Conjunto de dominios
Comparte esquema y configuracion
Límite de seguridad en AD

Supongamos que trabajamos para ML y ML compra Andreani. Trabajamos en el área de informatica, IT. Necesitamos consumir recursos de Andreani pq se hace una fusión, se integran. A tiene q ver las cosas de ML y viceversa. Cada uno tiene su dominio distinto. 
Como se hace para unirlos y compartir recursos? Se integran generando una relacion de confianza entre estos 2 dominios y para poder generarse esa relacion para compartir dominios tienen que pertenecer al mismo bosque. Agrupación de dominios 

El concepto de bosque es la agrupacion de varios dominios, con la finalidad de que al pertenecer al mismo bosque, se puedan compartir recursos entre dominios


la curva de aprendizaje en windows es mucho menor a un linux, en cualquier version.

## ¿Qué es un tenant?

Instancia en la nube (Azure AD/Entra Id)
Aislada por organizacion
Gestion de identidades cloud

El tenant agrupa forest, hay varios forest dentro del tenant, por capas, hay dominios, hay bosques y el tenant arriba.
Es una instancia, solo puede contener un tenant, puede tener muchos dominios y forest. Agrupa lo anterior


29.00
Caracteristicas principales
Centralizacion de identidades
Seguridad y autenticacion
Escalabilidad
Integracion con servicios cloud

## Active Directory vs Azure AD
AD: On premise. estructura donde se tiene replicado una empresa. usuarios, equipos y recursos dentro del AD. Esto es “local”, instalar AD dentro de una máquina
AD: Es una aplicacion en un equipo on premise, en una maquina local dentro de la empresa. puede estar en el edificio de la empresa, o a 2 cuadras

un equipo en la nube, se accede mediante la nube. no quita que el datacenter tiene una ubicacion geografia. 

cada una tiene sus ventajas



integridad del equipo
empresas chicas no se justifica la nube, se pueden hacer las configuraciones manualmente. correo, carpeta compartida, usuarios. se pone un equipo, configurado con un servidor, con recursos  y se consume de ese servidor centralizado, que tiene salida a internet


Azure AD: Cloud
es la evolución del AD. hay configuracion, se puede gestionar lo mismo pero en un servicio en la nube, seguridad, usuarios, equipos, pero en la nube

sass, donde solo se consumia una app. microsoft evolucionó a un servicio en la nube
una app que vamos a consumir en la nube para administrar gestion de identidades y recursos dentro del dominio de la emprsa
protocolos distintos LDAP vs REST


Diferencias clave
Forest: estructura local
tenant: entorno cloud
AD tradicional vs identidad moderna

Ejemplos de uso AD
Login en red corporativa
politicas de grupo
control de acceso a recursos

Ejemplos de uso Azure AD
Acceso a office365 web
single sign on SSO 2FA
aplicaciones saas 3er modelo de servicios en la nube (se consume una app y no nos importa lo que pasa del otro lado)

#### Escenarios híbridos
sincronización con azure ad connect
identidad hibrida
continuidad entre on prem y cloud 

las empresas estan tratando de modernizarse, o encontrar su ventaja, lo que les sirva de la nube

mas que nada para cuando no se pueden compatibilizar al 100%


equipo on premise, fisica. que si la que tenemos nos queda chica, podemos contratar un servicio en la nube, respaldo 

si se corta la luz en la empresa, contamos con equipos para que el servicio se mantenga, los empleados pueden acceder igual?

en cloud eso viene resuelto 

HIBRIDOS
AD instalado en un servidor en un windows server de manera local que se conecte con un AZURE AD y que esten los dos sincronizados, con los mismos usuarios, mismos pass, recursos, cantidad de equipos. lo podemos gestionar en la nube, como local

¿para que sirve esto?
microsoft ofrece buena integracion con sus productos, entonces podemos tener ademas del usuario y contraseña, la asignacion de licencias 

supongamos que podemos hacer una distincion entre una herramienta ofimatica office 365 de lo que requiere visualizar nada mas un informe. eso tal vez no requiere una licencia 

azure ad permite gestionar licencias


el AD permite por versionado y licencias, hacer cosas que dentro de un AZURE AD van a ser pagas o van a tener una licencia particular 

infra antigua que no tolera, o no es compatible con azure ad

nos asignan un equipo con windows 10 y al querer usar azure ad, te vas a decir que determinadas caracteristicas no son compatibles, para todo eso, se vuelve al AD LOCAL, donde se configura

se sincronizan y replican los 2 a la par 

AZURE AD EVOLUCION DEL AD






