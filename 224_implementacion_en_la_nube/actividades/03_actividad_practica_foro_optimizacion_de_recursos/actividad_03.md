# Foro: Optimización de recursos

En los últimos años, la adopción de servicios en la nube se ha consolidado como una estrategia clave para muchas organizaciones, impulsada —entre otros factores— por la promesa de reducción de costos y mayor eficiencia operativa.
Sin embargo, esta afirmación no siempre es absoluta y abre el espacio a un análisis más profundo.

Te proponemos debatir a partir de las siguientes preguntas:

# Costos ocultos en la nube

- ¿Creés que existen gastos que no se contemplan en una primera evaluación?
- Ejemplos posibles:
    - Mala configuración de recursos
    - Sobredimensionamiento (overprovisioning)
- ¿Viviste o conocés casos donde estos factores hayan impactado negativamente?

# Optimización de recursos (FinOps)
- ¿Qué tan importante es la gestión eficiente de los recursos en la nube?
- ¿Cómo influye FinOps en el control y previsibilidad de costos?
  
# Rúbrica de participación en foro colaborativo

La evaluación se basará en el nivel de participación del estudiante, considerando los siguientes criterios:

## Nivel destacado

- Participa activamente en el foro con varias intervenciones a lo largo del intercambio. 
- Sus aportes son pertinentes, reflexivos y están claramente vinculados a las preguntas propuestas.
- Interactúa con otros participantes, enriqueciendo el debate mediante comentarios, acuerdos o desacuerdos fundamentados.
- Se expresa con claridad y mantiene en todo momento un lenguaje respetuoso, constructivo y profesional, promoviendo un clima de diálogo positivo.


## Nivel adecuado
- Participa en el foro con al menos una o dos intervenciones.
- Sus aportes se relacionan con el tema, aunque con menor profundidad.
- Responde ocasionalmente a otros compañeros.
- Mantiene un trato respetuoso y una comunicación comprensible.

## Nivel básico
- Realiza una participación mínima o limitada.
- Sus aportes son superficiales o poco desarrollados.
- Presenta escasa o nula interacción con otros participantes.
- Aunque el lenguaje es generalmente adecuado, puede requerir mayor cuidado en la claridad o en el enfoque comunicativo.

# Participación:

Creo que sí, hay gastos que no se contemplan en una primera evaluación. Por lo general, un equipo de trabajo/empresa, iría a comprar los costos de cada empresa que ofrece ‘serverless’, en una tabla y optar por el que ofrezca los servicios que ellos necesitan, a menor valor.

Pero lo que no se tiene en cuenta, es el futuro. No sólo financiero. Sino, si mañana la empresa cambia de firma, licencia, contrato o por decisión propia de alguien, y ya no se quiere/puede trabajar con esa empresa que provee serverless. ¿Cómo se migra lo que se tiene allí, ya funcionando? ¿Cómo se  hace para implementar nuevamente en otro serverless?

Esa es una de las cosas que ningún proveedor te dice; que si queres irte, no vas a tener que simple y solamente cambiar la empresa a la que pagas. Sino volver a poner a funcionar el proyecto, desde cero. Configurarlo, con las formas que este nuevo proveedor tenga, volver a aprender, para que se adapte y funcione en este nuevo entorno. Eso es tiempo.

Es tiempo y dinero, que perder en producir. Tiempo que podrías haber invertido en pensar mejoras para tu negocio, ocupar tus recursos humanos, personal y dinero en otras cosas, que no sean volver a poner en marcha, algo que ya tenias funcionando. Esto, nisiquiera hablando de si se tiene que ver pausado, mientras esta migración ocurre. ¿Cuanto tiempo y dinero se pierde?

Por otra parte, otra de las cosas que no se hace ver es el hecho de que, si la app permanece mucho tiempo en reposo, al serverless gratuito o de bajo costo, le cuesta arrancar desde cero. No es inmediata su puesta en funcionamiento luego de inactividad. De la app. o de una sección/funcionalidad de la app, si permanece mucho tiempo en reposo, demora más de lo normal en volver a funcionar. Eso, no te lo dicen.

Además, serverless resuelve “todo”, no tenes que configurar “nada”, pero perdes visibilidad de todo lo que sucede en tu proyecto. Por ejemplo: no sabes cómo se maneja la seguridad, si la aplicación falla de forma inesperada y crítica, ya no alcanza con tener al personal disponible y pedispuesto a solucionarlo, porque dependes del soporte del proveedor, para poder resolverlo. No tenes acceso a logs, ni a métricas. Los planes gratuitos/base ofrecen métricas no útiles, eso se paga aparte. Tampoco podes saber de forma gratuita, qué consumo de infraestructura, tiene tu proyecto. Cuanta RAM usa/necseita, cuantos procesadores requieren para tal tarea. No tenes control de tu app. 

Y cómo último, no incluye base de datos. Osea de lo único que tendrías control en tu aplicación, es de la base de datos. Todos estos, son gastos que normalmente no se contemplan en una primera evaluación.


La gestion eficiente de los recursos en la nube va de la mano de FinOps. Dado que se necesita del personal técnico, de negocio y finanzas. Para saber hasta donde se puede llegar. Cuales son los limites de presupuesto que se pueden tener. En base a eso, el equipo puede definir necesidades. O definir, qué puede hacer con este presupuesto, el alcance que puede tener.

Sin embargo, FinOps, creo que se ve profundamente afectado, al tratarse de un entorno serverless. Porque sí, la aplicación sale rápido a producción con serverless, pero los costos son muy altos en cuanto a información acerca del proyecto.  No se puede saber con exactitud, a no ser que se pague, cuanto consume y necesita el proyecto de infraestructura. Debes pagar, para tener el conocimiento, siento que es una red donde te enredas, endeudas de entrada, para poder obtener la información y empezar a poder analizar esa información. La mesa de FinOps cuando se tiene implementado un serverles se ve reducida y depende de tener el dinero para poder pagar para acceder a la información.
