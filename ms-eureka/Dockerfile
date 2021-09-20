FROM openjdk:16-alpine3.13
EXPOSE 8761
ADD ./target/ms-eureka-0.0.1-SNAPSHOT.jar micro-service-eureka.jar
ENTRYPOINT ["java","-jar","/micro-service-eureka.jar"]