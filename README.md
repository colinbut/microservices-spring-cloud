# Microservices Spring Cloud/Netflix OSS

This is another of my microservices example demo project. This is quite similar to my other microservice example project: https://github.com/colinbut/microservices-online-webshop. 

But the difference with this one is that this one uses Spring Cloud entirely to build the microservices along with of course the Netflix OSS projects. Whereas, the other example showcases a generic Microservices example system application where each 'micro' service is built differently - Polygot.

This sample project specifically demonstrates the following features using the Spring Cloud ecosystem.

- Service Registry
- Centralized Configuration
- (Client Side) Load Balancing
- Circuit Breaker pattern


Spring Cloud / Netflix OSS 

| Service/Feature             | Spring Cloud Component         | Netflix Component |
| --------------------------- | :----------------------------: | ----------------- |
| Service Discovery           | Spring Cloud Eureka            | Eureka            |
| Load Balancing              | Spring Cloud Ribbon            | Ribbon            |
| Circuit Breaker             | Spring Cloud Hystrix           | Hystrix           |
| Centralized Configuration   | Spring Cloud Config Server     | [NONE]            |

### Running Locally

1. Start up Config Server
2. Start the Service Registry
3. Start up both web-service & accounts-service

#### Notes
Config Server must be started first as its a centralized configuration server where other microservices (incl. the
Service Registry) reads its configuration from.

Service Registry need to be started next as the functional microservices need to register to the Service Registry as 'Clients'.
The Service Registry would be the 'Server'.

Both web-service and accounts-service have been configured to run on a random port assigned during Spring start up.

### Config Server

```bash
config-server/mvnw spring-boot:run
```

### Service Registry

```bash
service-registry/mvnw spring-boot:run
```

### Web Service

```bash
web-service/mvnw spring-boot:run
```

### Accounts Service

```bash
accounts-service/mvnw spring-boot:run
```

 
