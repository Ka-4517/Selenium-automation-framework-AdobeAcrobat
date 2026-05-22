package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class HomePage {

    By loader = By.id("rootwait");
    By allTools = By.xpath("//span[normalize-space()='All tools']");
    By homeLink = By.xpath("//span[normalize-space()='Home']");
    By profileIcon = By.cssSelector("#profile-thumbnail-id");
    By userEmail = By.cssSelector("p[data-testid='account-menu-header-email']");

    public void clickAllTools() {
        WaitUtils.waitForLoaderToDisappear(loader);
        WaitUtils.waitForPageLoad();
        WaitUtils.waitForClickable(allTools).click();
    }

    public String getHomeText() {
        return WaitUtils.waitForVisibility(homeLink).getText();
    }

    public void openProfile() {
        WaitUtils.waitForClickable(profileIcon).click();
    }

    public String getUserEmail() {
        return WaitUtils.waitForVisibility(userEmail).getText();
    }
}