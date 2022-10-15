FROM maven:3.6.3-openjdk-8 AS build

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

RUN apt-get update && apt-get install -y wget &&\
    wget https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png -P /usr/src/app/src/main/resources/static &&\
    mvn -f /usr/src/app/pom.xml clean package -DskipTests


FROM openjdk:8-jdk-alpine

LABEL WHO="Акимов Валерий Евгеньевич ИКБО-01-19"

ARG JAR_FILE=usr/src/app/target/*.jar
COPY --from=build $JAR_FILE /usr/app/app.jar

ENTRYPOINT exec java -jar /usr/app/app.jar
EXPOSE 10001
ONBUILD RUN echo "Сборка и запуск произведены. Автор: Акимов Валерий Евгеньевич"
