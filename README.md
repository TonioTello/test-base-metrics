# Test-Base-Metrics

Test-Base-Metrics: Test Automation Project with Docker

## Description
This project serves as a Test Automation Project integrating Maven test suite into a continuous integration job via GitHub Actions. The test suite acts as our "system under test".

Focuses on exposing the metrics from the continuous integration suite. Introduces Prometheus, Docker, Docker Compose, bash scripting, and Ngrok to support metrics from GitHub Actions test suite into the local server.

### Test Suite Overview
The test suite covers various features and scenarios, with a focus on timer information. Some of the key features and scenarios include:

- **Applications**
    - *Applicant*
        - Create an application with default values as APPLICANT
        - Create a full application as APPLICANT
        - Create an application with different TypeVehicles (1 example)
    - *Dealer*
        - Create an application with default values as Dealer
        - Create a full application as Dealer
        - Validate JD Power information is preserved
        - Include JD Power Options and update the application
        - Ensure the APPinspector request is sent properly
        - Ensure the APPverify request is sent properly
        - Create an application with different TypeVehicles (1 example)
        - Ensure the APPinsure request is sent properly
        - Ensure the 700credit connect request is sent properly (4 examples)
        - Create a dealer application with payment information (1 example)
        - Create contract using APPproducts
        - Dealer create a lease application with payment information
    - *E2E Flow*
        - Create and approve an application with different TypeVehicles (1 example)
        - Create an application with payment information (1 example)
        - Create an education blog post
    - *Lender*
        - Create an application with default values as LENDER
        - Create a full application as LENDER
        - Create an application with different TypeVehicles (1 example)
        - Ensure the APPinspector request is sent properly as LENDER
        - Fill out the questionnaire for a lender admin
        - Create a lender application with payment information (1 example)
        - Lender create a lease application with payment information
- **Companies**
    - Set a company with a user (2 examples)
    - Create new discount coupon
    - Send APPsign documents from dealer to the applicant
    - Create a new campaign-advertising
    - Create new users as super admin


## Requirements
- JDK 1.8
- Maven
- Docker

```
git clone 
```

## Run the tests
mvn clean verify -Denvironment=qa/uat -D"cucumber.filter.tags"="@applicant_1"

### Run all test
```
mvn clean verify -Denvironment=qa/uat 