FROM openjdk:17-jdk-slim

# Instalar Maven y inotify-tools para hot reload
RUN apt-get update && apt-get install -y maven inotify-tools

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo POM y resolver las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente de la aplicación
COPY src ./src

# Copiar el script de entrada
COPY entrypoint.sh .

# Hacer ejecutable el script de entrada
RUN chmod +x entrypoint.sh

# Exponer el puerto en el que la aplicación escuchará
EXPOSE 8080

# Usar el script de entrada como el comando de inicio del contenedor
ENTRYPOINT ["./entrypoint.sh"]
