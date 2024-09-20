FROM maven:3.8.3-openjdk-17
LABEL authors="EMSOLUCION"

# Directorio de trabajo del contenedor
WORKDIR /app

# Copia los archivos
COPY pom.xml .
COPY src ./src

RUN mvn clean install

# Definir el ambiente
ENV SPRING_PROFILES_ACTIVE=prod \
    SPRING_EUREKA_URL=platform-discovery:8761 \
    TZ=America/Guayaquil


EXPOSE 8085

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "target/gateway.jar"]
