package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getDriver(String browser, boolean mobile) {

        if ("edge".equalsIgnoreCase(browser)) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");

            if (mobile) {
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Galaxy S9");
                options.setExperimentalOption("mobileEmulation", mobileEmulation);
            }

            return new EdgeDriver(options);
        }

        // Default = Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        if (mobile) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone 13");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        }

        return new ChromeDriver(options);
    }
}
