FROM maven:3.6.3-openjdk-8 AS build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine

ARG JAR_FILE=usr/src/app/target/*.jar
COPY --from=build $JAR_FILE /usr/app/app.jar

ENTRYPOINT exec java -jar /usr/app/app.jar
EXPOSE 10001
