#!/bin/bash
# Sets subject compatibility to NONE so new schemas can be registered as new versions
# WITHOUT deleting existing versions. Version 1 stays, new schema becomes version 2.
# Run when you get "Schema being registered is incompatible with an earlier schema; error code: 409"
# Requires: Schema Registry running (e.g. docker compose up -d), curl

SUBJECT="${1:-avro-topic-creation-value}"
REGISTRY_URL="${SCHEMA_REGISTRY_URL:-http://127.0.0.1:8081}"

echo "Setting compatibility to NONE for subject: $SUBJECT (Schema Registry: $REGISTRY_URL)"
echo "This keeps version history: version 1 stays, new schema will register as version 2."
curl -s -X PUT -H "Content-Type: application/vnd.schemaregistry.v1+json" \
  "$REGISTRY_URL/config/$SUBJECT" \
  -d '{"compatibility": "NONE"}'
echo ""
echo "Done. Restart your app and send the event again; new schema will be version 2."
