package com.academy.techcenture.pages;

import com.academy.techcenture.config.ConfigReader;
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

public class PatientRecordPage {

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(xpath = "(//tr[@class='odd']/td/following-sibling::td)[1]")
    protected WebElement patientRecordTabName;

    @FindBy(xpath = "(//tr[@class='odd']/td/following-sibling::td)[2]")
    protected WebElement patientRecordGender;

    @FindBy(xpath = "(//tr[@class='odd']/td/following-sibling::td)[3]")
    protected WebElement patientRecordAge;
    @FindBy(xpath = "//input[@class='form-control']")
    protected WebElement searchPatientToolBar;
    @FindBy(xpath = "//div[@id='content']/h2")
    protected WebElement findPatientRecordHeader;

    @FindBy(xpath = "//i[@class='icon-home small']")
    protected WebElement homeBtn;

    public PatientRecordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void verifyPatientRecordDetails() {
        Assert.assertTrue(findPatientRecordHeader.isDisplayed());
        List<WebElement> patientRecordHeaders = driver.findElements(By.xpath("//div[@class='DataTables_sort_wrapper']"));
        for (int i = 0; i < patientRecordHeaders.size(); i++) {
            Assert.assertTrue(patientRecordHeaders.get(i).isDisplayed());
        }
    }

    public void sendPatientId() {
        searchPatientToolBar.sendKeys(ConfigReader.getProperty("patientID"));
    }

    public void verifyPatientRecord() throws InterruptedException {
//        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOf(patientRecordGender));
//        wait.until(ExpectedConditions.visibilityOf(patientRecordTabName));
//        wait.until(ExpectedConditions.visibilityOf(patientRecordAge));
        String gender;
        String patientRecordGenderStr = patientRecordGender.getText();
        if(patientRecordGenderStr.equals("M")){
            gender="Male";
        }
        else{
            gender="Female";
        }
        String firstName = ConfigReader.getProperty("givenName");
        String lastName = ConfigReader.getProperty("familyName");
        String FullName=firstName+" "+lastName;
        String patientRecordStr = patientRecordTabName.getText().trim();
        Assert.assertEquals("they do not match",FullName,patientRecordStr);
        String patientRecordAgeStr = patientRecordAge.getText().trim();
        Assert.assertEquals("They do not match",ConfigReader.getProperty("estimateAge"),patientRecordAgeStr);
        Assert.assertEquals("They do not match",ConfigReader.getProperty("gender"),gender);

    }
    public void clickHomebtn(){
        homeBtn.click();
    }


}

