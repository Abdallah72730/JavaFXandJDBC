# JavaFX + JDBC — Student Data Management System

A full-stack Java desktop application that connects a JavaFX graphical interface to a live SQL database using the JDBC API. Handles real-time student data — adding, viewing, updating, and deleting records — with the UI and database staying in sync at all times.

Built at Red Deer Polytechnic to learn how frontend GUI development and backend database connectivity work together in a single Java application.

---

## What It Does

- **Add students** — fill in a form and submit; record is written to both the UI table and the database simultaneously
- **View all records** — live table populated from the database on load
- **Update records** — select a row, edit fields, push changes to the database
- **Delete records** — remove a record from the UI and the database in one action
- **Input validation** — form fields are validated before any database operation runs, preventing bad data from entering the system
- **Database sync testing** — data consistency between the UI display and backend state was manually verified throughout development

---

## Project Structure

```
JavaFXandJDBC/
├── src/main/                   # Java source files
│   ├── controllers/            # JavaFX controllers — handle UI events and DB calls
│   ├── models/                 # Data model classes — represent student records
│   └── db/                     # Database connection and query logic
├── .mvn/wrapper/               # Maven wrapper
├── pom.xml                     # Maven project config — dependencies including JavaFX + JDBC
└── .gitignore
```

---

## Tech Stack

- **Java** — core language
- **JavaFX** — graphical desktop UI (forms, tables, buttons)
- **JDBC API** — Java Database Connectivity for SQL operations
- **SQL** — database queries (SELECT, INSERT, UPDATE, DELETE)
- **Maven** — build tool and dependency management

---

## Key Concepts Demonstrated

**Full-stack desktop app** — the UI layer (JavaFX) and the data layer (SQL via JDBC) are properly separated. Controllers handle user events, call the database layer, and update the UI — not mixed together.

**Complete CRUD** — all four database operations are implemented and tested:
- `INSERT` — add new student
- `SELECT` — load and display all records
- `UPDATE` — edit existing record
- `DELETE` — remove record

**Input validation** — data is validated on the Java side before any SQL query runs. This prevents malformed data from reaching the database and teaches the pattern used in every real-world data application.

**JDBC connection management** — database connections are opened and properly closed, handling connection errors and SQL exceptions.

---

## How to Run

### Prerequisites
- Java 17+
- JavaFX SDK
- A running SQL database (MySQL or compatible)
- Maven

### Setup

1. Clone the repository:
```bash
git clone https://github.com/Abdallah72730/JavaFXandJDBC.git
cd JavaFXandJDBC
```

2. Configure your database connection in the DB config file (host, port, username, password, database name)

3. Run the SQL setup script to create the students table (if provided)

4. Build and run with Maven:
```bash
./mvnw javafx:run
```

---

## What I Learned

- Connecting a Java frontend to a real SQL database using JDBC
- Building and wiring JavaFX controllers to handle form submissions and table updates
- Writing parameterized SQL queries to prevent injection and handle user input safely
- Debugging live database connection issues and tracing SQL execution errors
- Managing Maven dependencies for a multi-library Java project

---

## Author

**Abdallah Najmudin Syed** — Computer Programming Student, Red Deer Polytechnic  
