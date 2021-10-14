# Repositorio ejercicio  [n numeros primos](https://github.com/hisanchezsanchez/n-numeros-primos)

#Exchange Currency
## Run Code in local

## From [docker hub](https://hub.docker.com/repository/docker/srhit/exchange-currency)

````shell
docker container run --rm -it -p 80:8080 srhit/exchange-currency:1.1
````

### calculate change with curl (or import to postman)

````shell
curl --location --request POST 'http://localhost/exchange/v1/calculate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "amount": 10,
  "originCurrency": "USD",
  "destinationCurrency": "PEN"
}'
````

### upload massive update or create change types

````shell
curl --request POST 'http://localhost/currency/v1/update' \
--header 'Content-Type: application/json' \
--data-raw '[
  {"code": "USD","amount": 4.21},
  {"code": "XCD","amount": 3.25},
  {"code": "ARS","amount": 5.61},
  {"code": "YEN","amount": 9.48},
  {"code": "BSD","amount": 10.5},
  {"code": "BBD","amount": 11.5},
  {"code": "INR","amount": 12.5},
  {"code": "BRL","amount": 11.5},
  {"code": "KYD","amount": 1.5},
  {"code": "CLP","amount": 0.5},
  {"code": "COU","amount": 4.21},
  {"code": "KMF","amount": 1.5},
  {"code": "CDF","amount": 6.5},
  {"code": "CRC","amount": 3.5},
  {"code": "XOF","amount": 1.5},
  {"code": "HRK","amount": 7.5},
  {"code": "INR","amount": 4.5},
  {"code": "CUP","amount": 2.5},
  {"code": "CUC","amount": 1.5},
  {"code": "CZK","amount": 11.5},
  {"code": "DJF","amount": 15.5}
]'
````

## from local

### Requirements

Java 11 Maven

### Compilation

````shell
mvn clean package
````

### Run java jar

````shell
java -jar target/exchange-currency-0.2.jar
````

ejecuta los curl

# Docker build file

````shell
mvn clean package ; docker image build -t srhit/exchange-currency:1.1  .
````

# Run in docker container with interactive console



