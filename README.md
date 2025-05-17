# 🧪 Inventory API Test Automation Framework

This is a BDD-style test automation framework for validating an Inventory REST API. It is built using **Java**, **Maven**, **Cucumber**, and **RestAssured**, and supports modular, scalable API test development with reusable components and clean design.

---

## 🚀 Features

- ✅ BDD (Behavior-Driven Development) using Cucumber
- 🔧 API testing using RestAssured
- 📄 POJO models for clean JSON serialization/deserialization
- 🧪 Cucumber feature files to define test scenarios
- 🔁 Reusable service layer
- 📦 Maven for dependency and build management
- 📋 Gherkin syntax for readable test cases
- ♻️ Dependency injection via PicoContainer for shared step state

---

## 📁 Project Structure

├── pom.xml
├── README.md
└── src
├── main
│ └── java
│ └── org.example
│ └── PojoClasses # POJOs for request/response bodies
│ └── modules
│ └── clientService # Service layer for API calls
└── test
├── java
│ ├── StepDefinition # Step definitions
│ └── Runner # Test runner class
└── resources
└── features # Cucumber feature files



---

## 🔧 Tools & Technologies

- Java 8+
- Maven
- Cucumber
- RestAssured
- JUnit/TestNG
- Lombok
- Gherkin
- PicoContainer (for dependency injection)

---

## 📥 Installation & Setup

### 1. Clone the repository

```bash
git clone https://github.com/Trishul29/home-test-api-trishul.git
cd inventory-api-tests


2. Install dependencies
bash
Copy
Edit
mvn clean install

3. Run tests
bash
Copy
Edit
mvn test



