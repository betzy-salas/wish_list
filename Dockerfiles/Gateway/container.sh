echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean install
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop gateway-service
docker rm gateway-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/gateway-service-imgv4 .
docker push betzysalasvergara/gateway-service-imgv7
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8080:8080 --name gateway-service --network networkapi -d betzysalasvergara/gateway-service-imgv4
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  