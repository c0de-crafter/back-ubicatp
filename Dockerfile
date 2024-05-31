# Usar la imagen oficial de OpenJDK como base
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Instalar Maven para compilar el proyecto dentro del contenedor
RUN apt-get update && apt-get install -y maven

# Copiar el archivo POM y las dependencias del proyecto al contenedor
COPY pom.xml .

# Copiar el código fuente del proyecto al contenedor
COPY src ./src

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para compilar y ejecutar la aplicación
CMD ["mvn", "spring-boot:run"]
