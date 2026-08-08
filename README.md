# SportBooking

SportBooking is a sports facility reservation management system developed as part of the Programming Workshop course at Universidad Manuela Beltrán.

The main purpose of the project is to provide a simple and organized way to manage reservations for different sports facilities such as football fields, basketball courts, tennis courts, volleyball courts, gyms, and training rooms.

The application was developed using Java 21 and Gradle. It applies advanced Object-Oriented Programming concepts including abstraction, encapsulation, inheritance, polymorphism, association, and cohesion.

The project also applies the five SOLID principles to improve code organization, maintainability, and scalability. Different responsibilities are separated into services, repositories, domain entities, validations, and infrastructure components.

SportBooking includes custom exception handling for validation errors, business rules, and missing entities. Functional interfaces, lambda expressions, and method references are also used as part of the implementation.

The repository follows a layered structure with domain, application, and infrastructure packages. The Repository pattern is used to separate business logic from data storage, while constructor dependency injection is used to reduce coupling between components.

JUnit 5 and AssertJ are used for unit testing. The project currently includes tests for schedules, reservation state transitions, validation rules, and custom exceptions.

GitHub Copilot was used as a programming assistant and code review tool. Its suggestions were critically evaluated before being incorporated into the project.

GitHub Actions is configured to automatically compile the project and execute the tests on every relevant push and pull request.

## Main Features

- User management
- Sports facility management
- Schedule validation
- Reservation creation and state control
- Sports facility availability validation
- Custom domain exceptions
- Repository pattern
- SOLID principles
- Unit testing
- Continuous Integration with GitHub Actions

## Technologies

- Java 21
- Gradle 9
- JUnit 5
- AssertJ
- SLF4J
- Logback
- Git
- GitHub
- GitHub Actions
- GitHub Copilot
- Visual Studio Code

## Authors

- Andres Santiago Solano Caballero
- Maicol David Rubiano Ruiz
- Jesus Sebastian Medina Claros

## Academic Project

Programming Workshop  
Universidad Manuela Beltrán  
2026