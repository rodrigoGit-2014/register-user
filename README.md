# Creación Usuarios REST API.


##  Instalación y ejecución de la aplicación 
  
  1. ```bash
     1. ./gradlew build
     2. ./gradlew bootRun
     ``` 
 

## API

### Authentication
 |  | Description |
 | --- | ----------- |
 | URL | http://localhost:8080/authenticate |
 | METHOD | POST |
 | BODY | ``` { "username": "root", "password":"root"} ``` |
 | RESPONSE | ``` { "jwt": "eyJhbGciOiJIUzI1NiJ...."} ```|
 
### Crear Usuario 
|  | Description |
 | --- | ----------- |
 | URL | http://localhost:8080/users  |
 | METHOD | POST |
 | HEADER | Agregar token obtenido en Bearer Token |
 | BODY | ``` { "name": "rodrigo", "mail":"xx@ss.gmail.com", "password":"Njsj12"}, "phones":[{ "number":0,"cityCode":0,"countryCode":0}]``` |
 | RESPONSE | 202: Creado, 404: Error Validación|
 
 ### Listar Usuarios
 
  |  | Description |
  | --- | ----------- |
  | URL | http://localhost:8080/users |
  | METHOD | GET |
  | RESPONSE | Listado de usuarios creados.|
