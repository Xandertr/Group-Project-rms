package com.academy.techcenture.step_defs;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    private LoginPage loginPage;
    private WebDriver driver= Driver.getDriver();

    private HomePage homePage;



    @Given("user navigates to Login Page")
    public void user_navigates_to_login_page() {
        loginPage = new LoginPage(driver);
        driver.get(ConfigReader.getProperty("url"));
        loginPage.verifyTitle();
    }

    @When("user enters a valid username {string}")
    public void user_enters_a_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("user enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on the inpatient ward link")
    public void user_clicks_on_the_inpatient_ward_link() {
        loginPage.clickTheSessionLink();
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.login();
    }


    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
       homePage=new HomePage(driver);
        homePage.verifyHomePage();
        homePage.verifyFunctionalities();
    }

    @When("user enters an invalid password {string}")
    public void user_enters_an_invalid_password(String invalidPassword) {
        loginPage.enterInvalidPassword(invalidPassword);

    }

    @Then("user should see an error message {string}")
    public void user_should_see_an_error_message(String errorMessage) {
        loginPage.verifyLoginError(errorMessage);
    }

}
