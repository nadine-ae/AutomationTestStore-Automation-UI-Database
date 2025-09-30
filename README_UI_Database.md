# AutomationTestStore – UI + Database Automation Tests

This project contains automated test scripts for [Automation Test Store](https://automationteststore.com/) that combine **UI testing with Selenium WebDriver** and **database validation with JDBC (Java Database Connectivity)**.  
It demonstrates how to validate both the front end and the backend for a more complete test coverage.

## Overview
The purpose of this project is to practice and showcase automation testing skills that span across UI and database layers:
- Using Selenium WebDriver and TestNG for browser-based functional tests.
- Connecting to a MySQL database with JDBC to verify data consistency.
- Applying assertions on both UI results and corresponding database records.
- Running integrated tests on a sample e-commerce application.

## Setup
### Prerequisites
- Java JDK 8 or later
- Maven
- TestNG
- Selenium WebDriver
- MySQL database (or compatible) and JDBC driver
- A supported browser (e.g., Chrome, Edge) with its WebDriver

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/nadine-ae/AutomationTestStore-Automation-UI-Database.git
   ```
2. Import the project into your IDE (e.g., Eclipse or IntelliJ) as a Maven project.
3. Ensure dependencies are installed (see `pom.xml`).
4. Configure your database connection details in the code or a config file (username, password, host, schema).

## Running the Tests
- To run tests with Maven:
  ```bash
  mvn clean test
  ```
- Or run individual tests directly from your IDE via TestNG.

## Test Coverage
Current test cases include:
- Navigating and interacting with the Automation Test Store UI (e.g., sign-up, login, cart functions).
- Verifying database records (e.g., new users, stored products) after performing UI actions.
- Asserting both frontend responses and backend data integrity.

## Project Structure
- `src/test/java` → contains TestNG test classes with Selenium and JDBC logic.
- `pom.xml` → Maven configuration with dependencies (Selenium, TestNG, JDBC driver).
- `README.md` → project documentation.

## Notes
- This project extends the UI-only automation project by adding database-level verification.
- For a simpler version without DB validation, see [`AutomationTestStore-Automation-UI`](https://github.com/nadine-ae/AutomationTestStore-Automation-UI).
