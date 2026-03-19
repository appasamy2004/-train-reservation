🚆 Train Ticket Booking System

A full-stack Train Ticket Reservation System built using Spring Boot, enabling users to search trains, book tickets, and view booking history with secure authentication.

🌐 Live Demo

👉 https://train-reservation-91h9.onrender.com

📌 Features

🔐 User Registration & Login (Spring Security)

🔎 Search trains by source and destination

🎟️ Book tickets with seat availability check

📊 View user-specific booking history

🧾 Real-time seat updates after booking

🌐 Deployed on cloud (Render + Railway)

🛠️ Tech Stack

Backend:

Java

Spring Boot

Spring MVC

Spring Security

Hibernate (JPA)

Frontend:

Thymeleaf

HTML

CSS

Bootstrap

Database:

MySQL (Railway Cloud)

Tools & Deployment:

Maven

Git & GitHub

Render (Backend Hosting)

Railway (Database)

⚙️ Installation & Setup (Local)
1. Clone Repository
git clone https://github.com/appasamy2004/Train-Ticket-Reservation.git
cd Train-Ticket-Reservation
2. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/train_db
spring.datasource.username=root
spring.datasource.password=your_password
3. Run Application
mvn spring-boot:run
4. Open in Browser
http://localhost:8080
🧪 Sample Data (Optional)
INSERT INTO train (train_name, source, destination, seats_available)
VALUES 
('Express 1', 'Chennai', 'Bangalore', 100),
('Superfast Express', 'Bangalore', 'Chennai', 80);
🔐 Authentication Flow

Users must register/login to access booking

Spring Security handles authentication

Session-based login management

📂 Project Structure
src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── config
🚀 Deployment

Backend deployed on Render

Database hosted on Railway

Uses environment variables for secure DB connection

🧠 Future Enhancements

💳 Payment integration

📅 Travel date selection

👨‍💼 Admin panel for train management

📱 REST API + React frontend

👨‍💻 Author

Appasamy M

GitHub: https://github.com/appasamy2004

LinkedIn: https://www.linkedin.com/in/appasamy-m
