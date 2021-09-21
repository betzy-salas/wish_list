FROM openjdk:16-alpine3.13
ADD ./target/ms-user-0.0.1-SNAPSHOT.jar user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]