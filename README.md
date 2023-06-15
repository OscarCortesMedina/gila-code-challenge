# Gila challenge

Oscar Cortes code challenge.

## Installation requirements

- Java 17
- Maven

## Usage API

### Send Notification

```
curl --location --request POST 'http://localhost:8080/api/messages/sendNotification?category=FILMS&message=test' 
```
### Notifications logs

```
curl --location --request GET 'http://localhost:8080/api/messages/logs' 
```
