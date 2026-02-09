#!/bin/bash
# DELETES the subject and ALL version history. Use only if you really want a clean slate.
# To KEEP version history (version 1 + version 2), use allow-schema-evolution-keep-history.sh instead.

SUBJECT="${1:-avro-topic-creation-value}"
REGISTRY_URL="${SCHEMA_REGISTRY_URL:-http://127.0.0.1:8081}"

echo "WARNING: This DELETES subject $SUBJECT and all schema versions."
echo "To keep version history, run: ./scripts/allow-schema-evolution-keep-history.sh"
echo "Deleting subject: $SUBJECT (Schema Registry: $REGISTRY_URL)"
curl -s -X DELETE "$REGISTRY_URL/subjects/$SUBJECT"
echo ""
echo "Done. Restart your app and send the event again."
