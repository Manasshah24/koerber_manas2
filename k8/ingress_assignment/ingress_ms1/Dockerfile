# Use an official OpenJDK image as the base
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ingress_ms1.jar ingress_ms1.jar

# Expose the port the app will run on (make sure this matches the port defined in your Spring Boot application)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "ingress_ms1.jar"]
