# University AI Assistant

AI-powered assistant for a university system built with **Spring Boot + PostgreSQL + Gemini (LLM)**.

---

## Overview

This project allows users to query university data using **natural language**.

Instead of writing SQL, users can ask:

* Show top students in Algorithms
* What courses does John Smith teach?
* Show grades for John Smith
* Show statistics for the Computer Science department
* What courses does John Smith teach?
* Find people named Alex

The system:

1. Uses an **LLM (Gemini)** to understand the request
2. Selects the appropriate **tool**
3. Executes SQL queries
4. Returns a structured and human-friendly response

---

##  Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Liquibase
* Spring AI (Gemini)

---

## Run with Docker (1 command)

### 1. Set API key

Create `.env` file in project root:

```text
GEMINI_API_KEY=your_api_key_here
```

---

### 2. Run

```bash
docker compose up --build
```

---

### 3. App is running, send requests to 

```text
http://localhost:8080/ask
```

---

## AI Tools

The system uses a **tool-based approach**:

* `GET_DEPARTMENT_STATS`
* `GET_STUDENT_GRADES`
* `FIND_COURSES_BY_LECTURER`
* `SEARCH_PEOPLE`
* `GET_TOP_STUDENTS`

---
