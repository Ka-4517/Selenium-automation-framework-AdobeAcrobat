package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class LoginPage {

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
        WaitUtils.waitForClickable(continueBtn).click();
        WaitUtils.waitForSeconds(2);
    }

    public void enterPassword(String pass) {
        WaitUtils.waitForVisibility(passwordField).sendKeys(pass);
    }
}