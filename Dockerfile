FROM openjdk:8-jre-bullseye

EXPOSE 8080

WORKDIR /app
COPY target/testmanager-*.jar app.jar

ENTRYPOINT java -jar app.jar