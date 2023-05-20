package com.academy.techcenture.pages;

import com.academy.techcenture.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//input[@id='username']")
    protected WebElement userNameInput;

    @FindBy(xpath ="//input[@id='password']")
    protected WebElement passwordInput;

    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    protected WebElement inpatientWardSelection;
    @FindBy(id="loginButton")
    protected WebElement loginBtn;

    @FindBy(id="error-message")
    protected WebElement errorMsg;

    public void verifyTitle(){
        Assert.assertEquals("LoginPage Title Does not Match.","Login",driver.getTitle());
    }

    public void enterUsername(String username){
        userNameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void enterInvalidPassword(String invalidPassword){
        passwordInput.sendKeys(invalidPassword);
    }

    public void clickTheSessionLink(){
        inpatientWardSelection.click();
    }

    public void login(){
        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();
    }
    public void verifyLoginError(String errorMessage){
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().trim().equals(errorMessage));

    }



}
