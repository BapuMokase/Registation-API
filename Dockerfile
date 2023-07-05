FROM amazoncorretto:17-alpine
COPY target/app.jar /usr/local/app.jar
EXPOSE 8009
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/app.jar"]