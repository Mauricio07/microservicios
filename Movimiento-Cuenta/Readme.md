
# Movimiento - Cuenta

Esta aplicación es un microservicio **REST** desarrollado con **Java 17** y **Spring Boot 3.2.3**, diseñado para manejar transacciones de clientes a través de una arquitectura basada en microservicios. Utiliza **Maven 3.2.3** como herramienta de construcción y gestión de dependencias, y cuenta con un archivo `Dockerfile` para su despliegue en contenedores.

## Arquitectura

La aplicación sigue una arquitectura modular y está organizada en las siguientes capas:

### 1. **Controller**
Ubicada en la carpeta `controller`, esta capa contiene los controladores que manejan las solicitudes HTTP entrantes. Los controladores actúan como la interfaz principal entre el cliente y el microservicio.

### 2. **Database**
En esta carpeta se gestiona la interacción con la base de datos. Se divide en dos subcarpetas:

- **Repository**: Interfaces que extienden `JpaRepository` o `CrudRepository` para realizar las operaciones CRUD en las entidades de la base de datos.
- **Models**: Clases que representan los modelos de datos mapeados a las tablas de la base de datos.

### 3. **Feign**
Aquí se encuentra la integración con otros microservicios mediante **Feign clients**. Esta carpeta contiene las clases que definen cómo se comunican los microservicios, en este caso, el microservicio cliente.

### 4. **Rest**
Esta carpeta contiene la lógica para construir las respuestas RESTful que la aplicación envía a los clientes:

- **Builder**: Clases encargadas de construir y devolver los modelos que se utilizan en las respuestas REST.

### 5. **DTO**
Ubicada en la carpeta `dto`, aquí se encuentran los **Data Transfer Objects** que viajan entre el cliente y el servidor en las peticiones y respuestas. Los DTO son una representación de los datos que se deben transferir, manteniendo la separación entre las capas internas de la aplicación y la lógica del cliente.

### 6. **Enums**
Esta carpeta contiene las enumeraciones que se utilizan en la aplicación, ayudando a mantener el control de valores constantes o bien definidos.

### 7. **Services**
Contiene la lógica de negocio, que se divide en:

- **Operators**: Aquí es donde se encuentran las operaciones y procesos lógicos de la aplicación.

### 8. **Exceptions**
Esta carpeta maneja las excepciones personalizadas que pueden ocurrir en la aplicación. Mejora el manejo de errores y permite proporcionar mensajes claros en caso de fallos.

## Tecnologías Utilizadas

- **Java**: 17
- **Spring Boot**: 3.2.3
- **Maven**: 3.2.3
- **Feign**: Para la comunicación con otros microservicios
- **Docker**: La aplicación cuenta con un `Dockerfile` para su despliegue en contenedores

## Despliegue con Docker

La aplicación incluye un `Dockerfile` que permite empaquetar la aplicación en un contenedor Docker. Para construir y ejecutar la aplicación en Docker:

1. Construir la imagen Docker:
   ```bash
   docker build -t service-cuenta .
   ```

2. Ejecutar el contenedor:
   ```bash
   docker run -p 8080:8080 service-cuenta
   ```

## Requisitos Previos

- **JDK 17** o superior.
- **Maven 3.2.3**.
- **Docker** (opcional, para despliegue en contenedores).

## Cómo Ejecutar la Aplicación

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Mauricio07/microservicios
   ```

2. Navegar al directorio del proyecto:
   ```bash
   cd service-cuenta
   ```

3. Compilar y empaquetar la aplicación:
   ```bash
   mvn clean package
   ```

4. Ejecutar la aplicación:
   ```bash
   java -jar target/service-cuenta.jar
   ```

## Contacto

Para preguntas o asistencia, por favor contacta a [emauricioh7@gmail.com](mailto:tu-email@dominio.com).
