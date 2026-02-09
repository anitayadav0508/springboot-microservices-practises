# Summary of Changes & Running Both Schemas

## 1. Changes Made in This Project

### 1.1 `pom.xml`
- **Confluent repository** added so Maven resolves Confluent artifacts from `https://packages.confluent.io/maven/`.
- **Dependencies added:**
  - `io.confluent:kafka-avro-serializer` – Avro serialization with Schema Registry.
  - `io.confluent:kafka-schema-registry-client` – Schema Registry client.
  - `org.apache.avro:avro` – Avro API.
- **Avro Maven plugin** (`org.apache.avro:avro-maven-plugin`):
  - Runs in `generate-sources`; generates Java from `src/main/resources/avro/*.avsc`.
  - **Configuration at plugin level** (not inside `<execution>`) so `sourceDirectory` and `outputDirectory` are applied.
  - `sourceDirectory`: `src/main/resources/avro`, `outputDirectory`: `src/main/java`, `includes`: `**/*.avsc`.

### 1.2 `application.yaml`
- **`topic.name`** moved to **root level** so `${topic.name}` resolves (was under `spring`, so it was `spring.topic.name`).
- **Kafka config moved under `spring.kafka`** (was under `server.kafka`; Spring Boot only reads `spring.kafka`).
- **Consumer `group-id`** set: `spring.kafka.consumer.group-id: avro-topic-consumer-group` (required for `@KafkaListener`).
- **Producer/consumer** use `KafkaAvroSerializer` / `KafkaAvroDeserializer` and `schema.registry.url: http://127.0.0.1:8081`.
- **`server.port`** kept under `server` (e.g. 9095).

### 1.3 `KafkaConfig.java`
- **`ProducerFactory<String, Employee>`** and **`KafkaTemplate<String, Employee>`** beans added so the producer gets an Avro-enabled template (fixes “template is null”).
- Uses `KafkaAvroSerializer`, `schema.registry.url`, and bootstrap servers from config.
- **`NewTopic`** bean kept for `topic.name`.

### 1.4 `KafkaAvroProducer.java`
- **`@Autowired`** added on `KafkaTemplate<String, Employee> template` so Spring injects the bean from `KafkaConfig`.

### 1.5 `employee.avsc`
- **Valid JSON** (no trailing commas).
- **Avro types** use lowercase: `string` (not `String`).
- Current fields: `id`, `firstName`, `lastName`, `emailId` (after you removed `dob` and `email`).

### 1.6 `docker-compose.yml`
- **Kafka UI** service added (port 8090) so you have a UI for clusters/topics when Control Center (9021) is not used.
- Rest of stack unchanged: Zookeeper, broker, schema-registry, control-center.

### 1.7 Scripts
- **`generate-avro.sh`** / **`generate-avro.cmd`** – run `./mvnw generate-sources` so Avro Java is regenerated after editing `.avsc`.

---

## 2. Running Both Schemas (Old vs New)

You have two schema shapes:

- **Old:** e.g. `id`, `firstName`, `lastName`, `email`, `dob`
- **New:** `id`, `firstName`, `lastName`, `emailId`

Schema Registry allows **multiple versions** per subject. To “run both” you can do one of the following.

### Option A: Allow New Version and KEEP Version History (Compatibility = NONE) – Recommended

So that the **new** schema registers as **version 2** and **version 1 stays** (no delete), set compatibility for your subject to `NONE`. Use the script to keep history; do **not** delete the subject.

```bash
# Subject for your topic’s value (topic name + "-value")
curl -X PUT -H "Content-Type: application/vnd.schemaregistry.v1+json" \
  "http://localhost:8081/config/avro-topic-creation-value" \
  -d '{"compatibility": "NONE"}'
```

- **Script (keeps version history):** `./scripts/allow-schema-evolution-keep-history.sh` (Windows: `scripts\allow-schema-evolution-keep-history.cmd`).
- **Effect:** Version 1 (old schema) stays; new schema registers as **version 2**. Schema version history shows both.
- **Consumer:** With `KafkaAvroDeserializer` and `specific.avro.reader: true`, the consumer uses the schema version in each message; old and new records can both be read if your Java schema supports optional fields.

### Option B: One Schema That Supports Both (Optional Fields + Defaults)

Design **one** schema that includes all fields, with optional/default for the ones that might be missing:

```json
{
  "namespace": "com.kafka_schema_registry_with_avro.dto",
  "type": "record",
  "name": "Employee",
  "fields": [
    {"name": "id", "type": "string"},
    {"name": "firstName", "type": "string"},
    {"name": "lastName", "type": "string"},
    {"name": "email", "type": ["null", "string"], "default": null},
    {"name": "emailId", "type": ["null", "string"], "default": null},
    {"name": "dob", "type": ["null", "string"], "default": null}
  ]
}
```

- **Effect:** One schema version; old payloads can have `email`/`dob`, new ones `emailId`; missing fields are `null`. Producer/consumer use this single schema so “both” shapes run with one Java model.
- After changing `employee.avsc` to this, run `./mvnw generate-sources` (or `./generate-avro.sh`). If Schema Registry already has an incompatible schema for `avro-topic-creation-value`, delete the subject once for a clean start:  
  `curl -X DELETE "http://localhost:8081/subjects/avro-topic-creation-value"`.

### Option C: Two Topics (Two Schemas)

- Use two topics: e.g. `avro-topic-creation-v1` (old schema) and `avro-topic-creation-v2` (new schema).
- Configure two producer/consumer paths or two `KafkaTemplate`/listeners, each bound to its topic and schema. No Schema Registry compatibility change needed; each topic has its own subject and schema.

---

## 3. Quick Reference

| What you want | What to do |
|---------------|------------|
| **Keep version history** (version 1 + version 2 in Schema Registry) | Set compatibility to `NONE`: run `./scripts/allow-schema-evolution-keep-history.sh`. Do **not** delete the subject. |
| Register new schema without deleting old | Same as above – use `allow-schema-evolution-keep-history.sh`. |
| One schema that supports old + new payloads | Use optional fields + defaults (Option B), regenerate Avro; set compatibility to NONE so new version can register. |
| Keep old and new strictly separate | Use two topics (Option C). |
| Regenerate Java after editing `.avsc` | Run `./mvnw generate-sources` or `./generate-avro.sh`. |
| Fix 409 and **keep** version history | Run `./scripts/allow-schema-evolution-keep-history.sh` (sets compatibility NONE). |
| Fix 409 and **wipe** history (clean slate) | Run `./scripts/reset-schema-registry-subject.sh` (deletes subject – use only if you don’t need history). |
