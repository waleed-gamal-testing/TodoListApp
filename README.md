# ToDo List App - Automation Testing Project

## Overview
This project focuses on the **Automation Testing** of a ToDo List Application. The primary objective is to test the functionality of the application across various modules, such as:

- **Login Page**
- **Register Page**
- **ToDo Page**
- **New ToDo Page**

Automation testing is implemented using **Selenium**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern. Additionally, **testng.xml** is used to group test cases and methods, enable parallel execution, and support testing across multiple browsers using Maven command-line options.

---

## Features
1. **Automated Testing Scope:**
   - Login functionality validation.
   - User registration workflow testing.
   - CRUD operations on the ToDo Page.
   - Validation of creating a new ToDo task.

2. **Technologies Used:**
   - **Selenium** for web automation.
   - **TestNG** for test management and execution.
   - **Maven** for build and dependency management.
   - **POM Design Pattern** for modularizing and organizing test code.
   - Allure Reporting for creating report
     

3. **Capabilities:**
   - Grouping test cases and methods using **testng.xml**.
   - Running tests in parallel.
   - Multi-browser testing (e.g., Chrome, Firefox, Safari).
   - Command-line execution via Maven.
   - Integrated with API Requists
   - make Utils
   - make Objects 

---
## Video
**Video link for the project**: https://youtu.be/XnD-K_moWzk

---

## Project Structure
```
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           ├── LoginPage.java
│   │           ├── RegisterPage.java
│   │           ├── ToDoPage.java
│   │           └── NewToDoPage.java
│   └── test
│       └── java
│           └── tests
│               ├── LoginTests.java
│               ├── RegisterTests.java
│               ├── ToDoTests.java
│               └── NewToDoTests.java
├── testng.xml
├── pom.xml
└── README.md
```

---

## Prerequisites
- **Java Development Kit (JDK)** (version 8 or higher)
- **Maven** (version 3.6 or higher)
- **WebDriver Executables** for supported browsers (e.g., ChromeDriver, GeckoDriver)
- Supported Browsers: Chrome, Firefox

---

## How to Run the Tests

### 1. Clone the Repository
```bash
git clone <repository_url>
cd <repository_name>
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Execute Tests

#### Run All Tests
```bash
mvn test
```

#### Run Tests on a Specific Browser
- **Chrome:**
```bash
mvn test -Dbrowser=chrome
```
- **Firefox:**
```bash
mvn test -Dbrowser=firefox
```

#### Run Tests in Parallel
```bash
mvn test -Dparallel=true
```

---

## TestNG Configuration (testng.xml)
The **testng.xml** file is configured to:
- Group test cases by modules (Login, Register, ToDo, NewToDo).
- Enable parallel execution of tests.
- Define the browsers to be used for testing.

Example:
```xml
<suite name="ToDoAppTestSuite" parallel="methods" thread-count="4">
    <test name="LoginTests">
        <classes>
            <class name="tests.LoginTests"/>
        </classes>
    </test>
    <test name="RegisterTests">
        <classes>
            <class name="tests.RegisterTests"/>
        </classes>
    </test>
    <test name="ToDoTests">
        <classes>
            <class name="tests.ToDoTests"/>
        </classes>
    </test>
    <test name="NewToDoTests">
        <classes>
            <class name="tests.NewToDoTests"/>
        </classes>
    </test>
</suite>
```

---

## Page Object Model (POM) Design Pattern
Each page of the application has a corresponding class in the **pages** package. These classes:
- Represent the elements on the page.
- Provide reusable methods to interact with the page.

Example:
```java
public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
```

---

## Parallel Execution
Parallel execution is enabled in the **testng.xml** file. Maven allows you to specify the number of threads for execution, ensuring faster test runs.

---

## Multi-Browser Testing
Testing is configured for multiple browsers using Maven profiles and command-line options. The `@Parameters` annotation is used to define the browser type dynamically.

---

## Contributing
Feel free to submit issues or pull requests if you'd like to contribute to the project.

---

## Contact
For any inquiries, please reach out to 
**Waleed Gamal**  at **waleedgamal226@gmail.com**

