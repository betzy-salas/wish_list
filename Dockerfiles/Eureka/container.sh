echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop micro-service-eureka
docker rm micro-service-eureka
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/micro-service-eureka-image:latest .
docker push betzysalasvergara/micro-service-eureka-image:latest
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8761:8761 --name micro-service-eureka --network wish_list -d betzysalasvergara/micro-service-eureka-image:latest
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  