echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop user-service
docker rm user-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/user-service-imagv1:latest .
docker push betzysalasvergara/user-service-imagv1:latest
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8082:8082 --name user-service --network networkapi -d betzysalasvergara/user-service-imagv1:latest
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  