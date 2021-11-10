Introduction

Animal Service REST APIs exposes REST endpoints to perform add new animal, get list of animals and delete operations on animal entity. The objective of this documentation is to make sure user can quickly understand the purpose of API endpoint and implement it faster. This API documentation covers details of all the components needed by end user to consume any of the APIs.

Animal Service REST APIs Details

This section provides details for all animal-service REST end-points:

https://localhost:8080/animal-service/animals HTTP Method: POST Description: creates a new animal entity

 Sample POST body: 
 {
   "name" : "name",
   "animalType" : "Fish",
   "moveType" : "Swim"
 }
 
https://localhost:8080/animal-service/animals

HTTP Method: GET
Description: retrieves list of all the animals

https://localhost:8080/animal-service/animals/{animalName}

HTTP Method: Delete Description: Deletes animal with given name
