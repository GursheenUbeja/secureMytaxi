# secureMytaxi
Security Implemented with JWT, to be used with Postman


As mentioned in the task assigned, Task 4 was voluntarily: 

This task is voluntarily, if you can't get enough of hacking tech challenges, implement security. Secure the API so that authentication is needed to access it. The details are up to you.
Please include instructions how to authenticate/login, so that we can test the endpoints you implemented!


This project solely is dealing with security in our application. The security mechanism used is JWT token generation.
Basically I have secured all the endpoints with an authentication token. We have two URLs, the first one gets token data from the service
And the token should be appended to every request send after thereafter. Without token, we cant access other URLs.


Like for an example:

Step 1 : 
Link : http://localhost:8080/login
Input : {"username":"test","password":"test123"}
Output : authorization →Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTM2NDMxMzI2fQ.5DhqP7sccBMYZhhbI4h2EES87ovVCkhWr9N2jS3QSTzo2d-_4TkMKFWGmQ1gPHGPN0sb2c60cFHkh0q3ICxiRA
Note : The data is currently setup in code, Can be fetched from repository (enhancement).


Step 2 : 
Link : http://localhost:8080/v1/drivers/1 (any other URL too).
Input : {""}
Authentication : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTM2NDMxMzI2fQ.5DhqP7sccBMYZhhbI4h2EES87ovVCkhWr9N2jS3QSTzo2d-_4TkMKFWGmQ1gPHGPN0sb2c60cFHkh0q3ICxiRA
Output : {
    "id": 1,
    "username": "driver01",
    "password": "driver01pw"
}

Note : For some endpoints, we do need JSON Structure to pass as input with auth token.

Right now, user data is generating token data, we can have drivers data to authenticate and generate tokens too.
