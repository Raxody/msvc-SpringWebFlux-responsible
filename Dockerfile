FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/responsibles-0.0.1-SNAPSHOT.jar /app/responsible.jar

ENTRYPOINT ["java","-jar","/app/responsible.jar"]