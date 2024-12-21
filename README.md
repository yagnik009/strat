# strat

## Description
This is a simple Spring Boot application that allows users to take a quiz. Users can start a quiz session, answer multiple choice questions, and see their results.

## Requirements
- Spring Boot
- H2 Database

## Setup
1. Clone this repository:
   ```bash
   git clone https://github.com/yagnik009/strat.git
   ```
2. Open the project in your IDE  IntelliJ IDEA.
3. Run the `QuizAppApplication` class as a Spring Boot application.

## API Endpoints
- **Start a new quiz session**: `POST /api/quiz/start`
- **Get a random question**: `GET /api/quiz/random-question`
- **Submit an answer**: `POST /api/quiz/submit`
- **Get user statistics**: `GET /api/quiz/stats`
- **Add Questions Endpoint**:POST /api/AddQuestion'

## Assumptions
- The database is seeded with sample questions and a user.
- The H2 database is used for simplicity.
