./mvnw clean install -DskipTests

docker-compose stop
docker-compose down

docker-compose pull
docker-compose up
