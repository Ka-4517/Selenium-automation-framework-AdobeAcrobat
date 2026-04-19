package utils;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils extends BaseTest {

    private static WebDriverWait getWait(int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait(15).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getWait(15).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageLoad() {
        getWait(20).until(driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public static void waitForLoaderToDisappear(By locator) {
        try {
            getWait(10).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ignored) {}
        getWait(20).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void scrollToElement(By locator) {
        WebElement el = waitForVisibility(locator);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }
    public static void waitForSeconds(int seconds) {
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}