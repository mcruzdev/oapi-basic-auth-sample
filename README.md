# Open API Generator Basic Auth Sample

The api-gateway uses the Open API Generator extension for requesting the users-api (using basic authentication).

You can see the Open API file here:

https://github.com/mcruzdev/oapi-basic-auth-sample/blob/main/api-gateway/src/main/openapi/users.yaml

The **api-gateway** [application.properties](https://github.com/mcruzdev/oapi-basic-auth-sample/blob/main/api-gateway/src/main/resources/application.properties) file:

```properties
quarkus.rest-client.users_yaml.url=http://localhost:8888

quarkus.openapi-generator.users_yaml.auth.BasicAuth.username=${BASIC_AUTH_USER}
quarkus.openapi-generator.users_yaml.auth.BasicAuth.password=${BASIC_AUTH_PASS}
```

## Building and running the api-gateway (to see the use of environment variables)
```shell
cd api-gateway
quarkus build
export BASIC_AUTH_USER=hello
export BASIC_AUTH_PASS=hello@@
java -jar target/quarkus-app/quarkus-run.jar
```

Ok, the **api-gateway** is running!!!

## Running the users-api

```shell
cd users-api
quarkus dev
```

## Testing

1. Execute the following cURL:

```shell
curl --location 'http://localhost:8080/info'
```

2. See the **users-api** logs, should be something like this:

```shell
Accept: [application/json]
host: [localhost:8888]
Authorization: [Basic aGVsbG86aGVsbG9AQA==]
User-Agent: [Quarkus REST Client]
```
