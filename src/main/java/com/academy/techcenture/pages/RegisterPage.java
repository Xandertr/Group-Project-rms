package com.academy.techcenture.pages;
import com.academy.techcenture.config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "submit")
    protected WebElement confirmBtn;
    @FindBy(xpath = "//input[@name='givenName']")
    protected WebElement givenNameInput;

    @FindBy(xpath = "//input[@name='familyName']")
    protected WebElement familyNameInput;

    @FindBy(id = "next-button")
    protected WebElement nextBtn;

    @FindBy(xpath = "(//select[@id='gender-field']/option)[1]")
    protected WebElement genderMale;

    @FindBy(xpath = "(//select[@id='gender-field']/option)[2]")
    protected WebElement genderFemale;

    @FindBy(id = "birthdateYears-field")
    protected WebElement birthYearsInput;

    @FindBy(id = "birthdateMonths-field")
    protected WebElement birthMonthInput;

    @FindBy(id = "address1")
    protected WebElement addressInput;

    @FindBy(id = "cityVillage")
    protected WebElement cityInput;

    @FindBy(id = "stateProvince")
    protected WebElement stateInput;

    @FindBy(id = "country")
    protected WebElement countyInput;

    @FindBy(id = "postalCode")
    protected WebElement postalCodeInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    protected WebElement patientNumberInput;

    @FindBy(xpath = "//select[@id='relationship_type']")
    protected WebElement relationshipType;

    @FindBy(xpath = "//input[@placeholder='Person Name']")
    protected WebElement personNameInput;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void verifyTitle() {
        wait.until(ExpectedConditions.titleIs("OpenMRS Electronic Medical Record"));
        Assert.assertTrue("Titles do not match", driver.getTitle().equals("OpenMRS Electronic Medical Record"));
    }


    public void fillOutGivenName(String givenName) {
        givenNameInput.sendKeys(givenName);
        ConfigReader.setProperty("givenName", givenName);


    }

    public void fillOutFamilyName(String familyName) {
        ConfigReader.setProperty("familyName", familyName);
        familyNameInput.sendKeys(familyName);

    }

    public void fillOutGenderInfo(String gender) {
        if (gender.equals("Male")) {
            genderMale.click();
        } else {
            genderFemale.click();
        }
        ConfigReader.setProperty("gender", gender);
    }

    public void fillOutEstimateAge(String estimateAge) {
        birthYearsInput.sendKeys(estimateAge);
        ConfigReader.setProperty("estimateAge", estimateAge);
    }

    public void fillOutEstimateMonths(String estimateMonths) {
        birthMonthInput.sendKeys(estimateMonths);
        ConfigReader.setProperty("estimateMonths", estimateMonths);
    }

    public void fillAddress(String address) {
        addressInput.sendKeys(address);
        ConfigReader.setProperty("address", address);
    }

    public void fillCityInfo(String city) {
        cityInput.sendKeys(city);
        ConfigReader.setProperty("city", city);
    }

    public void fillCountryInfo(String country) {
        countyInput.sendKeys(country);
        ConfigReader.setProperty("country", country);
    }

    public void fillStateInfo(String state) {
        stateInput.sendKeys(state);
        ConfigReader.setProperty("state", state);
    }

    public void fillPostCodeInfo(String postCode) {
        postalCodeInput.sendKeys(postCode);
        ConfigReader.setProperty("postCode", postCode);
    }

    public void fillPatientRelativeInfo(String personName) {
        personNameInput.sendKeys(personName);
        ConfigReader.setProperty("personName", personName);
    }

    public void fillOutPhoneNumber(String phoneNumber) {
        patientNumberInput.sendKeys(phoneNumber);
        ConfigReader.setProperty("phoneNumber", phoneNumber);
    }

    public void selectPatientRelationship(String relationship_type) {

        Select relationship = new Select(relationshipType);
        relationship.selectByVisibleText(relationship_type);
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public String getGivenName() {
        WebElement name = driver.findElement(By.xpath("(//div[@id='dataCanvas']//p)[1]"));
        String result = name.getText();
        int indexOfSemiColon = result.indexOf(":");
        int indexOfComma = result.indexOf(",");
        String givenName = result.substring(indexOfSemiColon + 1, indexOfComma);
        String endresultGivenName = givenName.trim();


        return endresultGivenName;

    }


    public String getFamilyName() {
        WebElement name = driver.findElement(By.xpath("(//div[@id='dataCanvas']//p)[1]"));
        String result = name.getText();
        int indexOfComma = result.indexOf(",");
        String givenName = result.substring(indexOfComma + 1);
        String endresultFamilyName = givenName.trim();

        return endresultFamilyName;


    }

    public String getGender() {
        WebElement genderElement = driver.findElement(By.xpath("(//div[@id='dataCanvas']//p)[2]"));
        String genderText = genderElement.getText();
        int indexOfSemiColon = genderText.indexOf(":");
        String gender = genderText.substring(indexOfSemiColon + 1);
        String trimmedGender = gender.trim();

        return trimmedGender;
    }

    public String getAgeYear() {
        WebElement birthYearElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[3]"));

        String birthYearElementText = birthYearElement.getText();
        int indefOfSemiColon = birthYearElementText.indexOf(":");
        int indexOfY = birthYearElementText.indexOf("y");
        String resultAge = birthYearElementText.substring(indefOfSemiColon + 2, indexOfY - 1);

        return resultAge;
    }

    public String getMonth() {

        WebElement birthMonth = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[3]"));
        String birthMonthText = birthMonth.getText();
        int indexOfComma = birthMonthText.indexOf(",");
        int indexOfmonth = birthMonthText.indexOf("m");
        String result = birthMonthText.substring(indexOfComma + 2, indexOfmonth - 1).trim();


        return result;

    }

    public String getAddressName() {
        WebElement adressElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[4]"));
        String addressText = adressElement.getText();
        int indexOfSemiColon = addressText.indexOf(":");
        int indexOfComma = addressText.indexOf(",");

        String result = addressText.substring(indexOfSemiColon + 2, indexOfComma);

       return result;

    }

    public String getCityName() {
        WebElement cityElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[4]"));
        String cityText = cityElement.getText();
        int indexOfComma = cityText.indexOf(",");
        String citySub = cityText.substring(indexOfComma + 1);
        int indexOFcitySubComma = citySub.indexOf(",");
        String result = citySub.substring(1, indexOFcitySubComma).trim();

       return result;
    }

    public String getStateName() {
        WebElement stateElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[4]"));
        String stateText = stateElement.getText();
        int indexOfComma = stateText.indexOf(",");
        String trimmedStateText = stateText.substring(indexOfComma + 1);
        int secondIndexOfComma = trimmedStateText.indexOf(",");
        String trimmedSecondStateText = trimmedStateText.substring(secondIndexOfComma + 1);
        int thirdIndexOfComma = trimmedSecondStateText.indexOf(",");
        String result = trimmedSecondStateText.substring(0, thirdIndexOfComma).trim();

       return result;
    }

    public String getCountryName() {
        WebElement countryElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[4]"));
        String countryElementText = countryElement.getText();
        int indexOfComma = countryElementText.indexOf(",");
        String trimmedCountryText = countryElementText.substring(indexOfComma + 1);
        int secondIndexOfComma = trimmedCountryText.indexOf(",");
        String trimmedSecondCountryText = trimmedCountryText.substring(secondIndexOfComma + 1);
        int thirdIndexOfComma = trimmedSecondCountryText.indexOf(",");
        String afterStateText = trimmedSecondCountryText.substring(thirdIndexOfComma + 1);
        int indexOfLastComma = afterStateText.indexOf(",");
        String result = afterStateText.substring(0, indexOfLastComma).trim();


        return result;
    }

    public String getPostalcode() {
        WebElement postalCodeElement = driver.findElement(By.xpath("//div[@id='dataCanvas']//p[4]"));
        String postalCodeText = postalCodeElement.getText();
        int indexOfComma = postalCodeText.indexOf(",");
        String trimmedPostalCodeText = postalCodeText.substring(indexOfComma + 1);
        int secondIndexOfComma = trimmedPostalCodeText.indexOf(",");
        String trimmedSecondPostalCodeText = trimmedPostalCodeText.substring(secondIndexOfComma + 1);
        int thirdIndexOfComma = trimmedSecondPostalCodeText.indexOf(",");
        String afterStateText = trimmedSecondPostalCodeText.substring(thirdIndexOfComma + 1);
        int indexOfLastComma = afterStateText.indexOf(",");
        String result = afterStateText.substring(indexOfLastComma + 1).trim();

        return result;
    }
    public void clickConfirmBtn() throws InterruptedException {
        confirmBtn.click();
        Thread.sleep(5000);
    }

    public void verifyConfirmPage(){
       Assert.assertEquals("Given names do not match",ConfigReader.getProperty("givenName"),getGivenName());
       Assert.assertEquals("Family names do not match",ConfigReader.getProperty("familyName"),getFamilyName());
       Assert.assertEquals("Genders do not match",ConfigReader.getProperty("gender"),getGender());
       Assert.assertEquals("Estimate year Age do not matched!",ConfigReader.getProperty("estimateAge"),getAgeYear());
       Assert.assertEquals("Estimate month Age do not matched!",ConfigReader.getProperty("estimateMonths"),getMonth());
       Assert.assertEquals("Address do not matched!",ConfigReader.getProperty("address"),getAddressName());
       Assert.assertEquals("City do not matched!",ConfigReader.getProperty("city"),getCityName());
       Assert.assertEquals("Country do not matched!",ConfigReader.getProperty("country"), getCountryName());
       Assert.assertEquals("State do not matched!",ConfigReader.getProperty("state"), getStateName());
       Assert.assertEquals("Postal code do not matched!",ConfigReader.getProperty("postCode"),getPostalcode());
    }
}
