# RestService
**Special for NapoleonIT**

# Development
- Intellij IDEA (2016.3.3) 
- JDK 1.8.0_151
- Jersey 2.2
- Tomcat 8.5.28
# For deployment
 You must install Tomcat ([guide](https://www.digitalocean.com/community/tutorials/how-to-install-apache-tomcat-8-on-ubuntu-16-04)) on your linux machine. Then deploy the `.war` file from `MyRestProject/target/` on your Tomcat server.
# Requests
 My application location on my Tomcat server is `http://localhost:8080/MyRestProject`. So I'll use this path for requests.
### GET `http://localhost:8080/MyRestProject`
Request:
```
(empty)
```
Response:
```
[
    {
        "id": "58eca2d4-15c4-459b-8ff8-19eff5bba7a7",
        "title": "title2",
        "text": "just text",
        "date_create": 1519813580,
        "date_update": 1519813580
    },
    {
        "id": "61e448d2-4c62-4e41-9c41-be1d67e95ac0",
        "title": "title1",
        "text": "just text",
        "date_create": 1519813562,
        "date_update": 1519813562
    }
]
```
### POST `http://localhost:8080/MyRestProject`
Request:
```
{
    "title": "title2",
    "text": "just text",
}
```
Response:
```
{
    "id": "58eca2d4-15c4-459b-8ff8-19eff5bba7a7",
    "title": "title2",
    "text": "just text",
    "date_create": 1519813580,
    "date_update": 1519813580
}
```
### PUT (UPDATE) `http://localhost:8080/MyRestProject`
Request:
```
{
    "id": "58eca2d4-15c4-459b-8ff8-19eff5bba7a7",
    "title": "new title2",
    "text": "new text",
}
```
Response:
```
{
    "result": false,
    "message": "Note does not exist"
}
```
### DELETE `http://localhost:8080/MyRestProject`
Request:
```
{
    "id": "58eca2d4-15c4-459b-8ff8-19eff5bba7a7",
}
```
Response:
```
{
    "result": true,
    "message": "Done"
}
```
