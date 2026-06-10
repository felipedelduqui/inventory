# Mechanical Engineering Parts Inventory API

A lightweight, clean-architecture RESTful API developed with Spring Boot to manage mechanical components and parts inventory for engineering projects.

## Project Structure

The codebase strictly adheres to the standard layered architecture convention (`domain`, `repository`, `service`, `controller`), ensuring separation of concerns and independent business logic validation.

---

```text
inventory/
├── .gitignore
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── engineering/
        │           └── inventory/
        │               ├── InventoryApplication.java
        │               ├── controller/
        │               │   └── PartController.java
        │               ├── domain/
        │               │   └── Part.java
        │               ├── repository/
        │               │   └── PartRepository.java
        │               └── service/
        │                   └── PartService.java
        └── resources/
            └── application.properties

---

## Tech Stack & Ecosystem

* **Backend Framework:** Spring Boot 4.0.6 (Spring Web, Spring Data JPA)
* **Language Runtime:** Java 21 (OpenJDK / Temurin Architecture)
* **Build Automation & Dependency Management:** Apache Maven
* **Database Management System:** H2 Database (In-Memory engine for development lifecycle)
* **Object-Relational Mapping (ORM):** Hibernate 7.2.12.Final
* **Embedded Web Server:** Apache Tomcat 11.0.21
* **Development Environment:** Visual Studio Code (VS Code) with Red Hat Java & Spring Tool Suites

---

## Core Features Implemented

* **Relational Database Mapping:** Managed via Jakarta Persistence (JPA) definitions mapping the `Part` entity schema directly to `tb_parts`.
* **Automated Data Persistence:** Data access interface abstraction using `JpaRepository` providing out-of-the-box CRUD operations.
* **Transaction Management & Validation:** Transaction handling encapsulated inside `PartService`, including preventive logic against duplicate part codes and non-existent IDs.
* **REST Endpoints Layer:** Full HTTP verb binding inside `PartController` utilizing `ResponseEntity` to map precise HTTP Status Codes (`200 OK`, `201 Created`, `204 No Content`, `400 Bad Request`, `404 Not Found`).

---

## API Endpoints Blueprint

| HTTP Method | URI Path | Action Description | Expected Payload / Response |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/parts` | Retrieves the entire inventory collection. | Array of Parts (JSON) |
| **GET** | `/api/parts/{id}` | Fetches a singular mechanical part by ID. | Part Object (JSON) or 404 |
| **POST** | `/api/parts` | Registers a new mechanical component. | Input JSON Body -> Saved Object |
| **DELETE** | `/api/parts/{id}` | Evicts a specific component from stock. | 204 No Content or 404 |

---

## Development Database Console

The H2 interactive web console is active during application runtime for database inspection.

* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL Configuration:** `jdbc:h2:mem:inventorydb`
* **Credentials:** Username: `sa` | Password: *(leave blank)*