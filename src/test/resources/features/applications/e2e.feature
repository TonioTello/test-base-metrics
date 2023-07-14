@e2e
Feature: E2E Flow


  @applicant_4 @smoke_01
  Scenario Outline: Create and approve an application with different TypeVehicles
    Given the applicant is logged at Ottomoto home page
    And the applicant submits the form fields including TypeVehicle "<TypeVehicle>"
    When the dealer claims and sends the new application to the lender
    And the lender approves the new application
    Then the applicant see the new applications approved

    Examples:
      | TypeVehicle  |
#      | Passenger    |
#      | Recreational |
#      | Aircraft     |
      | Boat         |

  @dealer_3 @smoke @smoke3
  Scenario Outline: Create an application with payment information
    Given the dealer has created an application
    And updated it with the payment information "<TypeApplication>" "<LoanTerms>" "<Frequency>" "<InterestRate>" "<CashPrice>" "<DownPayment>" "<ManufacturerRebate>" "<SecurityDeposit>" "<TradeValue>" "<TradePayoff>" "<NetTradeValue>" "<SalesTax>" "<DealerFees>" "<ETRFee>" "<LicenseFee>" "<TitleFees>" "<OtherFee>"
    When the lender claims and set the commission values "<LenderGap>" "<GapCommission>" "<LenderServiceContract>" "<ServiceContractCommission>" "<LenderOther>" "<OtherCommission>" "<DealerGap>" "<DealerWarranty>" "<DealerOther>"
    And the dealer updates his commission values "<LenderGap>" "<GapCommission>" "<LenderServiceContract>" "<ServiceContractCommission>" "<LenderOther>" "<OtherCommission>" "<DealerGap>" "<DealerWarranty>" "<DealerOther>"
    Then the dealer should see that Unpaid Balance and Calculated Payment should be equal to "<UnpaidBalance>" and "<CalculatedPayment>" respectively
    And the Total Check and Amount Financed should be equal to "<TotalCheckLender>" and "<AmountFinancedLender>" respectively

    Examples:
      | TypeApplication | LoanTerms | Frequency | NumberPayments | InterestRate | CashPrice | DownPayment | ManufacturerRebate | SecurityDeposit | TradeValue | TradePayoff | NetTradeValue | SalesTax | DealerFees | ETRFee | LicenseFee | TitleFees | OtherFee | LenderGap | GapCommission | LenderServiceContract | ServiceContractCommission | LenderOther | OtherCommission | DealerGap | DealerWarranty | DealerOther | UnpaidBalance | CalculatedPayment | TotalCheckLender | AmountFinancedLender |
      | Loan            | 60        | Monthly   | 60             | 37           | 50000     | 10000       | 0                  | 500             | 1500       | 500         | 1000          | 2880     | 100        | 200    | 300        | 400       | 500      | 2000      | 200           | 3000                  | 300                       | 700         | 170             | 100       | 200            | 300         | 44804.38      | 1315.07           | 41081.70         | 51104.38             |


#  @dealer_10 @smoke @smoke3 @smoke4
#  Scenario Outline: Create and approve an application with different TypeVehicles
#    Given the dealer is logged at Ottomoto home page
#    And the dealer submits the form fields including TypeVehicle "<TypeVehicle>"
#    When the lender claims the new application from dealer
#    And the lender approves the new application from dealer
#    Then the dealer see the new applications approved
#
#    Examples:
#      | TypeVehicle  |
#      | Passenger    |
# #     | Recreational |
##      | Aircraft     |
##      | Boat         |


  @companies_9
  Scenario: Create a education blog post
    Given the super admin is logged at Ottomoto home page
#    When the super admin submits all the blog post information
#    Then the super admin see a successful message notification
#    And the super admin see that the blog post has been created
#    And the applicant should notice the blog post at the top of the page