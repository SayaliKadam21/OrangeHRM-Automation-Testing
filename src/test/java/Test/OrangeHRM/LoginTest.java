package Test.OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        // Enter username
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.name("username")
            )
        );

        username.sendKeys("Admin");

        // Enter password
        WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.name("password")
            )
        );

        password.sendKeys("admin123");

        // Click Login
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']")
            )
        );

        loginButton.click();

        // Verify dashboard
        WebElement dashboard = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Dashboard']")
            )
        );

        Assert.assertTrue(
            dashboard.isDisplayed(),
            "Dashboard should appear after successful login"
        );
    }
}