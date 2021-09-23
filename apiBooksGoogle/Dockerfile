FROM openjdk:16-alpine3.13
ADD ./target/com.api.google.books-0.0.1-SNAPSHOT.jar books-service.jar
ENTRYPOINT ["java","-jar","/books-service.jar"]