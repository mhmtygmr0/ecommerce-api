# E-Commerce API

This project is a RESTful API application developed for an e-commerce platform. It manages essential components such as categories, products, and suppliers. The project is built using Spring Boot and Hibernate.

## Features
- Management of categories, products, and suppliers
- CRUD (Create, Read, Update, Delete) operations
- Data transfer and validation with DTOs
- Centralized error handling (`GlobalExceptionHandler`)
- Clean code structure with layered architecture
- DTO and Entity conversions using ModelMapper
- Standardized API responses (`Result` and `ResultData` structures)

---

## Project Structure

### Packages and Classes
- **controller**: Handles HTTP requests
    - `CategoryController`, `ProductController`, `SupplierController`
- **core**: Helper classes and global configurations
    - `ModelMapperConfig`, `GlobalExceptionHandler`
- **dto**: Classes for data transfer
    - `CategorySaveRequest`, `ProductResponse`, etc.
- **entity**: Represents database tables
    - `Category`, `Product`, `Supplier`
- **repository**: JPA repositories
    - `CategoryRepository`, `ProductRepository`, `SupplierRepository`
- **service**: Manages business logic
    - `CategoryService`, `ProductService`, `SupplierService`

---

## Technologies Used
- **Java**: 17
- **Spring Boot**: 3.1
- **Hibernate**: ORM framework
- **PostgreSQL**: Database
- **ModelMapper**: For DTO conversions
- **Lombok**: To simplify code
- **Maven**: Project build tool

---

## Installation and Running

### Prerequisites
- Java 17+
- Maven
- PostgreSQL

### Steps
1. Clone the project:
   ```bash
   git clone https://github.com/mhmtygmr0/ecommerce-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ecommerce-api
   ```
3. Configure the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Install Maven dependencies:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## API Endpoints

### Category Endpoints
- **GET** `/api/categories`: Retrieves all categories.
- **POST** `/api/categories`: Creates a new category.
- **PUT** `/api/categories/{id}`: Updates a category.
- **DELETE** `/api/categories/{id}`: Deletes a category.

### Product Endpoints
- **GET** `/api/products`: Retrieves all products.
- **POST** `/api/products`: Creates a new product.
- **PUT** `/api/products/{id}`: Updates a product.
- **DELETE** `/api/products/{id}`: Deletes a product.

### Supplier Endpoints
- **GET** `/api/suppliers`: Retrieves all suppliers.
- **POST** `/api/suppliers`: Creates a new supplier.
- **PUT** `/api/suppliers/{id}`: Updates a supplier.
- **DELETE** `/api/suppliers/{id}`: Deletes a supplier.

---

## Error Handling
- **404 Not Found**: Thrown when the requested data is not found.
- **400 Bad Request**: Thrown when invalid or incomplete data is sent.
- **500 Internal Server Error**: Thrown for unexpected errors.

---

## Contributing
To contribute, fork the repository and submit a pull request.

---

## License
This project is licensed under the MIT License.