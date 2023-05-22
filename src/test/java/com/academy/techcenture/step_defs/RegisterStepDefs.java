package com.academy.techcenture.step_defs;

import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.PatientDetailsPage;
import com.academy.techcenture.pages.PatientRecordPage;
import com.academy.techcenture.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class RegisterStepDefs {

    private WebDriver driver = Driver.getDriver();

    private HomePage homePage;

    private RegisterPage registerPage;

    private PatientDetailsPage patientDetailsPage;

    private PatientRecordPage patientRecordPage;
    private String patientGivenName;
    private String patientFamilyName;

    private String patientGender;

    private String patientAgeYear;

    private String patientAgeMonth;

    private String patientAdressName;

    private String patientCityName;

    private String patientStateName;

    private String patientCountryName;

    private String patientPostalCodeName;



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
        patientGivenName = givenName;
    }

    @When("user enters {string} in the lastname input")
    public void user_enters_in_the_lastname_input(String familyName) {
        registerPage.fillOutFamilyName(familyName);
        registerPage.clickNextBtn();
        patientFamilyName =familyName;
    }

    @When("user selects {string} from the options")
    public void user_selects_from_the_options(String gender) {
        registerPage.fillOutGenderInfo(gender);
        registerPage.clickNextBtn();
        patientGender=gender;
    }


    @And("user enters {string} age year the input box")
    public void userEntersAgeYearTheInputBox(String ageYear) {
        registerPage.fillOutEstimateAge(ageYear);
        patientAgeYear=ageYear;
    }

    @And("user enters {string} age month the input box")
    public void userEntersAgeMonthTheInputBox(String month) {
        registerPage.fillOutEstimateMonths(month);
        registerPage.clickNextBtn();
        patientAgeMonth=month;
    }

    @And("user enters {string}  address input")
    public void userEntersAddressInput(String adress) {
        registerPage.fillAdress(adress);
        patientAdressName=adress;
    }

    @And("user enters {string} city input")
    public void userEntersCityInput(String city) {
        registerPage.fillCityInfo(city);
        patientCityName=city;
    }

    @And("user enters {string} state input")
    public void userEntersStateInput(String state) {
        registerPage.fillStateInfo(state);
        patientStateName=state;
    }

    @And("user enters {string}country input")
    public void userEntersCountryInput(String country) {
        registerPage.fillCountryInfo(country);
        patientCountryName=country;
    }


    @And("user enters {string} postcode input")
    public void userEntersPostalcodeInput(String postalCode) {
        registerPage.fillPostCodeInfo(postalCode);
        registerPage.clickNextBtn();
        patientPostalCodeName=postalCode;

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
        RegisterPage.data.get("")
        Assert.assertEquals(patientGivenName,registerPage.getGivenName());
        Assert.assertEquals(patientFamilyName,registerPage.getFamilyName());
        Assert.assertEquals(patientGender,registerPage.getGender());
        Assert.assertEquals("they dont match",patientAgeYear,registerPage.getAgeYear());
        Assert.assertEquals("They dont match",patientAgeMonth,registerPage.getMonth());
        Assert.assertEquals("they dont match",patientAdressName,registerPage.getAddressName());
        Assert.assertEquals("they dont match",patientCityName,registerPage.getCityName());
        Assert.assertEquals("they dont match",patientStateName,registerPage.getStateName());
        Assert.assertEquals("they dont match",patientCountryName,registerPage.getCountryName());
        Assert.assertEquals("they dont match",patientPostalCodeName,registerPage.getPostalcode());
}
    @When("user should be registered successful and be navigated to patient details page")
    public void userShouldBeRegisteredSuccessfulAndBeNavigatedToPatientDetailsPage() throws InterruptedException {
        registerPage.clickConfirmBtn();
    }

    @When("user is on the patient detail page user should verify all personal information is correct again")
    public void userIsOnThePatientDetailPageUserShouldVerifyAllPersonalInformationIsCorrectAgain() {
        patientDetailsPage=new PatientDetailsPage(driver);

        Assert.assertEquals("Patient GivenName do not match",patientGivenName,patientDetailsPage.verifyPatientDetailsGivenName());
        Assert.assertEquals("Patient FamilyName do not match",patientFamilyName,patientDetailsPage.verifyPatientDetailsFamilyName());
        Assert.assertEquals("Patient Gender do not match",patientGender,patientDetailsPage.verifyPatientDetailGender());
        Assert.assertEquals("Patient AgeYear do not match",patientAgeYear,patientDetailsPage.verifyPatientDetailsAgeYear());
    }

    @And("user should clicks on the sticky note button and write down a note and verifies note has been created")
    public void userShouldClicksOnTheStickyNoteButtonAndWriteDownANoteAndVerifiesNoteHasBeenCreated() {
        patientDetailsPage.enterInfoToStickyNote();
        Assert.assertEquals("Text does not Match",patientDetailsPage.randomNote(),patientDetailsPage.getStickyNoteText());
    }

    @And("user should verify all health related info is displayed")
    public void userShouldVerifyAllHealthRelatedInfoIsDisplayed() {
        patientDetailsPage.verifyPatientDetails();
    }

    @When("user verifies general actions section is displayed user clicks to home button to go back to home page")
    public void userVerifiesGeneralActionsSectionIsDisplayedUserClicksToHomeButtonToGoBackToHomePage() {
        patientDetailsPage.verifyGeneralActions();
    }

    @And("user clicks on patient record tab")
    public void userClicksOnPatientRecordTab() throws InterruptedException {
        homePage.clickFindPatientRecord();
        Thread.sleep(10000);
    }

    @When("user is on patient record tab user can verify the title and top elements on the page")
    public void userIsOnPatientRecordTabUserCanVerifyTheTitleAndTopElementsOnThePage() {
        patientRecordPage=new PatientRecordPage(driver);
        patientRecordPage.verifyPatientRecordDetails();
    }

    @And("user can search for personal information by using its patient id")
    public void userCanSearchForPersonalInformationByUsingItsPatientId() throws InterruptedException {
        patientRecordPage.searchForPatient();
        Thread.sleep(5000);
    }

    @And("user can verify its own results")
    public void userCanVerifyItsOwnResults() {
    }

    @Then("user can go back to home page and logout")
    public void userCanGoBackToHomePageAndLogout() {
    }

}

