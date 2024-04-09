@companies @superAdmin
Feature: Companies

  @companies_1 @smoke @smoke3  @smoke_01
  Scenario Outline: Set a company with a user
    Given the super admin is logged at Appmoto home page
    And the super admin has a new company created type "<TypeCompany>"
    And the company created has a new branch and store-queue
    When the super admin search for the company and select its branch and store-queue
#    Then the super admin can complete the company setting adding a new user
#    And the super admin can see the new user on the list

    Examples:
      | TypeCompany |
      | Dealer      |
      #| Lender      |

#  @companies_2
#  Scenario: New relationship from lender to dealer
#    Given the lender is logged at Appmoto home page to send a request
#    And the lender sent a new relationship request to the dealer
#    When the dealer open the request from the lender
#    And the dealer accept the new relationship request
#    Then the dealer should see a successful message notification
#
#  @companies_3
#  Scenario: New relationship from dealer to lender
#    Given the dealer is logged at Appmoto home page to send a request
#    And the dealer sent a new relationship request to the lender
#    When the lender open the request from the lender
#    And the lender accept the new relationship request
#    Then the lender should see a successful message notification

#  @companies_4 @smoke
#  Scenario Outline: Choose a plan for a new company
#    Given a new user wants to create a company type "<TypeCompany>"
#    When the new user selects the plan and fill out the company info
#    And the new user completes the email confirmation
#    And the new user actives the company with new credentials
#    Then the new user can log in at the Appmoto home page
#    #And the new user can pay for plan selected

    Examples:
      | TypeCompany |
      | Dealer      |
      #| Lender      |

  @companies_5
  Scenario: Create new discount coupon
    Given the super admin is logged at Appmoto home page
    When the super admin submits all the coupon information
    Then the super admin see a message notification
    And the super admin see that a new coupon has been created

#  @companies_6 @smoke @smoke4
#  Scenario: Validate a discount is applied correctly
#    Given the super admin has created a 100% discount coupon
#    And a new daler company and store are created
#    When the store get additional credits to use integrations
#    And the dealer applies the 100%  discount coupon
#    Then the dealer can use the integrations functionalities

  @companies_7 @smoke @smoke_01
  Scenario: Send APPsign documents from dealer to the applicant
    Given the applicant has created a full application
    And the super admin makes the dealer's documentation available
#    When the dealer chooses the documents for the applicant
#    Then the dealer see the E-sign Documents status as sent
#    And the applicant receives the Documents via email

  @companies_8
  Scenario: Create a new campaign-advertising
    Given the super admin is logged at Appmoto home page
    When the super admin submits all the advertising information
    Then the super admin see a successful message notification
    And the super admin see that the advertising has been created
   # And the applicant should notice the advertising at the top of the page

#  @companies_10
#  Scenario: Create a recovery password request to get a new one
#    Given the user is on the Appmoto login page
#    When the user set up the "<Email>" to recover the password
#    And the user receives the link to set up a new password
#    Then the user can log in on the Appmoto home page with the new password

  @companies_11
  Scenario: Create new users as super admin
    Given the super admin is logged at Appmoto home page
#    When the super admin submits all new user information
#    #Then the super admin see a message notification
#    And the super admin see that a new user has been created