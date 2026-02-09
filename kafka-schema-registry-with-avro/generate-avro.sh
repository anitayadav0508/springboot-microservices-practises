#!/bin/bash
# Generates Java classes from Avro schemas in src/main/resources/avro/
# Run this before building or running the app so Employee.java (and other Avro types) are created.
cd "$(dirname "$0")"
./mvnw generate-sources -q
echo "Avro code generated. You can now run the app from IntelliJ or: ./mvnw spring-boot:run"
