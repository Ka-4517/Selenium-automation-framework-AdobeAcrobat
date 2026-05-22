🔥 FINAL README.md (CLEAN + PROFESSIONAL)
# 🔥 Adobe Acrobat Automation Framework

This project is a Selenium-based automation framework built using **Java, Selenium, Cucumber (BDD), TestNG, and Allure Reporting**.

It automates an end-to-end user journey for Adobe Acrobat including login, navigation, and PDF Spaces validation.

---

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- Allure Reports

---

## 📁 Project Structure


src/test/java
├── base → WebDriver setup
├── pages → Page Object Model (POM)
├── utils → Waits, config reader, screenshots
├── hooks → Test lifecycle (Before/After)
├── runners → Test execution classes
└── stepdefinitions → Cucumber step implementations

src/test/resources
├── config → config & test data
├── features → BDD feature files
└── extent.properties


---

## 🧠 Framework Design

- Page Object Model (POM)
- Cucumber BDD approach
- Externalized test data (properties files)
- Explicit waits (WaitUtils)
- Hooks for setup & teardown
- Screenshot capture on failure
- Allure reporting integration
- Failed scenario rerun mechanism

---

## 🧪 Test Scenario Covered

- User opens application
- User logs in
- Navigate to All Tools
- Verify "Create PDF Space" feature
- Open curated section
- Validate curated PDF spaces
- Verify profile email

---

## ▶️ How to Run Tests

```bash
mvn clean test
📊 View Allure Report
allure serve allure-results
🔁 Rerun Failed Scenarios
Run tests normally
Failed scenarios stored in:
target/failed_scenarios.txt
Rerun failed tests:
mvn test -Dcucumber.options="@target/failed_scenarios.txt"
📸 Screenshot Handling
Automatically captured on test failure
Attached in Allure report
⚙️ Configuration

Located in:

src/test/resources/config
config.properties → Base URL
testdata.properties → Test data (email, password, expected values)
📈 Execution Flow
Feature File (BDD)
        ↓
Step Definitions
        ↓
Page Classes (POM)
        ↓
WaitUtils (Synchronization)
        ↓
WebDriver
        ↓
Application Under Test

👉 (You can replace this with a diagram image)

🎯 Key Highlights
Clean and scalable framework design
Separation of concerns
Reusable utilities
Industry-standard practices
Easy to maintain and extend
👨‍💻 Author

Karan G


---

# 🔥 Important (Graph wala part)

👉 Tu bola tha flow graph daalega — BEST IDEA 💯

## 📌 Add this in README

1. Ek diagram bana (draw.io / Canva)
2. Save kar as:

images/flow.png


3. README me add kar:

```markdown
## 📊 Execution Flow Diagram

![Flow](images/flow.png)

