@regression
Feature:Register Feature And Verify Patient Details

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
    When user should be registered successful and be navigated to patient details page
    When user is on the patient detail page user should verify all personal information is correct again
    And user should clicks on the sticky note button and write down a note and verifies note has been created
    And user should verify all health related info is displayed
    When user verifies general actions section is displayed user clicks to home button to go back to home page
    And user clicks on patient record tab
    When user is on patient record tab user can verify the title and top elements on the page
    And user can search for personal information by using its patient id
    And user can verify its own results
    Then user can go back to home page and logout



    Examples:
      | given_name | family_name     | gender     | estimate_Age_year | estimate_months | address           | city                    | state                 | country                | postCode               | phone_number                 | relationship_type                     | relative_person_name     |
      |Bob         |Monroe         |Male        |24                 |4                |145                |Fairfax                  |Oregon                 |Usa                     |221                     |571                           |Parent                                 |Bob scarlet               |
