# Stage 1: Build the application
FROM maven:3.8.7-amazoncorretto-17 AS builder

# Set the working directory for the build
WORKDIR /build

# Copy the application source
COPY pom.xml .
COPY src ./src

# Build the application JAR and list the contents of the target directory for debugging
RUN mvn clean package -DskipTests && ls -l target

# Stage 2: Create the final image with the AWS Lambda adapter using a slim Corretto image
FROM public.ecr.aws/docker/library/amazoncorretto:17-al2023-headless

# Install Graphviz
RUN yum install -y graphviz

# Copy the AWS Lambda Adapter
COPY --from=public.ecr.aws/awsguru/aws-lambda-adapter:0.8.4 /lambda-adapter /opt/extensions/lambda-adapter

# Set the working directory
WORKDIR /app

RUN ls -la /app

# Copy the built JAR file from the builder stage
COPY --from=builder /build/target/*.jar /app/registation.jar

# Expose the necessary port (if running as a web server)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/registation.jar"]
