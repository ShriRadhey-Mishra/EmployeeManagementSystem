# Employee Management System

It is a REST-based backend application built using Spring Boot, MySQL and JPA/Hibernate. It provides CRUD operations and role based filtering. I have also implemented validations, logging and global exception handler to it.

Project Structure follow a MVC pattern where there are clean and separate boundry between Controller, Service and Repository Layer ensuring loose coupling.

```
com/
   └── employee/
      └── employeemanagement/
          ├── EmployeeManagementApplication.java
          ├── controller/
          │   ├── EmployeeController.java
          │   └── GreetController.java
          ├── entity/
          │   └── Employee.java
          ├── exception/
          │   └── GlobalExceptionHandler.java
          ├── repository/
          │   └── EmployeeRepository.java
          └── service/
              └── EmployeeService.java
```

## Features Implemented:

- Create, Read, Update and Delete Employees (CRUD)
- Role based Segregation (Intern, Manager, HR, Staff)
- Self Referencing Hierarchy
- Assign Manager and HR dynamically
- Stream based filtering using Java Stream API
- Bean Validation for input data
- Global Exception Handler
- Structured Logging using SLF4J
- RESTful API design
