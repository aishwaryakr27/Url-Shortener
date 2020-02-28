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

# Approach:
1. Used division and modulo operation to convert a url which can have 62 characters - [A-Z, a-z, 0-9].
2. Created database table using both H2 DB and MySql which will have a unique key generator for each row. This Id is used for encoding using logic #1.
3. Table has 3 cloumns - Id, Original url and shorterned Url.
4. Used Spring Boot to create Rest APIs.
5. In the service layer, the program accepts original url and then shortens the url and vice-versa. For this a short key is generated using Id from DB.
