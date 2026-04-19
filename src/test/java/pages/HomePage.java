package pages;

import base.BaseTest;
import utils.WaitUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    By loader = By.id("rootwait");
    By allTools = By.xpath("//span[normalize-space()='All tools']");
    By homeLink = By.xpath("//span[normalize-space()='Home']");
    By profileIcon = By.cssSelector("#profile-thumbnail-id");
    By userEmail = By.cssSelector("p[data-testid='account-menu-header-email']");
    By pdfSpacesHeader = By.xpath("//h2[normalize-space()='PDF Spaces']");

    public void clickAllTools() {

        WaitUtils.waitForLoaderToDisappear(loader);
        WaitUtils.waitForPageLoad();

        WaitUtils.scrollToElement(allTools);
        WaitUtils.waitForClickable(allTools).click();

        System.out.println("✅ Clicked All Tools");
    }

    public void verifyHomePage() {
        String text = WaitUtils.waitForVisibility(homeLink).getText();
        System.out.println("🏠 Landed: " + text);
    }

    public void openProfile() {
        WaitUtils.waitForClickable(profileIcon).click();
    }

    public String getUserEmail() {
        return WaitUtils.waitForVisibility(userEmail).getText();
    }
}