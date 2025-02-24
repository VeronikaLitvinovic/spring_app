# Spring Application

## Overview
This project is a Spring-based application that implements various features for user management and data handling. It utilizes MySQL as the database and incorporates best practices for security, logging, and error handling.

## Technologies Used
- **Spring Framework**: For building the application.
- **Spring Boot**: To simplify the setup and configuration.
- **Log4J2**: For logging, integrated with SLF4J and Logback to record logs in both the console and a file.
- **JUnit**: For unit testing, including mock tests.
- **MySQL**: As the relational database management system.
- **Spring Security**: For user authentication and authorization, including password encryption.
- **Validation**: Implemented on both client and server sides to ensure data integrity.

## Features
1. **Logging**: Configured logging with Log4J2 to capture logs in the console and log files.
2. **Error Pages**: Custom error pages for handling HTTP errors (404, 500, etc.).
3. **Unit Testing**: Comprehensive unit tests, including mock testing for service layers.
4. **Database Operations**: Functionality for adding, modifying, and deleting user information in the database.
5. **User Management**:
   - **Sign Up**: User registration with password encryption.
   - **Sign In/Out**: User authentication and session management.
6. **Data Validation**: Client-side and server-side validation to ensure valid input.
7. **User Authorization**: Role-based access control to protect sensitive pages and data.
