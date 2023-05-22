package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PatientDetailsPage {

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    protected WebElement patientId;
    @FindBy(xpath = "//i[@class='icon-home small']")
    protected WebElement homePageBtn;
    @FindBy(xpath = "//ul[@class='float-left']/h3")
    protected WebElement generalActionsHeader;

    @FindBy(xpath = "//pre[@class='preformatted-note ng-binding']")
    protected WebElement stickyNoteDetails;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    protected WebElement stickNoteSubmitbtn;
    @FindBy(xpath = "//i[@class='icon-sticky-note']")
    protected WebElement stickyNoteBtn;

    @FindBy(xpath = "//textarea[@placeholder='Enter a note']")
    protected WebElement stickNoteInput;

    public PatientDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }


    public String verifyPatientDetailsGivenName() {
        WebElement givenNameElement = driver.findElement(By.xpath("//span[@class='PersonName-givenName']"));
        String givenNameElementText = givenNameElement.getText();
        return givenNameElementText.trim();

    }

    public String verifyPatientDetailsFamilyName() {
        WebElement familyNameElement = driver.findElement(By.xpath("//span[@class='PersonName-familyName']\n"));
        String familyNameElementText = familyNameElement.getText();
        return familyNameElementText.trim();
    }

    public String verifyPatientDetailGender() {
        WebElement genderElement = driver.findElement(By.xpath("//div[@class='gender-age col-auto']/span[1]"));
        String result = genderElement.getText().trim();
        return result;
    }

    public String verifyPatientDetailsAgeYear() {
        WebElement ageElement = driver.findElement(By.xpath("//div[@class='gender-age col-auto']/span[2]"));
        String ageElementText = ageElement.getText();
        int indexOfY = ageElementText.indexOf("y");
        String result = ageElementText.substring(0, indexOfY - 1).trim();
        return result;
    }

    public String randomNote() {
        return "Patient info succesfully generated";
    }

    public void enterInfoToStickyNote() {
        stickyNoteBtn.click();
        stickNoteInput.sendKeys(randomNote());
        stickNoteSubmitbtn.click();
    }

    public String getStickyNoteText() {
        return stickyNoteDetails.getText();
    }

    public String getPatientId(){
        wait.until(ExpectedConditions.visibilityOf(patientId));
        return patientId.getText().trim();
    }

    public void verifyPatientDetails() {
        List<WebElement> patientHeaders = driver.findElements(By.xpath("//div[@class='info-header']"));

        for (int i = 0; i < patientHeaders.size(); i++) {
            Assert.assertTrue(patientHeaders.get(i).isDisplayed());
        }

    }
    public void verifyGeneralActions() {

        Assert.assertTrue(generalActionsHeader.isDisplayed());
        List<WebElement> generalSectionDetails = driver.findElements(By.xpath("//li[@class='float-left']"));

        for (int i = 0; i < generalSectionDetails.size(); i++) {
            Assert.assertTrue(generalSectionDetails.get(i).isDisplayed());
        }
        homePageBtn.click();

    }
}
