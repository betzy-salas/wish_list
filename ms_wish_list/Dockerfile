FROM openjdk:16-alpine3.13
EXPOSE 8081
ADD ./target/ms_wish_list-0.0.1-SNAPSHOT.jar micro-wish-list.jar
ENTRYPOINT ["java","-jar","/micro-wish-list.jar"]