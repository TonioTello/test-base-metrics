@applications @lender
Feature: Applications Lender

  @lender_1
  Scenario: Create an application with default values as LENDER
    Given the lender is logged at Ottomoto home page
    When the lender submits only the default values in the form
    Then the lender see a message notification
    And the lender see that an application has been created

  @lender_2
  Scenario: Create a full application as LENDER
    Given the lender is logged at Ottomoto home page
    When the lender submits all the form fields
    Then the lender see a message notification
    And the lender see that an application has been created


  @lender_3 @smoke @smoke3
  Scenario Outline: Create an application with different TypeVehicles
    Given the lender is logged at Ottomoto home page
    When the lender submits all the form fields including TypeVehicle "<TypeVehicle>"
    Then the lender see a message notification
    And the lender see that an application has been created

    Examples:
      | TypeVehicle  |
      | Passenger    |
#      | Recreational |
#      | Aircraft     |
#      | Boat         |

  @lender_4 @smoke @smoke_01
  Scenario: Ensure the OTTOinspector request is sent properly as LENDER.
    Given the lender has created an application
    And the lender update the "original" application with the required fields
    When the lender send the request to OTTOinspector
    Then the lender see a successful message notification
    And the lender see that the OTTOinspector status is pending

  @lender_5
  Scenario: Fill out the questionnaire for a lender admin
    Given the lender is logged at Ottomoto home page
    When the lender submits the configuration questionnaire
    Then the lender see a message notification
    And the lender see that questionnaire has been saved

  @lender_6
  Scenario Outline: Create a lender application with payment information
    Given the lender has created a full application
    When the lender updated it with the payment information "<TypeApplication>" "<LoanTerms>" "<Frequency>" "<InterestRate>" "<CashPrice>" "<DownPayment>" "<ManufacturerRebate>" "<SecurityDeposit>" "<TradeValue>" "<TradePayoff>" "<NetTradeValue>" "<SalesTax>" "<DealerFees>" "<ETRFee>" "<LicenseFee>" "<TitleFees>" "<OtherFee>"
    Then the lender should see the Unpaid Balance and Calculated Payment
    And the lender should see the Total Check and Amount Financed

    Examples:
      | TypeApplication | LoanTerms | Frequency | NumberPayments | InterestRate | CashPrice | DownPayment | ManufacturerRebate | SecurityDeposit | TradeValue | TradePayoff | NetTradeValue | SalesTax | DealerFees | ETRFee | LicenseFee | TitleFees | OtherFee | LenderGap | GapCommission | LenderServiceContract | ServiceContractCommission | LenderOther | OtherCommission | DealerGap | DealerWarranty | DealerOther | UnpaidBalance | CalculatedPayment | TotalCheckLender | AmountFinancedLender |
      | Loan            | 60        | Monthly   | 60             | 37           | 50000     | 10000       | 0                  | 500             | 1500       | 500         | 1000          | 2880     | 100        | 200    | 300        | 400       | 500      | 2000      | 200           | 3000                  | 300                       | 700         | 170             | 100       | 200            | 300         | 44804.38      | 1315.07           | 41081.70         | 51104.38             |

  @lender_7
  Scenario: Lender create a lease application with payment information
    Given the lender has created a simple application type lease
    When the lender updated the lease application with the payment information
    Then the lender should see the Unpaid Balance and Calculated Payment
    And the lender should see the Total Check and Amount Financed