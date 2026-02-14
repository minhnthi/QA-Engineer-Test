package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By emailInput = By.id("username");
    By passwordInput = By.id("password");
    By signInBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
        driver.get("https://www.linkedin.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
    }

    public void login(String email, String password) {

        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(signInBtn).click();
    }

}
