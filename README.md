# Quiz Game API - Spring Boot

## Project Overview

This project is a **Spring Boot REST API Quiz Game** where users can answer random quiz questions and receive a score at the end.

Each user receives **5 random questions** from the database. Questions are shown **one by one**, and the next question appears only after submitting the previous answer.

If the user attempts a **6th question**, the system returns the **final result of the first five questions**.

---

## Features

* User login
* Random question generation
* Unique questions per user
* Answer submission
* Score calculation
* Question tracking per user
* REST API architecture

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## Database Design

### Tables

#### User

Stores user information and score.

#### Question

Stores quiz questions and options.

#### User_Questions_Record

Tracks which questions a user has attempted.

---

## API Endpoints

### Login

```
POST /login
```

### Get Question

```
GET /question/{username}
```

Returns a random question not previously attempted by the user.

### Submit Answer

```
POST /submit
```

Submits answer and checks correctness.

---

## Game Rules

* Each user receives **5 random questions**
* Questions appear **sequentially**
* User must submit answer before getting the next question
* Final score is shown after completing 5 questions

---

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/sahilSakariya81/quiz-game.git
```

2. Open project in **IntelliJ / Eclipse**

3. Configure database in `application.properties`

4. Run the Spring Boot application

---

## Author
Sahil Sakariya
