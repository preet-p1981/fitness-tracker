# AI-Powered Fitness Tracker 🏋️‍♂️

A smart fitness app that tracks your workouts and gives you AI-powered personalized recommendations. Built with microservices architecture.

## What Does It Do?

- 📊 Track your workouts and fitness activities
- 🤖 Get AI-powered workout recommendations based on your data
- 👤 Manage your profile and fitness goals
- 📈 View your progress and insights

## Tech Stack

**Frontend:** React

**Backend:** Spring Boot Microservices
- User Service - handles login and profiles
- Activity Service - tracks workouts
- AI Service - generates recommendations using Gemini API

**Other Tools:**
- RabbitMQ - for async communication between services
- Eureka Server - service discovery
- API Gateway - load balancing and routing

## Architecture

```
React App → API Gateway → [User Service | Activity Service | AI Service]
                              ↓              ↓              ↓
                           RabbitMQ (messaging between services)
                              ↓
                         Eureka Server (finds services)
```

## Quick Start

### 1. Start RabbitMQ
```bash
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:management
```

### 2. Start Eureka Server
```bash
cd eureka-server
mvn spring-boot:run
```

### 3. Start All Microservices
```bash
# User Service (Port 8081)
cd user-service
mvn spring-boot:run

# Activity Service (Port 8082)
cd activity-service
mvn spring-boot:run

# AI Service (Port 8083)
cd ai-service
mvn spring-boot:run
```

### 4. Start Frontend
```bash
cd frontend
npm install
npm start
```

## Configuration

Add these to each service's `application.properties`:

```properties
# Connect to Eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/

# Connect to RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672

# For AI Service - add your Gemini API key
gemini.api.key=your_api_key_here
```

## How It Works

1. **User logs workout** → Activity Service saves it
2. **Activity Service sends message** → RabbitMQ queue
3. **AI Service receives message** → Processes with Gemini API
4. **AI Service sends recommendations** → Back to user

## Features

✅ User authentication (JWT)  
✅ Track multiple workout types  
✅ AI-powered recommendations  
✅ Microservices architecture  
✅ Async messaging with RabbitMQ  
✅ Service discovery with Eureka  
✅ Load balancing

## API Endpoints

**User:** `/api/users/register`, `/api/users/login`  
**Activity:** `/api/activities` (GET, POST, PUT, DELETE)  
**AI:** `/api/recommendations/`


---

⭐ Star this repo if you like it!
