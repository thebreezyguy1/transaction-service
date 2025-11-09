# 🏦 Afriland Transaction Simulator

A microservice-based transaction simulation system inspired by real banking architecture.

## 🚀 Tech Stack
- **Spring Boot** (backend framework)
- **RabbitMQ** (message queue)
- **MySQL** (data persistence)
- **Firebase Cloud Messaging** (push notifications)
- **Docker** (containerization)

## ⚙️ Architecture



## 🧱 Setup Instructions

### 1. Clone the repo
```bash
git clone https://github.com/<your-username>/afriland-transaction-simulator.git
cd afriland-transaction-simulator
```

### 2. Run dependencies (RabbitMQ & MySQL)
```bash
docker-compose up
```

### 3. Run the Transaction Service
```bash
cd transaction-service
mvn spring-boot:run
```

### 4. Simulate a transaction
```bash
POST http://localhost:8081/api/transactions/simulate
```

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Build](https://img.shields.io/github/actions/workflow/status/<username>/afriland-transaction-simulator/maven.yml)
