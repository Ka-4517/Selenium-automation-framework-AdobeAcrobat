package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import base.BaseTest;

import java.time.Duration;

public class WaitUtils {

    private static final int SHORT_WAIT = 10;
    private static final int MEDIUM_WAIT = 15;
    private static final int LONG_WAIT = 20;

    private static WebDriverWait getWait(int sec) {
        return new WebDriverWait(BaseTest.driver, Duration.ofSeconds(sec));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait(MEDIUM_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait(MEDIUM_WAIT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageLoad() {
        getWait(LONG_WAIT).until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public static void waitForLoaderToDisappear(By locator) {
        try {
            getWait(SHORT_WAIT)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ignored) {}

        getWait(LONG_WAIT)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void scrollToElement(By locator) {
        WebElement el = waitForVisibility(locator);
        ((JavascriptExecutor) BaseTest.driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) {}
    }
}