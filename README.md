# Rest API with Kafka Spring Boot

## Database MySQL User Root
- Username: root
- Password: root

*src/main/resources/aplications.properties*

# Docker MySQL Image

`docker-compose up`

*docker-compose.yml*

## Querys MySQL

`CREATE TABLE car(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    color VARCHAR(100) NOT NULL,
    PRIMARY KEY ( id ));`

Show columns and values of database created:

`SELECT car.id,
    car.name,
    car.color,
FROM cars.car;`

## Requests

http://localhost:8080/ - URL Tomcat server

/cars/list - Return list of all cars - GET 

/cars/ - Add a car - POST

## Swagger UI

http://localhost:8080/swagger-ui.html - URL to acess Swagger UI in the browser.

