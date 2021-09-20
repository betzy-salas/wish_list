FROM openjdk:16-alpine3.13
EXPOSE 8080
ADD ./target/ms-user-0.0.1-SNAPSHOT.jar microservice-user.jar
ENTRYPOINT ["java","-jar","/microservice-user.jar"]