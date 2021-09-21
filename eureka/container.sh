echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop eureka-service
docker rm eureka-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/eureka-service-imgv1 .
docker push betzysalasvergara/eureka-service-imgv1
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8761:8761 --name eureka-server --network networkapi -d betzysalasvergara/eureka-service-imgv1
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  