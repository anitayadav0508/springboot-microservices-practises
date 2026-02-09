# Apache Kafka Producer Application

Spring Boot application that publishes messages to Apache Kafka. It exposes REST APIs to send plain text or JSON (Customer) events to a Kafka topic.

---

## Prerequisites

- **Java 17**
- **Maven**
- **Apache Kafka** running on `localhost:9092`

---

## How to Run

1. Start Kafka (broker on port 9092).
2. From project root:

   ```bash
   ./mvnw spring-boot:run
   ```

3. Application runs at **http://localhost:9191**.

---

## Code Flow

```
┌─────────────────────────────────────────────────────────────────────────────┐
│  Client (HTTP)                                                               │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│  EventController  (/produce-app)                                             │
│  • GET  /publish/{message}  → publishMessage(message)                         │
│  • POST /publish           → sendEventsToTopic(customer)                     │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│  KafkaMessagePublisher (Service)                                              │
│  • sendMessageToTopic(String)  → template.send("Test", 2, null, message)    │
│  • sendEventsToTopic(Customer) → template.send("Test", 2, null, customer)   │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│  KafkaTemplate (KafkaProducerConfig)                                         │
│  • ProducerFactory → bootstrap: localhost:9092                               │
│  • Key: StringSerializer, Value: JsonSerializer                              │
└─────────────────────────────────────────────────────────────────────────────┘
                                      │
                                      ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│  Kafka Topic: "Test" (4 partitions, replication factor 1)                    │
└─────────────────────────────────────────────────────────────────────────────┘
```

**Flow summary**

1. **EventController** receives HTTP requests and delegates to **KafkaMessagePublisher**.
2. **KafkaMessagePublisher** uses **KafkaTemplate** to send messages to the **Test** topic (partition 2, key `null`).
3. **KafkaProducerConfig** defines the topic, producer config (bootstrap, serializers), and **KafkaTemplate** bean.
4. Messages are sent asynchronously via `CompletableFuture`; success/offset or errors are logged in the service.

---

## API Reference

Base URL: **http://localhost:9191**  
Base path: **/produce-app**

---

### 1. Publish plain text message (GET)

Sends a string message to the Kafka topic `Test`.

| Field    | Value                          |
|----------|--------------------------------|
| **Method** | `GET`                         |
| **URL**    | `http://localhost:9191/produce-app/publish/{message}` |
| **Path param** | `message` – any string (e.g. `hello`) |

**Example request**

```http
GET http://localhost:9191/produce-app/publish/hello
```

**Example success response**

- **Status:** `200 OK`
- **Body:** `"Message published successfully"`

**Example error response**

- **Status:** `500 Internal Server Error`
- **Body:** error message string (e.g. Kafka connection failure)

---

### 2. Publish Customer event (POST)

Sends a JSON `Customer` object to the Kafka topic `Test`.

| Field    | Value                          |
|----------|--------------------------------|
| **Method** | `POST`                        |
| **URL**    | `http://localhost:9191/produce-app/publish` |
| **Content-Type** | `application/json`      |

**Request body (payload)**

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "contactNo": "9876543210"
}
```

| Field       | Type    | Description   |
|------------|---------|---------------|
| `id`       | integer | Customer ID   |
| `name`     | string  | Customer name |
| `email`    | string  | Email address |
| `contactNo`| string  | Contact number|

**Example request**

```http
POST http://localhost:9191/produce-app/publish
Content-Type: application/json

{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "contactNo": "9876543210"
}
```

**Response**

- **Status:** `200 OK` (no response body; message is published asynchronously to Kafka).

---

## cURL Examples

**Publish a text message**

```bash
curl -X GET "http://localhost:9191/produce-app/publish/hello-world"
```

**Publish a Customer event**

```bash
curl -X POST "http://localhost:9191/produce-app/publish" \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "Jane Smith",
    "email": "jane@example.com",
    "contactNo": "1234567890"
  }'
```

---

## Configuration

| Setting            | Value           | Description                    |
|--------------------|-----------------|--------------------------------|
| Server port        | `9191`          | `application.yaml`             |
| Kafka bootstrap    | `localhost:9092`| `KafkaProducerConfig.java`     |
| Topic name         | `Test`          | Used in `KafkaMessagePublisher` |
| Topic partitions   | `4`             | `KafkaProducerConfig.createTopic()` |
| Replication factor| `1`             | `KafkaProducerConfig.createTopic()` |

---

## Project Structure

```
src/main/java/com/implementation_of_producer_apachekafka/
├── ImplementationOfApachekafkaApplication.java   # Entry point
├── cofiguration/
│   └── KafkaProducerConfig.java                  # Topic, ProducerFactory, KafkaTemplate
├── controller/
│   └── EventController.java                     # REST endpoints
├── pojo/
│   └── Customer.java                            # Customer DTO
└── service/
    └── KafkaMessagePublisher.java               # Kafka publish logic
```

---

## Dependencies (main)

- `spring-boot-starter-webmvc` – REST API
- `spring-boot-starter-kafka` – Kafka producer
- `jackson-databind` – JSON (for Customer)
- `lombok` – DTO boilerplate (e.g. `Customer`)
