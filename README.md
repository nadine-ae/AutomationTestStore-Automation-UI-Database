# Ecommerce-Automation-JDBC

This project contains automated tests for an e-commerce web application that integrate **UI testing with database validation** using **Java, Selenium WebDriver, TestNG, and JDBC**.  
It verifies key user workflows such as login, registration, product browsing, and cart operations — ensuring that both the front-end actions and the underlying database entries are validated for consistency.

## Overview
The purpose of this project is to combine UI and backend testing techniques:
- Automating browser interactions with Selenium WebDriver.  
- Executing SQL queries via JDBC to validate database records.  
- Structuring and executing tests with TestNG annotations.  
- Performing assertions to compare UI data with database results.

## Setup
### Prerequisites
- Java JDK 8 or later  
- Maven  
- TestNG  
- MySQL Database (or compatible RDBMS)  
- A supported browser (e.g., Chrome, Edge) with the appropriate WebDriver  

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/nadine-ae/ecommerce-automation-jdbc.git
   ```
2. Import the project into your IDE (e.g., Eclipse or IntelliJ) as a Maven project.  
3. Update your database credentials and connection URL in the configuration file or test class.  
4. Ensure dependencies are downloaded automatically via `pom.xml`.

## Running the Tests
- To execute tests via Maven:
  ```bash
  mvn clean test
  ```
- Or run individual tests directly from your IDE using TestNG configuration.

## Test Coverage
Current test cases include:
- User registration and login validation (UI + database).  
- Product search and display verification.  
- Cart update and item persistence validation.  
- Backend data verification through JDBC queries.

## Project Structure
- `src/test/java` → TestNG test classes integrating Selenium and JDBC logic.  
- `resources/` → Configuration files (database connection, drivers).  
- `pom.xml` → Maven dependencies (Selenium, TestNG, JDBC).  
- `README.md` → Project documentation.

## Notes
- This project focuses on **UI and database integration testing**.  
- API testing is not included in this version.
