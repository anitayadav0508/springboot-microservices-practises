@echo off
REM DELETES the subject and ALL version history. Use only if you really want a clean slate.
REM To KEEP version history (version 1 + version 2), use allow-schema-evolution-keep-history.cmd instead.

set SUBJECT=avro-topic-creation-value
set REGISTRY_URL=http://127.0.0.1:8081
if not "%~1"=="" set SUBJECT=%~1
if not "%SCHEMA_REGISTRY_URL%"=="" set REGISTRY_URL=%SCHEMA_REGISTRY_URL%

echo WARNING: This DELETES subject %SUBJECT% and all schema versions.
echo To keep version history, run: scripts\allow-schema-evolution-keep-history.cmd
echo Deleting subject: %SUBJECT% (Schema Registry: %REGISTRY_URL%)
curl -s -X DELETE "%REGISTRY_URL%/subjects/%SUBJECT%"
echo.
echo Done. Restart your app and send the event again.
