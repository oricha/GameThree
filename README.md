##Three
Three is a simple game that communicates through REST API. A player chooses a random number and adds + 1 / -1 / 0 and sent it to another and the first to reach 1 wins.

How to build/run proyect
with maven 
* Game/mvn clean package
* Game/mvn spring-boot:run  or java -jar target/game-0.1.0.jar same for the project java -jar target/player-0.1.0.jar
* run http://localhost:8080/start

with Gradle
* ./gradlew build
* java -jar build/libs/game-0.1.0.jar same for the project java -jar target/player-0.1.0.jar
* less verbose mvn spring-boot:run
* http://localhost:9000/


GameTree run on 8080 port and Player run on 9000. You can change the port in application.properties file
You can choose Aumtomatic sum in homePage to don't put -1,0,1 and program select the entry to add
