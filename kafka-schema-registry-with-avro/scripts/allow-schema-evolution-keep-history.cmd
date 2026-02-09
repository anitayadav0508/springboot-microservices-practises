@echo off
REM Sets subject compatibility to NONE so new schemas can be registered as new versions
REM WITHOUT deleting existing versions. Version 1 stays, new schema becomes version 2.
REM Run when you get "Schema being registered is incompatible with an earlier schema; error code: 409"

set SUBJECT=avro-topic-creation-value
set REGISTRY_URL=http://127.0.0.1:8081
if not "%~1"=="" set SUBJECT=%~1
if not "%SCHEMA_REGISTRY_URL%"=="" set REGISTRY_URL=%SCHEMA_REGISTRY_URL%

echo Setting compatibility to NONE for subject: %SUBJECT%
echo This keeps version history: version 1 stays, new schema will register as version 2.
curl -s -X PUT -H "Content-Type: application/vnd.schemaregistry.v1+json" "%REGISTRY_URL%/config/%SUBJECT%" -d "{\"compatibility\": \"NONE\"}"
echo.
echo Done. Restart your app and send the event again; new schema will be version 2.
