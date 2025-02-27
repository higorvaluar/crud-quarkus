# CRUD API with Quarkus

## Overview
This is a CRUD (Create, Read, Update, Delete) API built with Quarkus. It leverages Hibernate ORM with Panache, PostgreSQL, and RESTful endpoints to manage tasks.

## Technologies Used
- **Java 21**
- **Quarkus 3.19.1**
- **Hibernate ORM with Panache**
- **PostgreSQL**
- **Docker**
- **Maven**

## Requirements
- Java 21 installed
- Maven installed
- Docker (for PostgreSQL container)
- Git (for version control)

## Setup Instructions
### 1. Clone the Repository
```bash
git clone https://github.com/higorvaluar/crud-quarkus.git
cd crud-quarkus
```

### 2. Start PostgreSQL Database with Docker
```bash
docker run --name postgres-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=tasks_db -p 5432:5432 -d postgres
```

### 3. Configure the Database Connection
Edit the `src/main/resources/application.yml` file to match your PostgreSQL credentials:
```xml
quarkus:
  datasource:
    db-kind: postgresql
    jdbc:
      url: jdbc:postgresql://localhost:5432/tasks_db
    username: admin
    password: admin
  hibernate-orm:
    database:
      generation: drop-and-create
```

### 4. Run the Application in Development Mode
```sh
./mvnw quarkus:dev
```

The application will be available at: [http://localhost:8080](http://localhost:8080)

## Available Endpoints
| Method | Endpoint     | Description          |
|--------|-------------|----------------------|
| GET    | /tasks      | Get all tasks        |
| GET    | /tasks/{id} | Get task by ID       |
| POST   | /tasks      | Create a new task    |
| PUT    | /tasks/{id} | Update a task        |
| DELETE | /tasks/{id} | Delete a task        |

## Building and Running the Application as a JAR
To package the application as a JAR file and run it:
```sh
./mvnw packag
java -jar target/quarkus-app/quarkus-run.jar
```

## Contributing
Feel free to fork the repository and submit pull requests with improvements.

## License
This project is licensed under the MIT License.

---
**Happy coding! 🚀**

