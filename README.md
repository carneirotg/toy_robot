# Overview

A RESTful application that creates and move a single robot at a 5x5 table.

# Requirements
  * Java >= 1.7
  * SpringBoot 2.0.2
  * Maven
  * Docker
  * Mongodb
  * docker-compose

# Usage
  * One can choose wether to install mongodb in your system (https://docs.mongodb.com/manual/installation/) or run the docker-compose to generate the Docker for the SpringBoot Application and the MongoDB Server.
  * Run `docker-compose up -d`
  The application will be available at `http://localhost:8080`
  
# Configuration
  * If one don't want to run the docker-compose, then you should run the `mongod` service that will listen to de default port `27017` and then run `java -jar target/toy-robot-1.0.jar`

# Testing
 * Inside src/test/resources, there is a file `Robot.postman_collection.json` that can be imported to Postman with some calls.
