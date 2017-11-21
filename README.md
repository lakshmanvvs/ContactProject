# ContactProject

# Steps to Run 
##pre-requisites
Docker for Windows/Mac,
Java 8

From the project directory

```docker build -f Dockerfile -t contact-mgr:latest .```

```docker-compose -f contactmgr-compose.yml up -d```

The above commands will build the docker image containing the executable jar and 
the docker compose file will bring up elasticsearch container and contact manager container.

##Swagger UI
```http://localhost:9199/swagger-ui.html```