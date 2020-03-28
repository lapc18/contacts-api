# Spring Boot API for Contacts

## Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.M3/maven-plugin/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.0.M3/maven-plugin/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-mongodb)

## Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

## Endpoints on Heroku
The following endpoints are working on heroku, you can consume it with your own app or Postman:

#### Base link

- [Base endpoint: https://devlegnd-contacts-api.herokuapp.com](https://devlegnd-contacts-api.herokuapp.com)


#### Endpoints

- /api/auth/register => [POST]
    - send request body: {"name": "your name", "lastName": "your lastName", "email": "your@email.com", "pwd": "your strong password", "profile": "base64 img"} 
- /api/auth/login => [POST]
    - send request body: {"email": "your@email.com", "pwd": "your strong password"}
- /api/contacts/{email} => [GET]
- /api/contacts/{email} => [POST]
    - send request body: {"profile": "your base64 image", "firstName":"your firstName", "lastName":"your lastName", "nickName":"your nickName", "email":"your@email.com", "phoneNumber": "1234567890", "website":"your.website", "relationship":"your relationship", "notes": "write some notes here..."}
- /api/contacts/{email} => [PUT]
    - send request body: {"profile": "your base64 image", "firstName":"your firstName", "lastName":"your lastName", "nickName":"your nickName", "email":"your@email.com", "phoneNumber": "1234567890", "website":"your.website", "relationship":"your relationship", "notes": "write some notes here..."}
- /api/contacts/delete/{id} => [DELETE]
