# test-base-metrics
test-base-metrics: Test Automation Project with Docker

## Requirements
- JDK 1.8
- Maven

## Download repository
- Clone repository

```
git clone 
```

## Run the tests
mvn clean verify -Denvironment=qa/uat -D"cucumber.filter.tags"="@applicant_1"

### Run all test
```
mvn clean verify -Denvironment=qa/uat 