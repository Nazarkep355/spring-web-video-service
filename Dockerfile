FROM openjdk:17-alpine
COPY ./target/spring-web-video-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]