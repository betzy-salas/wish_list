echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean install
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop micro-wish-list
docker rm micro-wish-list
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/micro-wish-list-image:latest .
docker push betzysalasvergara/micro-wish-list-image:latest
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8081:8081 --name micro-wish-list --network wish_list -d betzysalasvergara/micro-wish-list-image:latest
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  