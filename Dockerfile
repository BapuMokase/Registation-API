# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.7-amazoncorretto-17 AS build

# Set the working directory in the container
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests && ls -l target

# Use a smaller runtime image
FROM amazoncorretto:17

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
