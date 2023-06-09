@regression
Feature: Open Mrs Login Feature

  Background: Login Background Steps
    Given user navigates to Login Page

  Scenario: Successful login
    When user enters a valid username "Admin"
    And user enters a valid password "Admin123"
    And user clicks on the inpatient ward link
    And user clicks on the login button
    Then user should be logged in successfully



  Scenario: Invalid credentials
    When user enters a valid username "Admin"
    And user enters an invalid password "Admin123234234!"
    And user clicks on the inpatient ward link
    And user clicks on the login button
    Then user should see an error message "Invalid username/password. Please try again."