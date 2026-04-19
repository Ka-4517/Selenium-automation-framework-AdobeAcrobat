package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            ChromeOptions options = new ChromeOptions();

            // 🔥 Chrome profile (OTP avoid)
            options.addArguments("user-data-dir=/Users/karang/selenium-profile");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}