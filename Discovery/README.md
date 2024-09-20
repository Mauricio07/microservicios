Aquí tienes una propuesta de archivo `README.md` para tu **Discovery Service** utilizando **Eureka** para la arquitectura de microservicios:

---

# Discovery Service - Eureka Server

Este proyecto es un **Discovery Service** basado en **Netflix Eureka**, diseñado para gestionar el registro y la localización de microservicios dentro de una arquitectura distribuida. El Discovery Service es el núcleo de la arquitectura de microservicios, permitiendo que cada servicio se registre y descubra dinámicamente. Está desarrollado con **Java 17** y **Spring Boot 3.2.3**, y utiliza **Maven 3.2.3** como herramienta de construcción.

## Arquitectura

### Netflix Eureka

El **Discovery Service** actúa como un servidor **Eureka** bajo el puerto **8761**, proporcionando la capacidad de registro y descubrimiento de microservicios. Cada microservicio se registra en Eureka y puede descubrir otros servicios mediante clientes Feign o solicitudes directas a través del servidor de Eureka.

### Comunicación entre Microservicios

La comunicación entre los microservicios se realiza a través de **Feign**, una biblioteca que facilita la creación de clientes HTTP declarativos, permitiendo que los microservicios se comuniquen fácilmente entre ellos a través de sus interfaces RESTful. Feign interactúa con Eureka para descubrir las instancias disponibles de cada servicio, logrando una comunicación flexible y dinámica.

### Configuración de Descubrimiento

El comportamiento de descubrimiento y los tiempos de actualización de los microservicios se gestionan a través de los archivos de configuración **`application.properties`**, donde se pueden ajustar los intervalos de latido (heartbeat) y tiempos de expiración (lease) de las instancias. Esto permite personalizar la frecuencia con la que los servicios envían sus señales de "vivo" y cuánto tiempo un servicio debe estar inactivo antes de ser marcado como fuera de servicio.

Ejemplo de configuración en `application.properties`:

```properties
eureka.instance.lease-renewal-interval-in-seconds=10
eureka.instance.lease-expiration-duration-in-seconds=30
eureka.server.eviction-interval-timer-in-ms=2000
```

## Tecnologías Utilizadas

- **Java**: 17
- **Spring Boot**: 3.2.3
- **Eureka Server**: Para el registro y descubrimiento de servicios.
- **Feign**: Para la comunicación entre microservicios.
- **Maven**: 3.2.3, utilizado para la gestión del ciclo de vida del proyecto.

## Configuraciones

El servicio corre bajo el puerto **8761**, que es el puerto predeterminado para el servidor Eureka. Puedes acceder a la consola de Eureka a través de la siguiente URL:

- **URL del Discovery Service**: `http://localhost:8761` (para entornos locales).

En la consola de Eureka, puedes ver qué microservicios están registrados, su estado actual (activo, fuera de servicio, etc.), y las instancias de cada servicio.

## Configuración de Eureka

En el archivo `application.properties`, se encuentra la configuración de Eureka que gestiona la funcionalidad del servidor:

```properties
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.server.enable-self-preservation=false

# Configuración del intervalo de registro y descubrimiento
eureka.instance.lease-renewal-interval-in-seconds=10
eureka.instance.lease-expiration-duration-in-seconds=30
```

- **`register-with-eureka=false`**: Significa que este servicio no necesita registrarse en otro servidor de Eureka, ya que es el propio servidor.
- **`fetch-registry=false`**: El Discovery Service no necesita recuperar un registro de otro servidor, ya que actúa como servidor principal.

## Despliegue con Docker

La aplicación incluye un `Dockerfile` para que pueda desplegarse en contenedores Docker de manera sencilla.

### Construcción y Ejecución del Contenedor Docker

1. **Construir la imagen Docker**:
   ```bash
   docker build -t discovery .
   ```

2. **Ejecutar el contenedor**:
   ```bash
   docker run -p 8761:8761 discovery
   ```

## Requisitos Previos

- **Java 17** o superior.
- **Maven 3.2.3**.
- **Docker** (opcional, para el despliegue en contenedores).

## Cómo Ejecutar la Aplicación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Mauricio07/microservicios.git
   ```

2. **Navegar al directorio del proyecto**:
   ```bash
   cd discovery-service
   ```

3. **Compilar el proyecto con Maven**:
   ```bash
   mvn clean package
   ```

4. **Ejecutar la aplicación**:
   ```bash
   java -jar target/discovery.jar
   ```

## Contacto

Si tienes alguna pregunta o necesitas soporte, no dudes en contactarme en [emauricioh7@gmail.com](mailto:tu-email@dominio.com).
