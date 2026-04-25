package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        System.out.println("Browser launched");
    }

    @When("user enters username and password")
    public void user_enters_credentials() {
        loginPage.performLogin();
    }

    @Then("user should be logged in")
    public void user_logged_in() {
        System.out.println("Login completed");
        DriverFactory.quitDriver();
    }
}