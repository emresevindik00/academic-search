# Academic Seearch Project

This is a sample Java / Maven / Spring Boot application that can be used as a starter for creating a academic publications, researchers, publication types etc.

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 
* Make sure you are using JDK 11 and Maven
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by this method in cmd:

How to run project

```
go target file directory
open cmd
java -jar academic-search-0.0.1-SNAPSHOT.jar
```

Once the application runs you should see something like this

```
2022-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2022-08-29 17:31:23.097  INFO 19387 --- [           main] com.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

Here are some endpoints you can call:

### Get information about system publication, configurations, etc.

```
http://localhost:8091/api/publications
http://localhost:8091/api/researcher
http://localhost:8091/api/types
http://localhost:8091/api/login
```

### Create a publication resource

```
POST /api/publications
Accept: application/json
Content-Type: application/json

{
"id" : 1,
"name" : "Emre",
"year" : "2022",
"rating" : 2
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/api/publications
```

### Update a publications resource


### To view Swagger 2 API docs

Run the server and browse to localhost:8080/swagger-ui.html

Here is what you would do to back the services with Neo4j: 

### In pom.xml add: 

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-neo4j</artifactId>
        </dependency>
```

### Append this to the end of docker-compose.yml: 

```
---
version: "3"
services:
  neo4j:
    container_name: Neo4j-test
    image: neo4j:4.0
    volumes:
      - ./data:/data
      - ./plugins:/plugins
      - ./import:/import
    ports:
      - "7474:7474"
      - "7687:7687"
    environment:
      - NEO4J_apoc_export_file_enabled=true
      - NEO4J_apoc_import_file_enabled=true
      - NEO4J_dbms_security_procedures_unrestricted=apoc.*,algo.*
      - NEO4J_dbms_memory_heap_initial__size=512m
      - NEO4J_dbms_memory_heap_max__size=2G
      - NEO4J_apoc_uuid_enabled=true
      - NEO4J_dbms_default__listen__address=0.0.0.0
      - NEO4J_dbms_allow__upgrade=true
      - NEO4J_dbms_default__database=neo4j
      - NEO4J_AUTH=neo4j/test
    networks: ["Neo4j-test"]
    restart: unless-stopped
networks: { Neo4j-test: {} }
# use docker volume to persist data outside of a container.
volumes:
  Neo4j-test:
  
```
