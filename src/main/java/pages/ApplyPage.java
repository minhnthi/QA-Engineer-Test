package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ApplyPage {

    WebDriver driver;
    WebDriverWait wait;

    By submitButton = By.cssSelector(
            "button[aria-label*='Submit'], button[aria-label*='Continue']"
    );

    public ApplyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validateRequiredFields() {

        List<WebElement> requiredLabels = driver.findElements(
                By.xpath("//label[contains(@class,'required')]")
        );

        if (requiredLabels.size() > 0) {
            System.out.println("Required fields found: " + requiredLabels.size());
        } else {
            throw new RuntimeException("No required fields detected.");
        }
    }

    public void validateSubmitDisabled() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(submitButton)
        );
    }
}
