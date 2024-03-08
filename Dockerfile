# Stage 1: Build the application
FROM maven:3.8.4-openjdk-20-slim AS build
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Create the Docker container
FROM openjdk:20-jdk-slim
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
