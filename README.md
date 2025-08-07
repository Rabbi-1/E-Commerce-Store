### E-Commerce Backend API (Spring Boot)

This project is a secure, modular e-commerce backend built using **Spring Boot**, featuring **JWT authentication**, **email verification**, and basic product/order management functionality.

---

###  Tech Stack

- Java 17+
- Spring Boot
- Spring Security (JWT)
- JPA / Hibernate
- MySQL or PostgreSQL (JPA-compatible)
- JavaMail (for email verification)
- Lombok

---

###  Features

-  User Registration & Login (with validation)
-  Password Encryption (BCrypt)
-  JWT-based Authentication
-  Email Verification via Token
- ️ Product Retrieval (Public)
-  Authenticated Order Retrieval
-  Layered Structure (Controller, Service, DAO, Model)

---

---

### Authentication Flow

1. **Register** a user with `/auth/register`
2. A **verification email** is sent via `EmailService`
3. User verifies email through `/auth/verify?token=...`
4. User logs in with `/auth/login` and receives a **JWT**
5. JWT is required for any protected route (e.g. `/order`, `/auth/me`)

---

###  API Endpoints

####  Public Routes

| Method | Endpoint          | Description                    |
|--------|-------------------|--------------------------------|
| POST   | `/auth/register`  | Register a new user            |
| POST   | `/auth/login`     | Login and get JWT              |
| POST   | `/auth/verify`    | Verify email with token        |
| GET    | `/product`        | Get list of all products       |

####  Protected Routes

| Method | Endpoint         | Description                      |
|--------|------------------|----------------------------------|
| GET    | `/auth/me`       | Get logged-in user's profile     |
| GET    | `/order`         | Get all orders of logged-in user |

> 🔒 All protected routes require an `Authorization: Bearer <token>` header.

---

### Configuration

In `application.properties` (or `.yml`):

```properties
# JWT
jwt.algorithm.key=YourSecretKey
jwt.issuer=your-app
jwt.expiryInSeconds=3600

# Email
email.from=your@email.com
app.frontend.url=http://localhost:3000

# Encryption
encryption.salt.rounds=10
```

---

### How to Run This Project Locally


#### Clone the repository

```bash
git clone https://github.com/your-username/eommerce_backend.git
cd eommerce_backend
```

---

#### Set up `application.properties`

Create a file named `application.properties` inside `src/main/resources/` and configure the following:

```properties
# JWT
jwt.algorithm.key=your-secret-key
jwt.issuer=your-app-name
jwt.expiryInSeconds=3600

# Email
email.from=you@example.com
app.frontend.url=http://localhost:3000

# Encryption
encryption.salt.rounds=10
```

---

#### Start your database

Make sure a compatible SQL database (e.g., MySQL, PostgreSQL) is running and your Spring Boot project is connected to it.

---

#### Run the project

You can start the backend using Maven:

```bash
./mvnw spring-boot:run
```

Or run it directly from your IDE (like IntelliJ).

---

###  API Base URL

```
http://localhost:8080
```

---

