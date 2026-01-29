# Learner Management System

A backend **Learner Management System (LMS)** built using **Spring Boot** and **Spring Security with JWT authentication**.  
This project demonstrates clean backend architecture, stateless authentication, and secure REST API design.

🔗 Repository: https://github.com/gansari231/LearnerManagementSystem

---

## 🚀 Features

- User registration & login
- JWT-based authentication
- Password encryption using BCrypt
- Stateless REST APIs
- Spring Security filter-based protection

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- Gradle
- MySQL / PostgreSQL / H2

---

## 📂 Project Structure

src/main/java/org/airtribe/LearnerManagementSystemBelC14   
├── configuration # Security configuration   
├── controller # REST controllers   
├── dto # Request DTOs   
├── entity # JPA entities   
├── filters # JWT authentication filter   
├── repository # Database access   
├── utility # JWT utilities   

---

## 🔐 Authentication

- Users authenticate using email & password
- JWT token is generated on successful login
- Token must be sent in the `Authorization` header:

Authorization: Bearer <JWT_TOKEN>

---

## 🔌 API Endpoints

### 🔓 Public Endpoints
| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and receive JWT |

---

### 🔒 Secured Endpoints (JWT Required)

#### Learners
| Method | Endpoint | Description |
|------|---------|------------|
| GET | `/learners` | Fetch all learners |
| POST | `/learners` | Create a learner |

#### Cohorts
| Method | Endpoint | Description |
|------|---------|------------|
| GET | `/cohorts` | Fetch all cohorts |
| POST | `/cohorts` | Create a cohort |
| POST | `/assignLearnersToCohorts` | Assign learners to cohorts |
| POST | `/cohorts/{cohortId}/learners` | Add learners to a specific cohort |

---

## ▶️ Run Locally

### Prerequisites
- Java 17+
- Gradle
- Database (MySQL / PostgreSQL / H2)

### Steps
```bash
git clone https://github.com/gansari231/LearnerManagementSystem.git
cd LearnerManagementSystem
./gradlew clean build
./gradlew bootRun
```

Server runs at:

http://localhost:3056

---

👤 Author

Gufraan Ansari
Backend Developer | Java | Spring Boot
