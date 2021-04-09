FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE /app.jar
ENTRYPOINT exec java -jar /app.jar
EXPOSE 5001
