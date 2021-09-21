FROM openjdk:16-alpine3.13
ADD ./target/gateway-0.0.1-SNAPSHOT.jar gateway-service.jar
ENTRYPOINT ["java","-jar","/gateway-service.jar"]