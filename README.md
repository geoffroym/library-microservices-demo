# Library Microservices (Practice Project)

This is a simple practice project I built while learning microservices with Spring Boot.
I’ll be improving it step by step as I learn more (e.g., databases, Docker, testing, security).
It’s not meant to be a production-ready project. It’s intentionally simple and designed for me to practice microservices concepts.

## Learning Roadmap

 Introduction
 - [x] SpringBoot services
 - [x] Domain and Scaling
 - [x] Synchronous communication between two SpringBoot services
 - [x] Asynchronous communication between modules
 - [ ] Containerization – Docker
 - [ ] Gateway – Access to the system
 - [ ] Centralized configuration
 - [ ] More Docker – Docker Compose
 - [ ] Software Quality – testing and Cucumber
 - [ ] Spring Security
 - [ ] Orchestration & Deployment

## Services

### Book Service:
- Manage books (CRUD)
- Keep track of stock quantities
- Exposes an endpoint to decrease stock when an order is placed

### Order Service:
- Place and list orders
- Talks to the Book Service to check and update stock before saving an order

## Tech Stack

- Java + Spring Boot
- React, Vite 
- REST (with RestTemplate)
- Postman (for testing)
- RabbitMQ
- Docker
