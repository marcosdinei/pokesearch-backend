FROM maven:3.8.8-eclipse-temurin-21-alpine as maven
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:21-jdk
WORKDIR /app
COPY --from=maven /app/target/teste-0.0.1-SNAPSHOT.jar teste.jar
EXPOSE 8080

CMD ["java", "-jar", "teste.jar"]