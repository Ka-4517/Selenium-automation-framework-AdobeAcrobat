package pages;

import base.BaseTest;
import utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    By signInBtn = By.xpath("//button[contains(@class,'profile-comp')]");
    By emailField = By.xpath("//input[@type='email']");
    By continueBtn = By.xpath("//button//span[text()='Continue']/ancestor::button");
    By passwordField = By.id("PasswordPage-PasswordField");


    public void clickSignIn() {
        WaitUtils.waitForClickable(signInBtn).click();
    }

    public void enterEmail(String email) {
        WaitUtils.waitForVisibility(emailField).sendKeys(email);
    }

    public void clickContinue() {

    By continueBtn = By.xpath("//button//span[text()='Continue']/ancestor::button");

    WaitUtils.waitForPageLoad();

    // 🔥 Step 1: wait visibility (not clickable)
    WebElement btn = WaitUtils.waitForVisibility(continueBtn);

    // 🔥 Step 2: scroll
    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", btn);

    WaitUtils.waitForSeconds(1);

    // 🔥 Step 3: try normal click
    try {
        btn.click();
    } catch (Exception e) {

        System.out.println("⚠️ Normal click failed → using JS click");

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", btn);
    }

    // 🔥 Step 4: wait after click
    WaitUtils.waitForPageLoad();
}

    public void enterPassword(String pass) {
        WaitUtils.waitForVisibility(passwordField).sendKeys(pass);
    }
}