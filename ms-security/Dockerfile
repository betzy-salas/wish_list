FROM openjdk:16-alpine3.13
ADD ./target/ms-security-0.0.1-SNAPSHOT.jar security-service.jar
ENTRYPOINT ["java","-jar","/security-service.jar"]