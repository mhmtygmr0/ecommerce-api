# E-commerce REST API

This project provides a foundational REST API for an e-commerce platform. It is built using Spring Boot 3.4.1 and manages core e-commerce functionalities such as categories, products, customers, suppliers, and orders.

## Project Structure

The project consists of the following key components:

- **Controller**: Contains API endpoints.
- **Service**: Manages business logic.
- **Repository**: Handles database operations.
- **DTO (Data Transfer Object)**: Defines request and response data models.
- **Entity**: Represents database tables.
- **Config**: Holds configuration settings.
- **Exception**: Provides custom exception handling.

## Technologies Used

- **Spring Boot 3.4.1**
- **Spring Boot Starter Web** (for RESTful API development)
- **Spring Boot Starter Data JPA** (for database interactions)
- **Spring Boot Starter Validation** (for input validation)
- **Spring Boot DevTools** (for development convenience)
- **ModelMapper 3.2.2** (for object mapping)
- **Lombok** (to reduce boilerplate code)
- **PostgreSQL** (as the database)

## Installation & Setup

Follow these steps to run the project locally:

### Prerequisites:

- **Java JDK 23**
- **Maven**
- **PostgreSQL**

### Database Configuration:

Update the database connection settings in `src/main/resources/application.properties`.

### Build & Run the Project:

1. Navigate to the project root directory.
2. Run `mvn clean install` to build the project.
3. Start the application using `mvn spring-boot:run`.

## API Endpoints

### Categories

- **GET** `/api/categories`: Fetch all categories.
- **POST** `/api/categories`: Add a new category.
- **PUT** `/api/categories/{id}`: Update a specific category.
- **DELETE** `/api/categories/{id}`: Delete a specific category.

### Products

- **GET** `/api/products`: Fetch all products.
- **POST** `/api/products`: Add a new product.
- **PUT** `/api/products/{id}`: Update a specific product.
- **DELETE** `/api/products/{id}`: Delete a specific product.

### Customers

- **GET** `/api/customers`: Fetch all customers.
- **POST** `/api/customers`: Add a new customer.
- **PUT** `/api/customers/{id}`: Update a specific customer.
- **DELETE** `/api/customers/{id}`: Delete a specific customer.

### Suppliers

- **GET** `/api/suppliers`: Fetch all suppliers.
- **POST** `/api/suppliers`: Add a new supplier.
- **PUT** `/api/suppliers/{id}`: Update a specific supplier.
- **DELETE** `/api/suppliers/{id}`: Delete a specific supplier.

### Orders

- **GET** `/api/orders`: Fetch all orders.
- **POST** `/api/orders`: Add a new order.
- **PUT** `/api/orders/{id}`: Update a specific order.
- **DELETE** `/api/orders/{id}`: Delete a specific order.

---

**Note:** This project is actively being developed and improved.