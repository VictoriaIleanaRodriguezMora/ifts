Apertura: martes, 4 de agosto de 2026, 00:00
Cierre: lunes, 19 de octubre de 2026, 00:00
Práctica orientada a la creación y estructuración de OUs, junto con la implementación y administración de Políticas de Grupo (GPO), permitiendo aplicar configuraciones centralizadas de seguridad y funcionamiento. Se destacan además buenas prácticas para la gestión eficiente de usuarios, equipos y políticas dentro de la infraestructura.


Ejercicio Práctico

Crear una OU raíz llamada GCBA.

 Dentro de esta OU, crear tres sub-OUs:

Gerencia

RecursosHumanos

SoporteTecnico

Crear tres usuarios por departamento con nombres de usuario adecuados (por ejemplo, Juan.Carlos).

Crear un grupo global de seguridad por cada departamento:

GG_Gerencia

GG_RRHH

GG_Soporte

Asignar los usuarios correspondientes a sus grupos.

  a) Restringir el acceso a configuraciones de red
    - Aplicar solo a la OU RecursosHumanos.
    - Impide modificar las propiedades de red y oculta herramientas como ncpa.cpl.

  b) Mostrar mensaje de advertencia al iniciar sesión
    - Aplicar a la OU Gerencia.

  c) Deshabilitar el uso de dispositivos USB
    - Aplicar a la OU SoporteTecnico.

Incorpore dos de las siguientes configuraciones adicionales:

- Redirección de carpeta “Mis Documentos”: Solo para los usuarios de Gerencia, hacia una ruta de red.

- Restricción de horarios de inicio de sesión: Solo permitir login en SoporteTecnico de 8:00 a 18:00.

- Auditoría de accesos: Activar la política de auditoría para accesos a objetos y aplicarla sobre una carpeta compartida.

- Denegar acceso a CMD o Regedit: Aplicar una GPO que impida el uso de la consola y el editor del registro.

- Delegación de control: Delegar en un usuario de GG_RRHH la capacidad de crear y modificar usuarios dentro de su OU.

 Entregables

- Capturas de pantalla de (en formato .JPG):

  - La estructura de OUs y grupos

  - Usuarios creados

  - Configuración de cada GPO