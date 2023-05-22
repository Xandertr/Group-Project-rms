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

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "(//div[@id='content']/div/div/a)[4]")
    protected WebElement registerPatientBtn;

    @FindBy(xpath = "(//div[@id='navbarSupportedContent']/ul/li/i)[1]")
    protected WebElement adminElement;

    @FindBy(xpath = "//div[@id='content']/div/div/h4")
    protected WebElement superUserHeader;

    @FindBy(xpath = "//div[@id='content']/div[3]/div/a[1]")
    protected WebElement findPatientRecord;

    public void verifyHomePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("HomePage title is not verified", "Home", driver.getTitle());
        Assert.assertTrue(adminElement.isDisplayed());
        Assert.assertTrue(superUserHeader.isDisplayed());

    }

    public void verifyFunctionalities() {
        List<WebElement> functionalities = driver.findElements(By.xpath("//div[@id='content']/div/div/a/i"));
        for (int i = 0; i < functionalities.size(); i++) {
            Assert.assertTrue(functionalities.get(i).isEnabled());
        }
    }
    public void clickRegisterApatient(){
        registerPatientBtn.click();
    }

    public void clickFindPatientRecord(){
        findPatientRecord.click();
    }
}
