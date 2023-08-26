# REST API for Joke with Spring Boot


### Requirements

- Used Java - JDK 17
- Used "IntelliJ IDE 2022.2.3 for Enterprise Java Developers"
- Used Maven 3.8.6

### Installing Java

- Windows - https://www.azul.com/downloads/?package=jdk

### Installing IntelliJ

- Windows - https://www.jetbrains.com/idea/promo/

## Description:
The Joke API Backend allows performing following operation. 
- Retrieve a short random joke.



## Steps to run the application
- Unzip the project
- Option 1: Using Java command.
  - open command prompt(cmd) or terminal on Mac
  - navigate to the project folder
  - run command `mvn clean install`
  - once its successfully build navigate to target folder
  - run command `java -jar .\JokeApi-1.0.0-SNAPSHOT.jar`

- Option 2: Docker way of running (Docker installation is needed)
  - Open terminal and run `docker-build-run.sh`

Now application is up and running on http://localhost:8080

## How to use this service
- Open the URL in your browser : http://localhost:8080/api-docs
- User will see a swagger page with all the defined specs of the service.
- There will have 1 Tags you can see.
- Alternately, you can directly use http://localhost:8080/jokes/ in browser.


### 1. Joke-controller
#### Description:
- One endpoint to get a random joke
- Endpoint 1: `GET /jokes/`
  - Gets a short random joke which is safe to be displayed.
