# REST API example application

This is a Reward Calculator application providing a REST
API to a backed model.



## Install

    maven install

## Run the app

    run as spring boot 

## Run the tests

    mvn test

# REST API

The REST API to the example app is described below.

## Get list of Things

### Request

`GET /rewards/customerName`

    curl -i -H 'Accept: application/json' http://localhost:8080/rewards/

### Response

    HTTP/1.1 200 OK
    Date: Tue, 20 Jun 2023 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2

    


### Request

`POST /rewards/

    curl -i -H 'Accept: application/json' -d  http://localhost:8080/rewards
###Request
  {
  "customerName":"Bob",
  "amount":"150",
  "date":"2019-09-12"  


 }
### Response

    HTTP/1.1 201 Created
    Date: Tue, 20 Jun 2023 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36
    Connection: close