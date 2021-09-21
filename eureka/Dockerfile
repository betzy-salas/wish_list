FROM openjdk:16-alpine3.13
ADD ./target/eureka-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]