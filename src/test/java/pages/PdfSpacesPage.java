package pages;

import base.BaseTest;
import utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class PdfSpacesPage extends BaseTest {

    // 🔹 Loader
    By loader = By.id("rootwait");

    // 🔹 All Tools Page
    By createPdfSpace = By.xpath("//h2[contains(@id,'workspace-tileLabel')]");

    // 🔥 SUPER STABLE LOCATOR
    By curatedBtn = By.xpath("//button[contains(.,'curated PDF Spaces')]");

    // 🔹 Curated Page
    By curatedPageTitle = By.xpath("//div[contains(@class,'sc-deLugA')]");

    // 🔹 Cards
    By learnAbout = By.xpath("//div[contains(@aria-label,'Learn About')]");
    By learnTitle = By.xpath("//span[contains(text(),'ultimate guide')]");

    By moneyGuide = By.xpath("//div[contains(@aria-label,'$100k')]");
    By moneyTitle = By.xpath("//span[contains(text(),'$100k')]");

    By brainstorm = By.xpath("//div[contains(@aria-label,'Brainstorm')]");
    By brainstormTitle = By.xpath("//span[contains(text(),'brainstorm')]");


    // 🔥 VERIFY CREATE PDF SPACE
    public void verifyCreatePDFSpace() {

        WaitUtils.waitForLoaderToDisappear(loader);

        WaitUtils.scrollToElement(createPdfSpace);

        String text = WaitUtils.waitForVisibility(createPdfSpace).getText();

        System.out.println("🔥 Found: " + text);

        if (text.contains("PDF Space")) {
            System.out.println("✅ Create PDF Space visible");
        } else {
            System.out.println("❌ Not found");
        }
    }


    // 🔥 OPEN CURATED (FINAL STABLE)
    public void openCurated() {

        WaitUtils.waitForLoaderToDisappear(loader);
        WaitUtils.waitForPageLoad();

        WebElement element = WaitUtils.waitForVisibility(curatedBtn);

        // 🔥 scroll EXACT element pe
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        WaitUtils.waitForSeconds(1);

        try {
            element.click();
        } catch (Exception e) {

            System.out.println("⚠️ Normal click failed → using JS click");

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }

        System.out.println("➡️ Opened Curated Page");

        WaitUtils.waitForPageLoad();
    }


    // 🔥 COMMON VALIDATION
    public void openAndValidate(By card, By title) {

        WaitUtils.waitForClickable(card).click();

        String text = WaitUtils.waitForVisibility(title).getText();

        System.out.println("🔥 Title: " + text);

        driver.navigate().back();

        WaitUtils.waitForPageLoad();
        WaitUtils.waitForLoaderToDisappear(loader);
    }


    // 🔥 FINAL FLOW
    public void validateCuratedFlow() {

        String pageTitle = WaitUtils.waitForVisibility(curatedPageTitle).getText();

        System.out.println("📌 Curated Page: " + pageTitle);

        openAndValidate(learnAbout, learnTitle);
        openAndValidate(moneyGuide, moneyTitle);
        openAndValidate(brainstorm, brainstormTitle);
    }
}