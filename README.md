# spring-boot-rest-example
A simple example of a spring-boot Rest application

##Versions
* linux Ubuntu 14.04 LTS
* curl 7.35.0
* java 1.8.0_181
* maven 3.3.9
* spring-boot 2.1.3.RELEASE

### How to test
mvn clean spring-boot:run (on the app directory)

#### To list all (GET method)
curl localhost:8080/employees

#### To list one (GET method)
curl localhost:8080/employees/1

#### To record an employee (POST method)
curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name":"Smith","role":"user"}'

#### To change one (PUT method)
curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name":"Trinity","role":"admin"}'

#### To delete one (DELETE method)
curl -X DELETE localhost:8080/employees/4

