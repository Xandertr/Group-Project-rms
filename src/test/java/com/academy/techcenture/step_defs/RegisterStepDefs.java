package com.academy.techcenture.step_defs;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.PatientDetailsPage;
import com.academy.techcenture.pages.PatientRecordPage;
import com.academy.techcenture.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class RegisterStepDefs {

    private WebDriver driver = Driver.getDriver();

    private HomePage homePage;

    private RegisterPage registerPage;

    private PatientDetailsPage patientDetailsPage;

    private PatientRecordPage patientRecordPage;



    @When("user clicks on register a patient tab")
    public void user_clicks_on_register_a_patient_tab() {
        homePage = new HomePage(driver);
        homePage.clickRegisterApatient();
    }

    @When("user is on register page")
    public void user_is_on_register_page() {
        registerPage = new RegisterPage(driver);
        registerPage.verifyTitle();
    }

    @When("user enters {string} in the firstname input")
    public void user_enters_in_the_firstname_input(String givenName) {
        registerPage.fillOutGivenName(givenName);
    }

    @When("user enters {string} in the lastname input")
    public void user_enters_in_the_lastname_input(String familyName) {
        registerPage.fillOutFamilyName(familyName);
        registerPage.clickNextBtn();
    }

    @When("user selects {string} from the options")
    public void user_selects_from_the_options(String gender) {
        registerPage.fillOutGenderInfo(gender);
        registerPage.clickNextBtn();
    }


    @And("user enters {string} age year the input box")
    public void userEntersAgeYearTheInputBox(String ageYear) {
        registerPage.fillOutEstimateAge(ageYear);
    }

    @And("user enters {string} age month the input box")
    public void userEntersAgeMonthTheInputBox(String month) {
        registerPage.fillOutEstimateMonths(month);
        registerPage.clickNextBtn();
    }

    @And("user enters {string}  address input")
    public void userEntersAddressInput(String adress) {
        registerPage.fillAddress(adress);
    }

    @And("user enters {string} city input")
    public void userEntersCityInput(String city) {
        registerPage.fillCityInfo(city);
    }

    @And("user enters {string} state input")
    public void userEntersStateInput(String state) {
        registerPage.fillStateInfo(state);

    }

    @And("user enters {string}country input")
    public void userEntersCountryInput(String country) {
        registerPage.fillCountryInfo(country);

    }


    @And("user enters {string} postcode input")
    public void userEntersPostalcodeInput(String postalCode) {
        registerPage.fillPostCodeInfo(postalCode);
        registerPage.clickNextBtn();


    }

    @And("user enters {string}  phone Number information")
    public void userEntersPhoneNumberInformation(String phoneNumber) {
        registerPage.fillOutPhoneNumber(phoneNumber);
        registerPage.clickNextBtn();
    }

    @When("user selects {string} from the dropdown")
    public void user_selects_relationship_type_from_the_dropdown(String relationship) {
        registerPage.selectPatientRelationship(relationship);
    }

    @And("user enters {string} Relative input")
    public void userEntersRelativeInput(String relativeName) {
        registerPage.fillPatientRelativeInfo(relativeName);
        registerPage.clickNextBtn();
    }

    @When("user verifies register information and clicks on the confirm button")
    public void user_verifies_register_information_and_clicks_on_the_confirm_button() {

        registerPage.verifyConfirmPage();
    }

    @When("user should be registered successful and be navigated to patient details page")
    public void userShouldBeRegisteredSuccessfulAndBeNavigatedToPatientDetailsPage() throws InterruptedException {
        registerPage.clickConfirmBtn();
    }

    @When("user is on the patient detail page user should verify all personal information is correct again")
    public void userIsOnThePatientDetailPageUserShouldVerifyAllPersonalInformationIsCorrectAgain() {
        patientDetailsPage = new PatientDetailsPage(driver);
//        patientDetailsPage.verifyPatientRegisterToolTip();
        patientDetailsPage.verifyPatientDetails();
    }

    @And("user should clicks on the sticky note button and write down a note and verifies note has been created")
    public void userShouldClicksOnTheStickyNoteButtonAndWriteDownANoteAndVerifiesNoteHasBeenCreated() {
        patientDetailsPage.enterInfoToStickyNote();
        patientDetailsPage.verifyStickyNote();
    }

    @And("user should verify all health related info is displayed")
    public void userShouldVerifyAllHealthRelatedInfoIsDisplayed() {
        patientDetailsPage.verifyPatientDetailHeader();
        patientDetailsPage.getPatientId();
    }

    @When("user verifies general actions section is displayed user clicks to home button to go back to home page")
    public void userVerifiesGeneralActionsSectionIsDisplayedUserClicksToHomeButtonToGoBackToHomePage() {
        patientDetailsPage.verifyGeneralActions();
    }

    @And("user clicks on patient record tab")
    public void userClicksOnPatientRecordTab() throws InterruptedException {
        homePage.clickFindPatientRecord();
        Thread.sleep(2000);
    }

    @When("user is on patient record tab user can verify the title and top elements on the page")
    public void userIsOnPatientRecordTabUserCanVerifyTheTitleAndTopElementsOnThePage() {
        patientRecordPage = new PatientRecordPage(driver);
        patientRecordPage.verifyPatientRecordDetails();
    }

    @And("user can search for personal information by using its patient id")
    public void userCanSearchForPersonalInformationByUsingItsPatientId() {
       patientRecordPage.sendPatientId();
    }

    @And("user can verify its own results")
    public void userCanVerifyItsOwnResults() throws InterruptedException {
        patientRecordPage.verifyPatientRecord();

    }

    @Then("user can go back to home page and logout")
    public void userCanGoBackToHomePageAndLogout() throws InterruptedException {
        Thread.sleep(5000);
        patientRecordPage.clickHomebtn();
    }

}
