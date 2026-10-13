# Inventory App - EAD DevOps Lab Starter

A small Spring Boot inventory web application designed for the **DevOps Fundamentals with GitHub Actions and Docker** practical.

## Included
- Product inventory REST API with CRUD operations
- Simple browser-based inventory interface
- In-memory H2 database with sample products
- JUnit 5 and MockMvc tests
- GitHub Actions build, test, and Docker image workflow
- Dockerfile using Java 17

## Requirements
- Java JDK 17+
- Apache Maven
- Docker Desktop
- Git and a GitHub account

## Build and test
```bash
mvn clean install
mvn test
```

## Run locally
```bash
mvn spring-boot:run
```
Open `http://localhost:8080`.

## Build and run with Docker
```bash
mvn clean package
docker build -t inventory-app .
docker run --rm -p 8081:8080 inventory-app
```
Open `http://localhost:8081`.

## API
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

Example request body:
```json
{"name":"Monitor","category":"Electronics","quantity":15,"price":325.00}
```

## Demonstrating a CI failure
Open `ProductServiceTest.java` and change:
```java
assertEquals(250.0, service.calculateStockValue(...));
```
to an incorrect expected value such as `100.0`. Commit and push to observe a failed workflow. Restore `250.0`, commit, and push again to demonstrate recovery.

## Suggested repository name
`EAD-DevOps-Lab-inventory-app`
