# IRCTC REST API - Testing Guide

## How to Run the Project

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Postman (for API testing)

### Run using Maven
```bash
# Navigate to project directory
cd implement.restapi.for.IRCTC.applications

# Clean and build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

### Run using IDE
1. Open the project in IntelliJ IDEA / Eclipse / VS Code
2. Navigate to `src/main/java/com/example/demo/Application.java`
3. Right-click and select **Run 'Application'**

### Verify Application is Running
- Application runs on: `http://localhost:8080`
- Check console for: `Started Application in X seconds`

---

## API Endpoints

| Method | Endpoint | Idempotent | Description |
|--------|----------|------------|-------------|
| POST | `/api/irctc/bookticket` | ❌ NO | Book a new ticket |
| GET | `/api/irctc/ticket/{pnr}` | ✅ YES | Get ticket by PNR |
| GET | `/api/irctc/tickets` | ✅ YES | Get all tickets |
| PUT | `/api/irctc/ticket/{pnr}` | ✅ YES | Update ticket |
| DELETE | `/api/irctc/ticket/{pnr}` | ✅ YES | Cancel ticket |

---

## Postman Testing Guide

### 1. Book Ticket (POST - Non-Idempotent)

| Field | Value |
|-------|-------|
| **Method** | `POST` |
| **URL** | `http://localhost:8080/api/irctc/bookticket` |
| **Headers** | `Content-Type: application/json` |

**Body (raw → JSON):**
```json
{
    "name": "Rahul Sharma",
    "dob": "1990-05-15",
    "gender": "Male",
    "doj": "2025-12-25",
    "from": "New Delhi",
    "to": "Mumbai Central",
    "train": "Rajdhani Express"
}
```

**Expected Response (201 Created):**
```json
{
    "pnr": "PNR1734095123456",
    "name": "Rahul Sharma",
    "dob": "1990-05-15",
    "gender": "Male",
    "doj": "2025-12-25",
    "from": "New Delhi",
    "to": "Mumbai Central",
    "train": "Rajdhani Express",
    "status": "Confirmed",
    "price": 1500.0
}
```

---

### 2. Get Ticket by PNR (GET - Idempotent)

| Field | Value |
|-------|-------|
| **Method** | `GET` |
| **URL** | `http://localhost:8080/api/irctc/ticket/{pnr}` |

> Replace `{pnr}` with actual PNR from booking response

**Expected Response (200 OK):**
```json
{
    "pnr": "PNR1734095123456",
    "name": "Rahul Sharma",
    "status": "Confirmed",
    "price": 1500.0
}
```

---

### 3. Get All Tickets (GET - Idempotent)

| Field | Value |
|-------|-------|
| **Method** | `GET` |
| **URL** | `http://localhost:8080/api/irctc/tickets` |

**Expected Response (200 OK):**
```json
[
    {
        "pnr": "PNR1734095123456",
        "name": "Rahul Sharma",
        "status": "Confirmed"
    },
    {
        "pnr": "PNR1734095789012",
        "name": "Priya Singh",
        "status": "Confirmed"
    }
]
```

---

### 4. Update Ticket (PUT - Idempotent)

| Field | Value |
|-------|-------|
| **Method** | `PUT` |
| **URL** | `http://localhost:8080/api/irctc/ticket/{pnr}` |
| **Headers** | `Content-Type: application/json` |

**Body (raw → JSON):**
```json
{
    "name": "Rahul Kumar Sharma",
    "dob": "1990-05-15",
    "gender": "Male",
    "doj": "2025-12-26",
    "from": "New Delhi",
    "to": "Chennai Central",
    "train": "Tamil Nadu Express"
}
```

**Expected Response (200 OK):**
```json
{
    "pnr": "PNR1734095123456",
    "name": "Rahul Kumar Sharma",
    "to": "Chennai Central",
    "train": "Tamil Nadu Express",
    "status": "Confirmed"
}
```

---

### 5. Cancel Ticket (DELETE - Idempotent)

| Field | Value |
|-------|-------|
| **Method** | `DELETE` |
| **URL** | `http://localhost:8080/api/irctc/ticket/{pnr}` |

**Expected Response (200 OK):**
```
Ticket PNR1734095123456 cancelled successfully
```

**If ticket not found (404):**
```
Ticket with PNR PNR1734095123456 not found
```

---

## Postman Collection (Import Ready)

Save the JSON below as `IRCTC_API.postman_collection.json` and import in Postman:

```json
{
    "info": {
        "name": "IRCTC API Collection",
        "description": "REST API for IRCTC Ticket Booking System",
        "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    },
    "item": [
        {
            "name": "1. Book Ticket (POST)",
            "request": {
                "method": "POST",
                "header": [
                    {"key": "Content-Type", "value": "application/json"}
                ],
                "body": {
                    "mode": "raw",
                    "raw": "{\n    \"name\": \"Rahul Sharma\",\n    \"dob\": \"1990-05-15\",\n    \"gender\": \"Male\",\n    \"doj\": \"2025-12-25\",\n    \"from\": \"New Delhi\",\n    \"to\": \"Mumbai Central\",\n    \"train\": \"Rajdhani Express\"\n}"
                },
                "url": {
                    "raw": "http://localhost:8080/api/irctc/bookticket"
                }
            }
        },
        {
            "name": "2. Get Ticket by PNR (GET)",
            "request": {
                "method": "GET",
                "url": {
                    "raw": "http://localhost:8080/api/irctc/ticket/PNR123456789"
                }
            }
        },
        {
            "name": "3. Get All Tickets (GET)",
            "request": {
                "method": "GET",
                "url": {
                    "raw": "http://localhost:8080/api/irctc/tickets"
                }
            }
        },
        {
            "name": "4. Update Ticket (PUT)",
            "request": {
                "method": "PUT",
                "header": [
                    {"key": "Content-Type", "value": "application/json"}
                ],
                "body": {
                    "mode": "raw",
                    "raw": "{\n    \"name\": \"Rahul Kumar Sharma\",\n    \"dob\": \"1990-05-15\",\n    \"gender\": \"Male\",\n    \"doj\": \"2025-12-26\",\n    \"from\": \"New Delhi\",\n    \"to\": \"Chennai Central\",\n    \"train\": \"Tamil Nadu Express\"\n}"
                },
                "url": {
                    "raw": "http://localhost:8080/api/irctc/ticket/PNR123456789"
                }
            }
        },
        {
            "name": "5. Cancel Ticket (DELETE)",
            "request": {
                "method": "DELETE",
                "url": {
                    "raw": "http://localhost:8080/api/irctc/ticket/PNR123456789"
                }
            }
        }
    ]
}
```


## Understanding Idempotency

| Method | Idempotent | Explanation |
|--------|------------|-------------|
| **GET** | ✅ YES | Fetching data 100 times returns same result |
| **PUT** | ✅ YES | Same update repeated = same final state |
| **DELETE** | ✅ YES | Deleting same resource = still deleted |
| **POST** | ❌ NO | Creates NEW resource each time |

### Example:
- **POST** `/bookticket` called 3 times → 3 different tickets created
- **DELETE** `/ticket/PNR123` called 3 times → Ticket remains deleted

---


