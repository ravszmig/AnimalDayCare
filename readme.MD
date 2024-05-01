# STILL UNDER DEVELOPMENT

# Animal Daycare

This app is developed using a variety of programming techniques and methodologies.

The goal is to create a WebApp to help people find pet sitters in their area.


## Technologies:

Java 21,
Hibernate, 
PostreSQL,
Angular

## How to use

Start docker

`/docker/docker-compose.yml`

simply by using

`docker-compose up`

Example curl for adding and fetching animals:

`curl --request PUT \
--url http://localhost:8080/api/v1/animals/new \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/9.0.0' \
--cookie JSESSIONID=FCECA1E013C7DCBCCF293EA921CFA370 \
--data '{
"age": 3,
"name": "Buddy",
"size": "MEDIUM",
"type": "DOG",
"animalType": "DOG",
"dogBreed": "GERMAN_SHEPHERD",
"specialNeeds": "Needs regular medication for arthritis"
}'`

`curl --request GET \
--url http://localhost:8080/api/v1/animals/get/1 \
--header 'User-Agent: insomnia/9.0.0' \
--cookie JSESSIONID=FCECA1E013C7DCBCCF293EA921CFA370`