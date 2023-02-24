# MI NEGOCIO - UNEXUS challenge 
#


## Para la ejecucion de la API se debe tener instalado: 
_- Java 8
- Gradle
- PostgreSQL_


## Para ejecutar la API localmente: 
- Crear una base de datos en PostgreSQL con el nombre: mi-negocio
- El usuario por default **postgres**
- En el archivo **application.properties** se debe cambiar informacion como:puerto, usuario y la contraseña de la base de datos por si se lo requiere.
- Abrir el proyecto en cualquier IDE de desarrollo como: Eclipse, IntelliJ, etc.
- Ejecutar el proyecto como: Spring Boot App
- Ingresar al puerto 8080 de la API: http://localhost:8090/prueba/api

## Para probar la API se debe:
- Para la entidad **CLIENTES**
- Listar los clientes [GET]: http://localhost:8090/prueba/api/clients/allClients
- Crear un cliente  [POST]: http://localhost:8090/prueba/api/clients/save
- Actualizar un cliente [PUT]: http://localhost:8090/prueba/api/clients/update/id
- Eliminar un cliente [DELETE]: http://localhost:8090/prueba/api/clients/delete/id
- Llamar un cliente por ID [GET]: http://localhost:8090/prueba/api/clients/id
- 
- Para la entidad **SUCURSAL**
- Listar los productos [GET]: http://localhost:8090/prueba/api/branchs/allBranchs
- Crear un producto nuevo [POST]: http://localhost:8090/prueba/api/branchs/save
- Devolver una sucursal [GET]: http://localhost:8090/prueba/api/branchs/id
- Guarda una sucursal en un cliente [POST]: http://localhost:8090/prueba/api/branchs/saveBranch/id
- Devolver sucursales por cliente [GET]: http://localhost:8090/prueba/api/branchs/branchsByClient/id


