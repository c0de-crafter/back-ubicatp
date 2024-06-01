FROM openjdk:17-jdk-slim

# Instalar Maven para compilar el proyecto dentro del contenedor
RUN apt-get update && apt-get install -y maven

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar solo el archivo POM primero y resolver las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para compilar y ejecutar la aplicación
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=dev"]
