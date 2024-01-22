# HOTEL BOOKING
The overall idea about the hotel booking app is.
- We have multiple microservice those are working to achieve the booking because we ave to handle mulitple millions of request in hour. We can create multiple bookings at the same time.
- While creating booking you can provide multiple entries at the same time for same user.
- We have microservices architecture to for better scalability, resilience and maintainability. 
  
  -About micoservice those are working parallely.
How does it works ?
- Gateway microservice
  - This microservice will interact with user with this url user can only interact this complete booking process.
  - http://localhost:7000/ this url will be public url and other microservice are non interactive on internet.
  - When user want to do booking, first he will have to authenticate himself providing basic information username, password and email http://localhost:8081/swagger-ui/index.html
  - Once you will successfully register then you will get two tokens- auth token and refresh token.
  - This auth token you have to use in headers putting. Note- DO NOT PUT BEARER
      Authorizaion <token>
  - Othewise you will get 401 Unauthorization access.
  - Once you have succssfully provided token then you can do booking and all operation.
  - You need not to regiser everytime. Put you credentials and you again will get token.

- User Service http://localhost:8081/swagger-ui/index.html
  - In this service we can maitain all the users, roles and authentications.
  - We can add user, delete user and update user.    
  - User information wil be stored in User Database.

- Hotel Service http://localhost:8082/swagger-ui/index.html
  - This service will take care about the hotel and room informations
  - You can get the hotel with rooms inside it.
  - We cn have multiple rooms in hotel.
  - We can update the room status.
  - We can update the room informtaion.

- Booking Service http://localhost:8083/swagger-ui/index.html
  - This service will take care about the rooms booking.
  - For same user we can book multiple rooms at a same time.
  - We can cancel the bookking by giving booking id.
  - We can get all the booking of specific user.
  - We can get specific booking details - check-in/check-out and booking date.
 
# Installation Steps:
  - All microservices except gateway the controller and models are creating from <swagger>.yml file in resources
  - mvn clean install must run to build the controllers

# Short Falls
- This app is syncronized block the booking process everytime - We can make it reactive
- No live information - Actuator can we used
- No docker files and deployment process - We can create docker file and user kuberneter
- App gateway - no authorization and not robust- AWS Application load balancer can be used
- No logs - Customized can we added logstash, kibana can we used.
- No authorization at intranet microservice level - Due to deployment process is not there but we can add firewall rules
- Basic JWT authentication is used - OAuth or Active directory can be used.
- Resilience is not used - Spring boot resilience4j can be used.
- No Junits and code level better docs
    
