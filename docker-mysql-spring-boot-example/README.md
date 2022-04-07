
# Docker MySQL Spring Boot Example

This example demostrates a spring boot application connecting to a MySQL database deployed in separate docker containers deployed using docker compose.

































## API Reference

#### Get all vote details

```
  GET /api/v1/getAllVoteDetails
```
##### Sample Response

```
[
    {
        "voterId": 1001,
        "age": 30,
        "name": "sam",
        "address": "Kolkata",
        "partyCode": "INC"
    },
    {
        "voterId": 1005,
        "age": 30,
        "name": "sam",
        "address": "Kolkata",
        "partyCode": "INC"
    }
]
```


### Submit Vote

```
  POST /api/v1/submitVote
```
##### Sample Payload

```

{
    "voterId": 1001,
    "name": "sam",
    "age": 30,
    "address": "Kolkata",
    "partyCode": "INC"
}

```

##### Sample Response

```
{
    "voterId": 1001,
    "age": 30,
    "name": "sam",
    "address": "Kolkata",
    "partyCode": "INC"
}
```
## Deployment

To deploy this project follow the below steps.

### Step 1: Run Maven clean package

```
cd docker-mysql-spring-boot-example
mvn clean package
```

### Step 2: Create Docker Image for the Spring Boot Application

```
docker build -t sumitdas28/docker-mysql-spring-boot-example .
```

### Step 3: Run the application using Docker Compose

```
docker-compose up 
```

#### To run the containers in background use detached mode option

```
docker-compose up -d 
```