How to build/run proyect
with maven 
* mvn clean package
* mvn spring-boot:run  or java -jar target/gamethree-0.1.0.jar same for the project java -jar target/player-0.1.0.jar
* run http://localhost:8080/start

with Gradle
* ./gradlew build
* java -jar build/libs/gamethree-0.1.0.jar same for the project java -jar target/player-0.1.0.jar
* less verbose mvn spring-boot:run
* http://localhost:9000/


GameTree run on 8080 port and Player run on 9000. You can change the port in application.properties file
You can choose Aumtomatic sum in homePage to don't put -1,0,1 and program select the entry to add