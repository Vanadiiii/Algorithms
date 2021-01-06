FROM openjdk:8-jdk-alpine
MAINTAINER IvanMatveev
ARG JAR_PATH=target/*.jar
COPY ${JAR_PATH} /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
