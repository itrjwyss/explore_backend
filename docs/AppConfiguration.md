# Configuración del Proyecto

## Dumb de la DB

Para poder cargar un dump de la db con al creación de tablas e insert inicial a las mismas se puede ejecutar el archivo [dumb_db.sql](dumb_db.sql)

## application.properties

Previo a ejecutar el proyecto es necesario crear el archivo `application.properties` dentro de la siguiente ruta 
`src/main/resources` posterior incluir las siguientes propiedades:

- `application.secret` con un valor alfanumérico con una longitud de 32, será utilizada como el `SecretKey` a utilizar en el algoritmo de cifrado.
- `quarkus.http.port` puerto en el que se ejecutará la aplicación.
- `quarkus.log.category."io.quarkus".level` nivel de los logs de Quarkus que se imprimirán en la consola.
- `quarkus.log.category."com.giocondalabs".level` nivel de los logs de la aplicación que se imprimirán en la consola.
- `quarkus.datasource.db-kind=mysql` indica el tipo de DB a utilizar.
- `quarkus.datasource.username` usuario para establecer conexión a la DB.
- `quarkus.datasource.password` contraseña para establecer conexión a la DB.
- `quarkus.datasource.jdbc.url` url de conexión a la base de datos en el formato `jdbc:mysql://<ip>:<port>/<db_name>?autoReconnect=true`
- `quarkus.hibernate-orm.database.generation=none` para indicar que hibernate no realice cambios sobre la DB, o `update` para que cree las tablas o aplique cambios implementados en las entidades. 


