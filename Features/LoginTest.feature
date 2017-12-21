@test
Feature: Verify Facebook Login

  
  Scenario: Verify I am able to login to facebook
    Given I launch facebook login url
    Then I am on facebook login page
    And I should be able to enter username ans password
    #When I click on "LogIn"
    And I should be able to see Homepage
    When I click on "Navigation toolbar"
    And I click on "Logout"
    Then I am on facebook login page
