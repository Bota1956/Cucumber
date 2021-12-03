Feature: Testing Bestbuy functionalities
  Scenario: Positive cenerio for Bestbuy search
    Given User navigate to bestbuy.com
    When User search Macbook Air 13
    Then User should get 50 macbooks

