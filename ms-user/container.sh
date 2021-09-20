echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop micro-service-user
docker rm micro-service-user
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/micro-service-user-image:latest .
docker push betzysalasvergara/micro-service-user-image:latest
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8080:8080 --name micro-service-user --network wish_list -d betzysalasvergara/micro-service-user-image:latest
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  