package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.*;
import utils.WaitUtils;
import utils.ConfigReader;
import org.testng.Assert;


public class AdobeE2ESteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    PdfSpacesPage pdfspacePage = new PdfSpacesPage();

    @Given("user opens application")
    public void openApp() {
        BaseTest.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @When("user logs in")
    public void loginFlow() {

        loginPage.clickSignIn();
        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.clickContinue();

        loginPage.enterPassword(ConfigReader.get("password"));
        WaitUtils.waitForSeconds(1);
        loginPage.clickContinue();

        WaitUtils.waitForPageLoad();
    }

    @Then("user clicks on All Tools")
    public void user_clicks_on_all_tools() {
        homePage.clickAllTools();
    }

    @Then("user verifies Create PDF Space feature")
    public void user_verifies_create_pdf_space_feature() {
        String text = pdfspacePage.getCreatePDFSpaceText();
        Assert.assertTrue(
    text.contains(ConfigReader.get("expected.pdfspace")),
    "Create PDF Space not visible"
);
    }

    @Then("user opens curated section")
    public void user_opens_curated_section() {
        pdfspacePage.openCurated();
    }

    @Then("user validates curated pdf spaces")
    public void user_validates_curated_pdf_spaces() {

        Assert.assertTrue(pdfspacePage.getCuratedPageTitle().length() > 0);

        Assert.assertTrue(pdfspacePage.getLearnTitle().length() > 0);
        Assert.assertTrue(pdfspacePage.getMoneyTitle().length() > 0);
        Assert.assertTrue(pdfspacePage.getBrainstormTitle().length() > 0);

        for (int i = 0; i < 3; i++) {
            BaseTest.driver.navigate().back();
            WaitUtils.waitForPageLoad();
        }

        Assert.assertTrue(homePage.getHomeText().contains("Home"));
    }

    @Then("user verifies profile email")
    public void user_verifies_profile_email() {
        homePage.openProfile();
        String email = homePage.getUserEmail();
        Assert.assertEquals(email, ConfigReader.get("email"), "Email mismatch");
    }
}