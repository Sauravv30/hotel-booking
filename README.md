
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

- Hotel Service
  - This 
    

- Hotel booking microservice helps for room booking from specific hotel.
- http://localhost:8082/swagger-ui/index.html#/ this url will help you get the full information about the apis and model.
- If the room is already booked it will throw error and inform user that room is already booked and you can not book the hotel this time.
- You can get all the rooms booked from userid
- You can cancel the booking
- You can upate the booking
