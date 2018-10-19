# Web Service

This micro service represents a Edge Service which calls the Account Service to get an Account by a given account number.

## Load Balancer - Ribbon

This micro service contains a client side load balancer in Netflix's Ribbon.

Since this micro service communicates to Accounts Service you can spin up multiple instances of Accounts Service and
the Web Service will load balance requests across these instances.

## Circuit Breaker - Hystrix

This service contains an implementation of the Circuit Breaker pattern using Hystrix.

#### Hystrix Dashboard

The Hystrix Dashboard is also set up. You can visit the dashboard here:

```
http://{web-service-url}:port/hystrix
```

And you can view the hystrix stream data here:

```
http://{web-service-url}:port/actuator/hystrix.stream
```

which you can then feed the stream into the dashboard for visualization using the UI.

`hystrix.stream` does a `ping` and pulls data from the health checks metrics provided by Spring Boot's Actuator
 
