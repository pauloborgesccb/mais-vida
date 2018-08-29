# Mais Vida

## Backend
### Spring Boot 2.0.4
- [SPRING INITIALIZR](https://start.spring.io/)

### build
```$ npm install```

### run
```$ npm install```

## Frontend (ANGULAR 6)
### requerimentos mínimos
 - [NodeJS 8.9+](https://nodejs.org/en/) [* Recomendado utilizar nvm](https://github.com/creationix/nvm)

### Libs utilizadas
 - [Angular 6](https://angular.io/)
 - [Material designer](https://getmdl.io/)
  
### Instalar pacotes
 
```$ npm install```

### Iniciar server

```$ ng serve --open ## ou $ npm run start```


## Banco de dados MySQL 8
### requerimentos mínimos
 - [MySQL Workbench *Para vizulizar/editar modelo](https://dev.mysql.com/downloads/workbench/)
 - [MER (.mwb e .png) /Scripts (.sql)](/mer)
 - [Docker](https://docs.docker.com/docker-for-windows/install/)

### Docker mysql iniciar container

```$ docker run -p 3306:3306 --name mysqlserver -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest```


#### Executar scripts
```$ docker exec -it mysqlserver bash```

```$ mysql -u root -p # informar senha no prompt e colar conteúdo do script na sequencia```