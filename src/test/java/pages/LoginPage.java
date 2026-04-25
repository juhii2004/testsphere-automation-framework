package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Example actions
    public void openWebsite() {
        driver.get("https://example.com");
    }

    public void performLogin() {
        // Example (no real fields on example.com)
        System.out.println("Performing login actions");
    }
}