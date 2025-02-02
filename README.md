# E-commerce REST API

This project provides essential REST APIs for an e-commerce platform. It is designed to manage core e-commerce operations such as categories, products, customers, suppliers, and orders. The project is actively being developed and improved.

## Project Structure

The project consists of the following main components:

- **Controller**: Contains API endpoints.
- **Service**: Handles business logic.
- **Repository**: Manages database operations.
- **DTO (Data Transfer Object)**: Defines request and response data models.
- **Entity**: Represents database tables.
- **Config**: Includes configuration settings.
- **Exception**: Manages custom exception handling.

## Installation

To run the project on your local machine, follow these steps:

1. **Requirements**:
    - Java JDK 23 or later
    - Maven
    - PostgreSQL database

2. **Database Configuration**:
    - Update the database connection details in `src/main/resources/application.properties`.

3. **Build and Run the Project**:
    - Navigate to the project root directory in the terminal.
    - Build the project using `mvn clean install`.
    - Start the application with `mvn spring-boot:run`.

## API Endpoints

### Categories
- `GET /api/categories`: Retrieves all categories.
- `POST /api/categories`: Adds a new category.
- `PUT /api/categories/{id}`: Updates a specific category.
- `DELETE /api/categories/{id}`: Deletes a specific category.

### Products
- `GET /api/products`: Retrieves all products.
- `POST /api/products`: Adds a new product.
- `PUT /api/products/{id}`: Updates a specific product.
- `DELETE /api/products/{id}`: Deletes a specific product.

### Customers
- `GET /api/customers`: Retrieves all customers.
- `POST /api/customers`: Adds a new customer.
- `PUT /api/customers/{id}`: Updates a specific customer.
- `DELETE /api/customers/{id}`: Deletes a specific customer.

### Suppliers
- `GET /api/suppliers`: Retrieves all suppliers.
- `POST /api/suppliers`: Adds a new supplier.
- `PUT /api/suppliers/{id}`: Updates a specific supplier.
- `DELETE /api/suppliers/{id}`: Deletes a specific supplier.

### Orders
- `GET /api/orders`: Retrieves all orders.
- `POST /api/orders`: Adds a new order.
- `PUT /api/orders/{id}`: Updates a specific order.
- `DELETE /api/orders/{id}`: Deletes a specific order.

## Contribution

If you want to contribute, please submit a pull request. For significant changes, open an issue first to discuss what you would like to modify.