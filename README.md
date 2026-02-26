# 🤖 AI Powered Study Assistant

An intelligent and scalable **AI Powered Study Assistant** built using Spring Boot, Spring Security, Thymeleaf, and MySQL.

This platform is designed as a modular academic system where study content management is one of the core features, with future expansion toward AI-driven learning tools like summarization, recommendations, and chatbot assistance.

---

# 📌 Overview

The AI Powered Study Assistant is a role-based web application designed to help users manage study-related content securely and efficiently.

It follows a clean MVC architecture and implements secure authentication and authorization using Spring Security.

The system is designed to scale into a complete AI-driven academic assistant.

---

# 🚀 Features

## 🔐 Authentication & Authorization
- User Registration
- Login System
- Role-Based Access Control (USER / ADMIN)
- BCrypt Password Encryption
- Secure Session Management
- Role-based Redirection after Login

## 📝 Study Content Module
- Create Study Entries
- Edit Entries
- Delete Entries
- View Individual Entries
- Search Functionality
- User-specific Content Access

## 👑 Admin Dashboard
- View All Registered Users
- Monitor All Study Entries
- Restricted Admin Endpoints
- Full System Management

---

# 🏗️ System Architecture

This project follows a Layered MVC Architecture:

- Controller Layer → Handles HTTP Requests
- Service Layer → Business Logic
- Repository Layer → Database Interaction
- Entity Layer → JPA Models
- Configuration Layer → Security & Application Setup

---

# 🛠️ Tech Stack

- Backend: Spring Boot
- Security: Spring Security
- Frontend: Thymeleaf, HTML, CSS, Bootstrap
- Database: MySQL
- ORM: Spring Data JPA (Hibernate)
- Build Tool: Maven

---

# 📂 Project Structure

AI-Powered-Study-Assistant/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── controllers/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── Entity/
│   │   │   ├── securityConfig
|   |   |   |--customeSuccessHandler
│   │   │   └── AiPoweredStudyAssistantApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       ├── application.properties
│   │
│   └── test/
│
├── pom.xml
├── README.md
└── .gitignore

---

# 🔄 Role-Based Workflow

## USER
- Access personal dashboard
- Manage own study content
- Perform search operations
- Redirected to /home after login

## ADMIN
- Access admin dashboard
- View and manage all users
- Monitor all study content
- Redirected to /admin/dashboard after login

---

# 🔐 Security Implementation

- Custom UserDetailsService
- BCrypt Password Encoder
- Role-based URL Authorization
- CSRF Protection Enabled
- Secure Authentication Flow

Example Security Configuration:

```
.requestMatchers("/admin/**").hasRole("ADMIN")
.requestMatchers("/user/**").hasRole("USER")
```

# 🧠 Future Enhancements

- AI-based Content Summarization
- Smart Question Generator
- Personalized Study Recommendations
- Performance Analytics Dashboard
- AI Chatbot Integration
- File & PDF Analysis
- REST API with JWT Authentication
- Cloud Deployment

---


