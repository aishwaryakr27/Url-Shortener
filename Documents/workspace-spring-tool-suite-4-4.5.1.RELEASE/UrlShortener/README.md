# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/maven-plugin/)



## Technical Stack for Implementation: Java, Spring Boot, Rest API, MySql and H2 Databases.


# URL Shortening:

## Prerequisites:
Need to have Maven installed and 'mvn' command available in your path.

## Starting the Project:
To run this project, need to run below command:

mvn spring-boot:run

## Sample request and response: Shorten Url and Redirect back
From Postman or anyother Rest client, invoke below API.

API: 'localhost:8080/api/v1/urlshortener'
HTTP POST

Request sample:

{
"originalUrl": "https://www.southwest.com/"
}

Response Sample:


success response:

{
"shortLink": ""http://localhost:8080/tiny/c"
}

