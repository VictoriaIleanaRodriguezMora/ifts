# Clase 09
# FinOps: Gestión financiera de la nube

La idea es que la parte financiera se ponga de acuerdo con la parte operativa para tener el mejor rendimiento  y obtener los mayores beneficios 

La parte financiera se va a fijar en el costo, no va a tener mucha idea de qué es lo que se contrata o no.

La parte operativa, que en grla va a querer estar mas dimensionado, preparado para cualquier escalabilidad, emergencia. Trata ed considerar lo que se necesita para le mejor servicio

No siempre van a coincidir estos 2 criterios, se llega a un punto intermedio. 

# ¿Porqué surge FinOps?
- La adopción de la nube, cambió el modelo tradicional de costos
- El gasto dejó de ser fijo y pasó a ser variable y dinámico
- Las decisiones técnicas impactan directamente en el presupuesto
- Surge para ordenar, gobernar y optimizar ese nuevo escenario

# Definición ampliada de FinOps
- Práctica de gestión financiera aplicada a la nube
- combina procesos, personas y tecnologías
- Busca maximiar el valor del negocio generado por el cloud
- promueve responsabilidad compartida entre IT, finanzas y negocio
  - IT se refiere a los responsables del área, los que lo van a administrar, no a los devs. 
  - negocio se refiere a cliente
- se basa en mejora continua y toma de decisiones informadas

# Alcance de FinOps
- visibilidad y entendimiento del gasto en la nube
- asignación de costos por área, proyecto o productos
- optimización del uso de recursos cloud
- soporte a las decisiones de arquitectura y escalabilidad
- gobierno del consumo en entornos multicloud
  - nosotros podemos tener equipos en distintas nubes, en distintos proveedores

dependendiendo de la complejidad y uso que le va a dar al servidor, el area financiera quiere asignar un costo proporcional a cada area. 

la idea de llevar un servicio/servidor a la nube es ahorrarnos ciertos costos, cómo mantenimiento, contingencias electricas, 
mismo la nube puede estar caida si tienen un ataque, filtracion, etc algun ataque virtual, tmb se puede ver pausado el servicio. 

# Qué no es FinOps
- no es solamente reducir costos sin criterio técnico
- no es responsabilidad exclusiva dle area financiera
- no se trata de apagar servicios críticos
- no es una actividad puntual o aislada
- no reemplaza la plnificacion, la complementa

# beneficios grales de FinOps
- mayor transparencia del gasto en la nube
- mejor prevision y control presupuestario
- uso mas eficiente de los recursos tecnológicos
- alineacion entre objetivos técnicos y financieros
- reduccion de desperdicio sin afectar la calidad del servicio

# beneficios para equipos de IT
- justificar decisiones tecnicas con impacto economico
- diseñar arquitecturas eficientes
- detectar recursos sobredimensaionados
- mejorar la planificacion de capacidad
- ganar autonomia en decisiones basadas en datos


# beneficios para finanzas 
- visibilidad clara del gasto mensual
- asignacion de costos por centro de responsabilidad
- mejor estimación de presupuestos futuros
- reduccion de sorpresas en facturacion cloud
- mejor comunicacion con áreas tecnicas

# casos de uso reales de finops
- identificacion de máquinas virtuales sobredimensionadas
- deteccion de recursos sin uso o abandonados
- control de costos en ambientes de desarrollo y testing
  - no tener infinitos creditos/recursos
- asignacion de costos por proyecto o app
  - dividir el gasto por area
- evaluacion del impacto economigo de nuevas soluciones
  - métricas que permitan planificar cuanto puede salir un desarrollo, que inconvenientes tuvimos.

# ejemplos de infra sobredimensionada
- una empresa migra servidores a la nube sin ajustes    
- el consumo de cpu y memoria es bajo
- finops detecta sobredimensionamiento
- se ajustan tamaños de máquinas
- resultado: ahorro mensual sostenido sin impacto operativo 

# ejemplo 2: ambientes de desarrollo
- los equipos dejan recursos encendidos fuera del horario laboral
- se implementan politicas de apagado automatico
- se asignan costos visibles por equipo
- los desarrolladores toman conciencia del impacto
- resultado: revision significativa del gasto

# finops mercadolaboral
- es una competencia transversal

# rol del profesional it en finops
- diseñar soluciones eficientes y escalables
- evaluar impacto economico de decisiones tecnicas
- colaborar activamente econ finanzas
- promover buenas practicas dentro del equipo
- adoptar una mentalidad de mejora continua

es una forma moderna de gestionar tecnologias
integra persoans, procesos y negocio
permite usar la nube de forma responsable