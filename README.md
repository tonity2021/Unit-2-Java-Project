# Online-Travel-Booking-App
## Project Concept:

![passport-2714675_640](https://user-images.githubusercontent.com/94870846/152490274-15546bcf-cf8a-454a-b6e1-373370af1cbe.jpg)

This app represents a real-life online travel booking system which allows a user to make travel reservations and a user profile through a set of endpoints and HTTP requests. Prior to making the reservation, a user is able to register with their username, email, and password.  After they have registered, they can subsequently sign in and a JWT (JSON web token) is returned as a way of authorizing and protecting the client server session. After signing in, a user can create a reservation, modify their reservation and ultimately cancel it if necessary.  In addition, a user can create a user profile with their name and contact information.  User information is stored in a PostgreSQL database and facilitated by PGAdmin.  

Ultimately I was able to achieve this project through a variety of outside tools: using Word document to track my goals and progress, creating an ERD, and making multiple commits via Git Bash to keep track of recent changes to my project.

## Entity Relationship Diagram (ERD)

![image](https://user-images.githubusercontent.com/94870846/152574124-8ccd1ed7-8bce-4d94-b8fc-bee60b4a3d36.png)

## IDE IntelliJ Configuration (Spring Boot Dev Tools)

![image](https://user-images.githubusercontent.com/94870846/152491284-2918e2e0-33c6-4dc7-bdae-f33edebd4e5c.png)

## POM Dependencies

![image](https://user-images.githubusercontent.com/94870846/152493122-c6563368-462a-4bfa-aff1-8517cff00ab5.png)![image](https://user-images.githubusercontent.com/94870846/152492518-c14b4795-4e6c-427c-9920-a14c270468e5.png)

## Endpoints

![image](https://user-images.githubusercontent.com/94870846/152493185-f16ea30b-9139-4959-aad6-c937600c4a42.png)

## Technologies and Tools Used

![image](https://user-images.githubusercontent.com/94870846/152493640-cd82f4c2-7a41-4007-9799-7237cdcf60cb.png)
IntelliJ~
Java~
Spring Boot~
PostGreSQL~
Postman~
GitBash~

## User Stories

![image](https://user-images.githubusercontent.com/94870846/152494729-699a44be-502e-4648-88b4-107e2e80002e.png)

•	As a user I can create a new travel reservation so I can travel. <br />
•	As a user I can be ensured my booking session will be secure so that I can feel safe using my personal details.  <br />
•	As a user I can search for my reservation by booking Id to ensure I’m referencing the correct flight.  <br />
•	As a user I can view my reservations so I can see the details of my flight.  <br />
•	As a user I can update/modify my reservation if I change my mind about some of my travel plans.  <br />
•	As a user I can cancel my reservation in case of an emergency situation.  <br />
•	As a user I can view the airport associated with my reservation.  <br />
•	As a user I can view the airline(s) associated with my reservation.  <br />
•	As a user I can view the destination and departure city associated with my reservation.  <br />
•	As a user I can view the departure and arrival times of my reservation.  <br />
•	As a user I can view the boarding gate associated with my reservation. <br />
•	As a user I can create a user profile so my personal details are saved. <br />

## Challenges

![image](https://user-images.githubusercontent.com/94870846/152495215-90a3a232-2105-42fd-9a70-9d169a3ca08e.png)

1.)	 One challenge I had was making sure that my methods in my Reservation Service class matched the method names and parameters set up in my interface class (Reservation Repository).
2.)	Another challenge was making sure to focus on separation of concerns.  For example, I had to create different classes for my services and different classes for my repositories.  In this way, each model has their own package and set of classes and the coding/logic doesn’t get jumbled up or confused.
3.)	 I had to remember that the JWT token is established after a user has logged-in with their password and username (not when the user has signed up) in order to authenticate and protect the client/server exchange.
4.)	 Last, I had to remember the importance of adding JSON “write only” Access to my user table in order to not return the password in Postman after the user has registered with email, username, and password.

## Project Links

User Stories and ERD <br />

[User Stories and ERD.docx](https://github.com/tonity2021/Unit-2-Java-Project/files/8005013/User.Stories.and.ERD.docx)

Project Outline and Timeline <br />

[Online booking travel system project timeline.docx](https://github.com/tonity2021/Unit-2-Java-Project/files/8001176/Online.booking.travel.system.project.timeline.docx)






