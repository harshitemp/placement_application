
---

## 📌 API Overview

### 🧑‍🎓 StudentController – `/api/students`
- `POST /register` – Register a new student  
- `POST /login` – Login a student  
- `GET /{id}` – Get student info by ID  
- `POST /send` – Submit selected students (IDs list)  

### 📋 JobController – `/jobs`
- `POST /post` – Post a job  
- `GET /list` – Get all jobs  

### 🧾 StudentRegistrationController – `/studentRegistration`
- `POST /register` – Register for placement  
- `POST /login` – Login with email and password  
- `GET /{studentId}` – Get registration details  
- `GET /check-registration/{email}` – Check if email is registered  

### 👨‍💼 TpoController – `/api/tpo`
- `POST /login` – Login for TPO (username: `TPo_jobs`, password: `cutmap`)  

---

## ⚙️ Tech Stack
- Java 17  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- REST API  
- CORS enabled (Android & Angular supported)  

---

## 🚀 Running the App
```bash
git clone https://github.com/harshitemp/placement_application.git
cd placement_application
./mvnw spring-boot:run
