# Use Maven or Gradle base image to build the JAR
FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY src ./src
COPY pom.xml ./
RUN mvn package -DskipTests

# Use OpenJDK image to run the built JAR
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build /app/target/superprice-app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
