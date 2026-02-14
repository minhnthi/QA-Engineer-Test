package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class JobPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.cssSelector("input[data-testid='typeahead-input']");
    By easyApplyFilter = By.id("searchFilter_applyWithLinkedin");
    By easyApplyBtn = By.xpath("//button[contains(@class,'jobs-apply-button')]");

    public JobPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openJobs() {
        driver.get("https://www.linkedin.com/jobs/");
        wait.until(ExpectedConditions.urlContains("/jobs"));
    }

    public void searchJob(String keyword) {

        WebElement jobInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        jobInput.clear();
        jobInput.sendKeys(keyword);
        jobInput.sendKeys(Keys.ENTER);
    }

    public void filterEasyApply() {

        WebElement filter = wait.until(
                ExpectedConditions.elementToBeClickable(easyApplyFilter)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", filter);

        filter.click();
    }

    public void clickEasyApply() {

        wait.until(ExpectedConditions.elementToBeClickable(easyApplyBtn)).click();
    }

}
