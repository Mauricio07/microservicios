
# Proyecto de Microservicios

Este proyecto consta de cuatro microservicios, cada uno ubicado en su respectiva carpeta con su propio Dockerfile. Para crear y ejecutar los contenedores, se utiliza Docker Compose, que también se encarga de crear la base de datos PostgreSQL y compilar las imágenes de cada carpeta.

## Estructura del Proyecto

- **Cliente-Persona**: Contiene el microservicio de cliente persona.
- **Movimiento-Cuenta**: Contiene el microservicio de movimiento de cuenta.
- **Discovery**: Microservicio de descubrimiento que permite asociar los otros microservicios.
- **Gateway**: Microservicio que unifica todos los microservicios y permite la comunicación entre ellos.

## Requisitos

- Docker
- Docker Compose

## Instrucciones de Uso

1. **Clonar el repositorio**:

    ```sh
    git clone https://github.com/Mauricio07/microservicios.git
    cd microservicios
    ```

2. **Estructura de Carpetas**:

    Asegúrate de que la estructura de carpetas sea la siguiente:

    ```
    .
    ├── Cliente-Persona
    │   └── Dockerfile
    ├── Movimiento-Cuenta
    │   └── Dockerfile
    ├── Discovery
    │   └── Dockerfile
    ├── Gateway
    │   └── Dockerfile
    ├── docker-compose.yml
    └── init.sql
    ```

3. **Archivo `docker-compose.yml`**:

    Asegúrate de que tu archivo `docker-compose.yml` esté configurado correctamente para crear la base de datos PostgreSQL y compilar las imágenes de cada carpeta.

4. **Crear y levantar los contenedores**:

    Ejecuta el siguiente comando para levantar todos los servicios:

    ```sh
    docker-compose up --build
    ```

    Este comando creará la base de datos PostgreSQL y compilará las imágenes de cada microservicio.

## Descripción de los Microservicios

- **Cliente-Persona**: Este microservicio gestiona la información de los clientes.
- **Movimiento-Cuenta**: Este microservicio gestiona los movimientos de las cuentas.
- **Discovery**: Este microservicio descubre y asocia los otros microservicios.
- **Gateway**: Este microservicio actúa como un punto de entrada unificado para todos los microservicios, permitiendo la comunicación entre ellos.

## Notas

- Asegúrate de que los puertos necesarios estén disponibles y no en uso por otros servicios.
- Puedes modificar las configuraciones en el archivo `docker-compose.yml` según tus necesidades.
