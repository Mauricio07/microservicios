
# Gateway de Microservicios

Este proyecto es un **API Gateway** diseñado para gestionar la comunicación entre microservicios mediante **Netflix Eureka** como servidor de descubrimiento, y configurado para distintos entornos (desarrollo y producción). El proyecto está desarrollado en **Java 17** y utiliza **Spring Cloud Gateway** para manejar el enrutamiento de las peticiones a los microservicios registrados.

## Arquitectura

### Eureka Server

- La comunicación entre los microservicios se gestiona a través de **Netflix Eureka**, un servidor de descubrimiento que facilita el registro y la localización de microservicios. El Gateway se ejecuta en el puerto **8085** y actúa como el punto de entrada para todas las solicitudes, redirigiendo el tráfico a los microservicios correspondientes.

### Configuraciones por Ambiente

El comportamiento del Gateway varía dependiendo del entorno en el que se ejecute (desarrollo o producción):

- **Desarrollo**: Se utiliza **localhost** junto con los puertos correspondientes de los microservicios.
- **Producción**: Los nombres de los contenedores se utilizan para la comunicación entre los servicios.

Las configuraciones de estos entornos están organizadas en los archivos **properties**, donde se define la conexión a los servicios dependiendo del entorno.

### Configuración de CORS

Para permitir el acceso a la API Gateway desde diferentes dominios, se implementó la configuración de **CORS** en la carpeta `config`. Esto asegura que los navegadores puedan hacer solicitudes cross-origin controladas, protegiendo la aplicación de posibles problemas de seguridad y asegurando la comunicación adecuada con los microservicios.

## Tecnologías Utilizadas

- **Java**: 17
- **Spring Boot**: 3.2.3
- **Spring Cloud Gateway**: Para el enrutamiento de peticiones.
- **Eureka Server**: Para el registro y descubrimiento de microservicios.
- **Maven**: 3.2.3, utilizado para gestionar las dependencias del proyecto.
- **Docker**: Se incluye un `Dockerfile` para facilitar el despliegue en contenedores.

## Despliegue con Docker

La aplicación Gateway incluye un `Dockerfile` que permite su empaquetado y despliegue en un contenedor Docker.

### Pasos para Construir y Ejecutar el Contenedor

1. **Construir la imagen Docker**:
   ```bash
   docker build -t gateway .
   ```

2. **Ejecutar el contenedor**:
   ```bash
   docker run -p 8085:8085 gateway
   ```

En producción, el gateway se comunicará con otros microservicios utilizando los nombres de los contenedores registrados en **Eureka**.

## Configuración de Entornos

El proyecto cuenta con diferentes archivos de configuración dependiendo del entorno de ejecución. Las configuraciones clave están en los archivos **`application.properties`** y **`application-prod.properties`**:

- **Desarrollo** (`application.yml`):
  ```properties
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
  ```

- **Producción** (`application-prod.yml`):
  ```properties
  eureka.client.service-url.defaultZone=http://eureka-server:8761/eureka/
  ```

## Requisitos Previos

- **Java 17** o superior.
- **Maven 3.2.3**.
- **Docker** (opcional, para el despliegue en contenedores).

## Cómo Ejecutar el Proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Mauricio07/microservicios.git
   ```

2. **Navegar al directorio del proyecto**:
   ```bash
   cd gateway
   ```

3. **Construir el proyecto con Maven**:
   ```bash
   mvn clean package
   ```

4. **Ejecutar la aplicación**:
   ```bash
   java -jar target/gateway.jar
   ```

## Contacto

Si tienes preguntas o necesitas asistencia, puedes contactarme en [emauricioh7@gmail.com](mailto:tu-email@dominio.com).
