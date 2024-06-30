#!/bin/bash
# Entrypoint script to start Spring Boot with hot reload

# Set the working directory to /app
cd /app

# Start the Spring Boot application with Maven
mvn spring-boot:run &

# Inotifywait is a command line utility that will watch for filesystem changes
# and restart the application when a change is detected.
while true; do
  inotifywait -e modify,create,delete -r ./src
  kill $(pgrep -f 'mvn spring-boot:run')
  mvn spring-boot:run &
done
