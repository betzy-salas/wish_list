echo ------------------------------------------------------------------------------------------
echo GENERATE JAR
echo ------------------------------------------------------------------------------------------
mvn clean install
mvn clean package -DskipTests
echo ------------------------------------------------------------------------------------------
echo BUILD AND PUSH Docker
docker stop books-service
docker rm books-service
echo ------------------------------------------------------------------------------------------
docker build -t betzysalasvergara/books-service-imgv1 .
docker push betzysalasvergara/books-service-imgv1
echo ------------------------------------------------------------------------------------------
echo Run Image
docker run -p 8081:8081 --name books-service --network networkapi -d betzysalasvergara/books-service-imgv1
echo ------------------------------------------------------------------------------------------
echo End Process
echo ------------------------------------------------------------------------------------------  