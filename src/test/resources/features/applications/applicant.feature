@applications @applicant
Feature: Applications Applicant

  @applicant_1
  Scenario: Create an application with default values as APPLICANT
    Given the applicant is logged at Ottomoto home page
    When the applicant submits only the default values in the form
    Then the applicant see a message notification
    And the applicant see that an application has been created

  @applicant_2
  Scenario: Create a full application as APPLICANT
    Given the applicant is logged at Ottomoto home page
    When the applicant submits all the form fields
    Then the applicant see a message notification
    And the applicant see that an application has been created


  @applicant_3 @smoke3
  Scenario Outline: Create an application with different TypeVehicles
    Given the applicant is logged at Ottomoto home page
    When the applicant submits all the form fields including TypeVehicle "<TypeVehicle>"
    Then the applicant see a message notification
    And the applicant see that an application has been created

    Examples:
      | TypeVehicle  |
      #| Passenger    |
      #| Recreational |
      | Aircraft     |
      | Boat         |




