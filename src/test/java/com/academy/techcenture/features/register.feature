#Made by Muharrem and Aybars

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
    And user selects "<gender>" from the options
    And user enters "<estimate_Age_year>" age year the input box
    And user enters "<estimate_months>" age month the input box
    And user enters "<address>"  address input
    And user enters "<city>" city input
    And user enters "<state>" state input
    And user enters "<country>"country input
    And user enters "<postCode>" postcode input
    And user enters "<phone_number>"  phone Number information
    And user selects "<relationship_type>" from the dropdown
    And user enters "<relative_person_name>" Relative input
    When user verifies register information and clicks on the confirm button
    Then user should be registered successful and be navigated to patient details page
    Examples:
      | given_name | family_name | gender | estimate_Age_year | estimate_months | address                  | city    | state  | country | postCode | phone_number | relationship_type | relative_person_name |
      | Alex       | Rodriguez   | Male   | 45                | 9               | 145 Washingtonian street | Fairfax | Oregon | Usa     | 221      | 5711231212   | Parent            | Bob scarlet          |
