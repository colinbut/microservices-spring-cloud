# Config Service

This micro service represents a Centralized Configuration Server serving configuration property files to other
micro services. This is the Config Server.

It by default connects to the github repo: https://github.com/colinbut/microservices-spring-cloud-netflix-oss-config-files

which contains a list of all configuration property files for each micro service of the project.

However, you can wire up other different backends for the storage of the configuration property files. You have multiple choices.
Not limited to local file system, Hashicorp's Consul, a Database etc...

### Refresh the microservice after config updates

```bash
$ curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"
```

 
