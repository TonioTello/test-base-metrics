@applications @dealer
Feature: Applications Dealer

  @dealer_1 @smoke
  Scenario: Create an application with default values as Dealer
    Given the dealer is logged at Ottomoto home page
    When the dealer submits only the default values in the form
    Then the dealer see a successful message notification
    And the dealer see that a new application has been created


  @dealer_2 @smoke
  Scenario: Create a full application as Dealer
    Given the dealer is logged at Ottomoto home page
    When the dealer submits all the form fields
    Then the dealer see a successful message notification
    And the dealer see that a new application has been created


 # @dealer_22 @smoke
#  Scenario: Create and approve an application from DEALER
#    Given the dealer is logged at Ottomoto home page
#    And the dealer submits the all mandatory form fields
#    When the lender claims the new application from dealer
#    And the lender approves the new application from dealer
#    Then the dealer see the new applications approved



#  @dealer_4   #Todo old feature
#  Scenario: Send an application to an unregistered applicant
#    Given the dealer3 is logged at Ottomoto home page
#    And the dealer sent an application to an unregistered applicant
#    When the unregistered applicant receives the application via email or text message
#    And the unregistered applicant accept and submits the form fields
#   Then the dealer is notified by email of the New Application
#    And the dealer open and see the information match with the unregistered applicant

  @dealer_5
  Scenario: Validate JD Power information is preserved.
    Given the dealer is logged at Ottomoto home page
    When the dealer submits the form fields with the JDpower info
    Then the dealer see a successful message notification
    And the dealer see that JD Power values has been saved

  @dealer_6
  Scenario: Include JD Power Options and update the application
    Given  the dealer has created an application with the JDpower info
    When the dealer check all the JD Power options
    And the dealer update the application
    Then the dealer see a successful message notification
    And the dealer see that JD Power values has been update

  @dealer_7 @smoke @smoke3 @smoke_integration
  Scenario: Ensure the OTTOinspector request is sent properly.
    Given the dealer has created a simple application
    And the dealer update the "original" application with the required fields
    When the dealer send the request to OTTOinspector
    Then the dealer see a successful message notification
    And the dealer see that the OTTOinspector status is pending


  @dealer_8 @bug
  Scenario: Ensure the OTTOverify request is sent properly.
    Given the dealer has created a simple application
    And the dealer update the "original" application with the required fields
    When the dealer send the request to OTTOverify
    Then the dealer see a successful message notification
    #And the dealer see that the OTTOverify status is pending


  @dealer_9 @smoke4
  Scenario Outline: Create an application with different TypeVehicles
    Given the dealer is logged at Ottomoto home page
    When the dealer submits all the form fields including TypeVehicle "<TypeVehicle>"
    Then the dealer see a message notification
    And the dealer see that a new application has been created

    Examples:
      | TypeVehicle |
      #| Passenger   |
    # | Recreational |
      | Aircraft     |
     # | Boat         |


  @dealer_11 @smoke @smoke_integration @smoke_01
  Scenario: Ensure the OTTOinsure request is sent properly.
    Given the dealer has created a full application
    When the dealer send the request to OTTOinsure
    Then the dealer see an OTTOinsure successful message notification
    #And the dealer receive an email to continue the process with Gabi


#  @dealer_12  @smoke @smoke3 @smoke4 @smoke_01   #Todo old feature
#  Scenario Outline: Send an application to an unregistered applicant with different TypeVehicles
#    Given the dealer3 is logged at Ottomoto home page
#    And the dealer sent an application to an unregistered applicant
#    When the unregistered applicant receives the application via email or text message
#    And the unregistered applicant submits the form including TypeVehicle "<TypeVehicle>"
#    #Then the dealer is notified by email of the New Application //Todo Review
#    #And the dealer open and see the information match with the unregistered applicant
#
#    Examples:
#      | TypeVehicle  |
#      | Passenger    |
#      #| Recreational |
#      #| Aircraft     |
#      #| Boat         |


  @dealer_13 @smoke @smoke3 @integration @smoke4
  Scenario Outline: Ensure the 700credit connect request is sent properly.
    Given the dealer has created a simple application
    When the dealer send the application details to the company "<Company>"
    Then the dealer see a successful message notification
    And the dealer update the application to make a new 700credit request

    Examples:
      | Company     |
      | RouteOne    |
      | CUDL        |
      | DealerTrack |
      | AppOne      |

  @dealer_14
  Scenario Outline: Create a dealer application with payment information
    Given the dealer has created a simple application
    When the dealer updated it with the payment information "<TypeApplication>" "<LoanTerms>" "<Frequency>" "<InterestRate>" "<CashPrice>" "<DownPayment>" "<ManufacturerRebate>" "<SecurityDeposit>" "<TradeValue>" "<TradePayoff>" "<NetTradeValue>" "<SalesTax>" "<DealerFees>" "<ETRFee>" "<LicenseFee>" "<TitleFees>" "<OtherFee>"
    Then the dealer should see the Unpaid Balance and Calculated Payment
    And the dealer should see the Total Check and Amount Financed

    Examples:
      | TypeApplication | LoanTerms | Frequency | NumberPayments | InterestRate | CashPrice | DownPayment | ManufacturerRebate | SecurityDeposit | TradeValue | TradePayoff | NetTradeValue | SalesTax | DealerFees | ETRFee | LicenseFee | TitleFees | OtherFee | LenderGap | GapCommission | LenderServiceContract | ServiceContractCommission | LenderOther | OtherCommission | DealerGap | DealerWarranty | DealerOther | UnpaidBalance | CalculatedPayment | TotalCheckLender | AmountFinancedLender |
      | Loan            | 60        | Monthly   | 60             | 37           | 50000     | 10000       | 0                  | 500             | 1500       | 500         | 1000          | 2880     | 100        | 200    | 300        | 400       | 500      | 2000      | 200           | 3000                  | 300                       | 700         | 170             | 100       | 200            | 300         | 44804.38      | 1315.07           | 41081.70         | 51104.38             |

  @dealer_15
  Scenario: Create contract using OTTOproducts
    Given the dealer has created a simple application
    And the dealer update the "original" application with the required fields
    When the dealer creates a contract with a product from TPA Alpha Warranty
   # And the dealer  creates a contract with a product from TPA Truwarranty
    Then the dealer see the two contract created


  @dealer_16
  Scenario: Dealer create a lease application with payment information
    Given the dealer has created a simple application type lease
    When the dealer updated the lease application with the payment information
    Then the dealer should see the Unpaid Balance and Calculated Payment
    And the dealer should see the Total Check and Amount Financed
