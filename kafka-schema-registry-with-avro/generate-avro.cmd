@echo off
REM Generates Java classes from Avro schemas in src/main/resources/avro/
REM Run this before building or running the app so Employee.java (and other Avro types) are created.
cd /d "%~dp0"
call mvnw.cmd generate-sources -q
echo Avro code generated. You can now run the app from IntelliJ or: mvnw.cmd spring-boot:run
