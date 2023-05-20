@regression
Feature:Register Feature

  Scenario Outline: Successful register
    Given user navigates to Login Page
    When user enters a valid username "Admin"
    And user enters a valid password "Admin123"
    And user clicks on the inpatient ward link
    And user clicks on the login button
    And user should be logged in successfully
    And user clicks on register a patient tab
    And user is on register page
    And user enters "<given_name>" in the firstname input
    And user enters "<family_name>" in the lastname input
    And user checks "<gender>" checkbox
    And user enters "<estimate_year>" in the email input
    And user enters "<estimate_months>" in the password input
    And user enters "<address>" in the confirm_password input
    And user enters "<city>" in the password input
    And user enters "<state>" in the confirm_password input
    And user enters "<country>" in the confirm_password input
    And user enters "<postCode>" in the confirm_password input
    And user enters "<phone_number>" in the confirm_password input
    And user enters "<relationship_type>" in the confirm_password input
    And user enters "<person_name>" in the confirm_password input
    When user clicks on the create account button
    Then user should be registered successful and be navigated to my account page


    Examples:
      |given_name | family_name |gender   | estimate_year    | estimate_months   | address  | city | state |country | postCode | phone_number| relationship_type | person_name |
      |Bob        | Peterson  |    yes       |bob.f34dfq45@yahoo.com   | Bob.pete123! | Bob.pete123!      |