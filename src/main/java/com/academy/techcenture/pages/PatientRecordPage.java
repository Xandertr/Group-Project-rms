package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PatientRecordPage {

    private WebDriver driver;

    private WebDriverWait wait;

    private PatientDetailsPage patientDetailsPage;

    @FindBy(xpath = "//input[@class='form-control']")
    protected WebElement searchPatientToolBar;
    @FindBy(xpath = "//div[@id='content']/h2")
    protected WebElement findPatientRecordHeader;

    public PatientRecordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void verifyPatientRecordDetails(){
        Assert.assertTrue(findPatientRecordHeader.isDisplayed());
        List<WebElement> patientRecordHeaders = driver.findElements(By.xpath("//div[@class='DataTables_sort_wrapper']"));
        for (int i = 0; i < patientRecordHeaders.size() ; i++) {
            Assert.assertTrue(patientRecordHeaders.get(i).isDisplayed());
        }
    }

    public void searchForPatient(){
        patientDetailsPage=new PatientDetailsPage(driver);
        searchPatientToolBar.sendKeys(patientDetailsPage.getPatientId());
        searchPatientToolBar.click();

    }

}
