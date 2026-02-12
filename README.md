# Selenium + Serenity BDD + Cucumber (Page Object Model)

This project is a complete beginner-friendly example of **Selenium + Serenity BDD** automation with:

- Java (LTS target set to Java 21)
- Maven
- Serenity BDD
- Serenity Cucumber
- Selenium WebDriver
- JUnit (through Serenity's Cucumber runner)
- Page Object Model (not Screenplay)

---

## 1) Step-by-step setup instructions

1. **Install Java** (JDK 21 or newer).
   - Verify with:
     ```bash
     java -version
     ```

2. **Install Maven**.
   - Verify with:
     ```bash
     mvn -version
     ```

3. **Clone or open this project folder**.

4. **Understand driver setup**.
   - This project uses `WebDriverManager` in a Cucumber `@Before` hook (`WebDriverHooks.java`) so you do not manually download ChromeDriver.

5. **Run the suite**.
   ```bash
   mvn clean verify
   ```

6. **Open Serenity report** after execution:
   - Main report file:
     ```
     target/site/serenity/index.html
     ```

---

## 2) Project folder structure

```text
selenium-serenity/
├── pom.xml
├── serenity.conf
├── README.md
└── src/
    └── test/
        ├── java/
        │   └── com/example/serenitybdd/
        │       ├── pages/
        │       │   └── ChatPage.java
        │       ├── runners/
        │       │   └── ChatCtaFrequencyRunner.java
        │       ├── stepdefinitions/
        │       │   ├── ChatStepDefinitions.java
        │       │   └── WebDriverHooks.java
        │       └── steps/
        │           └── ChatSteps.java
        └── resources/
            └── features/
                └── chat_cta_frequency.feature
```

---

## 3) BDD flow in this project

- Feature file defines scenario steps.
- Runner executes feature with Serenity Cucumber.
- Step Definitions map Gherkin steps to Java methods.
- Steps class keeps test actions readable and report-friendly.
- Page Object contains locators, explicit waits, and interactions.

---

## 4) Test case implemented (exact requested scenario)

```gherkin
Feature: Chat CTA Frequency

  Scenario: Frequency of "Get Your Personal Offer" CTA
    Given the user navigates to "https://chatdemo.testenv.impel.io/#teststatic=cae-420"
    And the user clicks the chat icon using xpath "//button[@class='_chatEntryButton_fl156_1']"
```

Automation behavior:
- Opens URL.
- Waits until chat icon is clickable (explicit wait via `WebDriverWait`).
- Clicks icon.
- Verifies a likely chat-open indicator if possible.
- Includes a TODO fallback assertion strategy if stable element differs in your environment.

---

## 5) Commands to run

### Run tests + build Serenity report

```bash
mvn clean verify
```

### Open the report

```bash
# Linux/macOS
xdg-open target/site/serenity/index.html 2>/dev/null || open target/site/serenity/index.html
```

(You can also open the file directly from your IDE/file explorer.)

---

## 6) Notes for beginners

1. **Do not use `Thread.sleep()`** for synchronization.
   - Use explicit waits (`WebDriverWait`) as done in `ChatPage.java`.

2. **If test fails because of locator changes**:
   - Re-check the chat icon XPath in browser DevTools.
   - Update the locator in feature step input or page object methods.

3. **If browser does not start**:
   - Ensure Chrome is installed.
   - Re-run once so `WebDriverManager` can resolve driver.

4. **If site is slow/intermittent**:
   - Increase wait times in `ChatPage.java`.
   - Check network/VPN/firewall constraints.

5. **Debugging tips**:
   - Re-run with Maven debug logs:
     ```bash
     mvn clean verify -X
     ```
   - Inspect Serenity report screenshots and step details.

6. **Where assertions live**:
   - Current assertion is in `ChatStepDefinitions.java` after the click action.
   - Improve assertion by replacing TODO with a stable DOM element once confirmed.
