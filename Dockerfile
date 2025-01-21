# Use an OpenJDK 17 base image (JRE for runtime)

FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build/libs directory to the container's working directory
COPY build/libs/TafDatastoreService-0.0.1-SNAPSHOT.jar /app/TafDatastoreService.jar

# Expose the port the application will run on (8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/TafDatastoreService.jar"]
