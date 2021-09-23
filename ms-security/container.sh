echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop security-service
docker rm security-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/security-service-imgv120 .
docker push betzysalasvergara/security-service-imgv120
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8084:8084 --name security-service --network networkapi -d betzysalasvergara/security-service-imgv120
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  