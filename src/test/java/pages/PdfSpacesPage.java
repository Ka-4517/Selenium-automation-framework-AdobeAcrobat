package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class PdfSpacesPage {

    By loader = By.id("rootwait");

    By createPdfSpace = By.xpath("//h2[contains(@id,'workspace-tileLabel')]");
    By curatedBtn = By.xpath("//button[contains(.,'curated PDF Spaces')]");
    By curatedPageTitle = By.xpath("//div[contains(@class,'sc-deLugA')]");

    By learnAbout = By.xpath("//div[contains(@aria-label,'Learn About')]");
    By learnTitle = By.xpath("//span[contains(text(),'ultimate guide')]");

    By moneyGuide = By.xpath("//div[contains(@aria-label,'$100k')]");
    By moneyTitle = By.xpath("//span[contains(text(),'$100k')]");

    By brainstorm = By.xpath("//div[contains(@aria-label,'Brainstorm')]");
    By brainstormTitle = By.xpath("//span[contains(text(),'brainstorm')]");

    public String getCreatePDFSpaceText() {
        WaitUtils.waitForLoaderToDisappear(loader);
        WaitUtils.scrollToElement(createPdfSpace);
        return WaitUtils.waitForVisibility(createPdfSpace).getText();
    }

    public void openCurated() {
        WaitUtils.waitForLoaderToDisappear(loader);
        WaitUtils.waitForPageLoad();
        WaitUtils.scrollToElement(curatedBtn);
        WaitUtils.waitForClickable(curatedBtn).click();
        WaitUtils.waitForPageLoad();
    }

    public String openAndGetTitle(By card, By title) {
        WaitUtils.waitForClickable(card).click();
        String text = WaitUtils.waitForVisibility(title).getText();
        base.BaseTest.driver.navigate().back();
        WaitUtils.waitForPageLoad();
        WaitUtils.waitForLoaderToDisappear(loader);
        return text;
    }

    public String getCuratedPageTitle() {
        return WaitUtils.waitForVisibility(curatedPageTitle).getText();
    }

    public String getLearnTitle() {
        return openAndGetTitle(learnAbout, learnTitle);
    }

    public String getMoneyTitle() {
        return openAndGetTitle(moneyGuide, moneyTitle);
    }

    public String getBrainstormTitle() {
        return openAndGetTitle(brainstorm, brainstormTitle);
    }
}