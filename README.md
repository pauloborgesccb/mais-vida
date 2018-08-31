# Mais Vida

## Backend Spring Boot 2.0.4
### Requerimentos mínimos
 - Java 8
 
### Ambiente utilizado
```
java version "1.8.0_172"
Java(TM) SE Runtime Environment (build 1.8.0_172-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.172-b11, mixed mode)
```


### Utilizado SPRING INITIALIZR
- [SPRING INITIALIZR](https://start.spring.io/)

### Build
```$ mvn package #A partir da pasta 'backend'```

### Run
```$ java -jar ./target/maisvida-0.0.1-SNAPSHOT.jar #A partir da pasta 'backend'```

### Swagger
 - Para acessar o swagger (*caso não seja alterado application.properties) [http://localhost:8090/swagger-ui.html](http://localhost:8090/swagger-ui.html)

## Frontend (Angular 6)
### Requerimentos mínimos
 - [NodeJS 8.9+](https://nodejs.org/en/) [* Recomendado utilizar nvm](https://github.com/creationix/nvm)

### Ambiente utilizado

```
node v8.11.2 (npm v5.6.0)
```

### Libs utilizadas
 - [Angular 6](https://angular.io/)
 - [Angular Material](https://material.angular.io/)
  
### Instalar pacotes
 
```$ npm install #A partir da pasta 'frontend'```

### Iniciar server

```$ ng serve --open ## ou $ npm run start #A partir da pasta 'frontend'```


## Banco de dados MySQL 8
### Requerimentos mínimos
 - [MySQL Workbench *Para vizulizar/editar modelo](https://dev.mysql.com/downloads/workbench/)
 - [MER (.mwb e .png) /Scripts (.sql)](/mer)
 - [Docker](https://docs.docker.com/docker-for-windows/install/)

### Docker mysql iniciar container

```$ docker run -p 3306:3306 --name mysqlserver -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest```


#### Executar scripts
```$ docker exec -it mysqlserver bash```

```$ mysql -u root -p # informar senha no prompt e colar conteúdo do script na sequencia```