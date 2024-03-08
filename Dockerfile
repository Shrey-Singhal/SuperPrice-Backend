# Stage 1: Build the application
FROM openjdk:18-jdk-slim AS build
WORKDIR /app

# Copy the Maven project definition and dependencies
COPY pom.xml .
COPY src ./src

# Build the application
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# Stage 2: Create the final image with the built application
FROM openjdk:18-jdk-slim
WORKDIR /app

# Copy the built application JAR from the build stage
COPY --from=build /app/target/*.jar /app/SuperPrice.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/SuperPrice.jar"]
