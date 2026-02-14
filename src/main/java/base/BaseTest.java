package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser", "mobile"})
    @BeforeMethod
    public void setup(
            @Optional("chrome") String browser,
            @Optional("false") String mobile) {

        boolean isMobile = Boolean.parseBoolean(mobile);

        System.out.println("Running on: " + browser +
                " | Mobile: " + isMobile);

        driver = DriverFactory.getDriver(browser, isMobile);

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        if (!isMobile) {
            driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
