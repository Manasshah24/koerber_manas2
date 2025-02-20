# Use an official OpenJDK image as the base
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ingress_ms2.jar ingress_ms2.jar

# Expose the port (ensure this matches Spring Boot configuration)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "ingress_ms2.jar"]
