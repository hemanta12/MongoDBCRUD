# MongoDB CRUD Application with Spring Boot

This project is a simple CRUD (Create, Read, Update, Delete) application using **Spring Boot** and **MongoDB**. It demonstrates how to perform basic database operations like inserting, updating, retrieving, and deleting data using Spring Boot and MongoDB. It also uses normal and complex indexing for optimization.

## Features

- Create a new device (POST)
- Retrieve all devices (GET)
- Retrieve a device by ID (GET)
- Update a device by ID (PUT)
- Delete a device by ID (DELETE)
- **Database optimization** with normal and compound indexing:
  - Normal indexes on `name` and `price` fields
  - Compound index on `category` and `brand` fields for efficient querying

## Technology Stack

- **Spring Boot**: Backend framework
- **MongoDB**: NoSQL database
- **Spring Data MongoDB**: MongoDB integration with Spring Boot
- **Maven**: Build tool

## Getting Started

### Prerequisites

Before you can run this application, make sure you have the following installed on your machine:

- **Java** (JDK 11+)
- **Maven**
- **MongoDB** (running locally or via MongoDB Atlas)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/mongodb-crud-spring-boot.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd mongodb-crud-spring-boot
    ```

3. **Update MongoDB Configuration:**

    - In `src/main/resources/application.properties`, configure your MongoDB connection:

      ```properties
      spring.data.mongodb.uri=mongodb://localhost:27017/crud_practice
      ```

    - If you're using **MongoDB Atlas**, replace `mongodb://localhost:27017/crud_practice` with your MongoDB connection string from Atlas.

4. **Build the project:**

    ```bash
    mvn clean install
    ```

5. **Run the project:**

    ```bash
    mvn spring-boot:run
    ```
### API Endpoints

| Method | Endpoint               | Description                        |
|--------|------------------------|------------------------------------|
| POST   | `/api/devices`          | Create a new device                |
| GET    | `/api/devices`          | Retrieve all devices               |
| GET    | `/api/devices/{id}`     | Retrieve a device by ID            |
| PUT    | `/api/devices/{id}`     | Update a device by ID              |
| DELETE | `/api/devices/{id}`     | Delete a device by ID              |

### Sample JSON for Creating/Updating a Device

```json
{
  "name": "Device A",
  "type": "Mobile",
  "price": 500,
  "manufacturer": "Company X"
}
```

### Testing with Postman or cURL

You can test the endpoints using Postman or cURL.

- **Create a new device:**

  ```bash
  curl -X POST http://localhost:8080/api/devices \
       -H "Content-Type: application/json" \
       -d '{"name": "Device A", "type": "Mobile", "price": 500, "manufacturer": "Company X"}'
  ```
 -** Retrieve all devices:**

```bash
curl -X GET http://localhost:8080/api/devices
Retrieve a device by ID:
```

```bash
curl -X GET http://localhost:8080/api/devices/{id}
Update a device by ID:
```

```bash
curl -X PUT http://localhost:8080/api/devices/{id} \
     -H "Content-Type: application/json" \
     -d '{"name": "Device B", "type": "Laptop", "price": 1000, "manufacturer": "Company Y"}'
Delete a device by ID:
```

```bash
curl -X DELETE http://localhost:8080/api/devices/{id}
Project Structure
```

```bash
/src
 ├── /main
 │   ├── /java/com/example/mongodbcrud
 │   │   ├── /controllers
 │   │   ├── /models
 │   │   ├── /repositories
 |   |   |__ /services 
 │   │   └── Application.java
 │   └── /resources
 │       └── application.properties
 └── /test
     └── /java/com/example/mongodbcrud
```

## Database Optimization with Indexing

This project now includes **database optimizations** using **MongoDB indexes** to enhance query performance.

### Indexes Added:
1. **Normal Indexes**:
   - `name`: Indexed to optimize queries that search by product name.
   - `price`: Indexed to optimize queries that filter products by price.

2. **Compound Index**:
   - `category` and `brand`: Compound index to optimize queries that filter products by both category and brand simultaneously.

### How Indexes Are Created:
The indexes are automatically created when the application starts. The `IndexService` is responsible for managing the index creation.

- **Normal Indexes**: Created on the `name` and `price` fields.
- **Compound Index**: Created on the `category` and `brand` fields.

### How to Test:
You can test the indexing improvements by querying the `Product` collection via the API endpoints or by using MongoDB's `explain()` function to verify index usage.


- **License**
This project is licensed under the MIT License - see the LICENSE file for details.
