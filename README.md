# Clinic Register — QA Portfolio (Manual + Automation)

A simple Spring Boot + Thymeleaf patient registration demo built for **QA portfolio** purposes.

## Features
- Registration form: `GET /register`
- Submit registration: `POST /register`
- Patient list: `GET /patients`
- Bean Validation for form inputs

> Note: Data is stored in-memory. Restarting the app clears registered patients.

## Tech Stack
- Java 17
- Spring Boot (Maven)
- Thymeleaf
- JUnit 5 + Spring MockMvc

## Run
Windows (PowerShell):
```powershell
.\mvnw.cmd spring-boot:run
```

Then open:
- http://localhost:8080/register
- http://localhost:8080/patients

## Automation Tests
Windows (PowerShell):
```powershell
.\mvnw.cmd -U clean test
```

## Manual QA
See: `docs/test-cases.md`

## CI (GitHub Actions)
A workflow can be added to run tests on every push / PR.
See: `.github/workflows/ci.yml`
