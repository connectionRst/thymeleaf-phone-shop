# Use the official Maven image to build the application
FROM maven:3-eclipse-temurin-8 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the src directory to the container
COPY pom.xml .
COPY src ./src

# Package the application as a JAR file
RUN mvn clean package -DskipTests

# Expose the application on port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["mvn", "spring-boot:run"]
