FROM openjdk:17-jdk-slim
COPY target/config-service.jar config-service.jar
ENTRYPOINT ["java", "-jar", "/config-service.jar"]