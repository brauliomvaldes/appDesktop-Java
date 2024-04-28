# appDesktop-Java-mySQL
Aplicación desktop para gestionar libros en una biblioteca, programada en lenguaje Java, interface java Swing, base de datos MySQL modelo ADO y empleando patrón MVC

Creado en un ambiente de desarrollo con JDK 8 y NetBeans 8.2 para correr con Java.

*  Programado en:

- Java 8
- javax swing
- mysql con jdbc version 5 pero también se incluye versión 8
- procesos almacenados en base de datos
- Editar clase conexion (singletón) para adecuar string de conexion a mysql según su necesidad, para trabajo en localhost.
- Ejecutar script de creación de base de datos, tablas y procesos almacenados con la versión jdbc instalada para evitar incompatibilidades.

* Modo básico de operación

- Primero se debe ingresar la compra de los libros, luego es posible arrendar y vender libros.
- Por requerimiento las tablas estado y forma_pago tiene datos en duro
- En los mantenedores, el botón con símbolo '@' a un lado de los combobox permite actualizar luego de haber agregado contenido.
