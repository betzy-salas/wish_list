echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean install
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop wish-service
docker rm wish-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/wish-service-imagev1:latest .
docker push betzysalasvergara/wish-service-imagev1:latest
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8083:8083 --name wish-service --network networkapi -d betzysalasvergara/wish-service-imagev1:latest
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  