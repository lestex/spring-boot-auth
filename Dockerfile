FROM maven:3.5.3-jdk-8 as build

COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8

RUN mkdir /app

COPY --from=build /usr/src/app/target/auth-0.0.1-SNAPSHOT.jar /app/auth-0.0.1-SNAPSHOT.jar  

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/auth-0.0.1-SNAPSHOT.jar"]
