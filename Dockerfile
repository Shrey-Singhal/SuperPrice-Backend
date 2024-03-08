# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/superprice-app-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available outside this container
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "app.jar"]
