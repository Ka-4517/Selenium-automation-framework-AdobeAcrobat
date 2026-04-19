package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.*;
import utils.WaitUtils;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    PdfSpacesPage pdfspacePage;

    @Given("user opens application")
    public void openApp() {

        driver = BaseTest.getDriver();
        driver.get("https://acrobat.adobe.com/");
    }

    @When("user logs in")
    public void loginFlow() {

        loginPage = new LoginPage();

        loginPage.clickSignIn();
        loginPage.enterEmail("karangupta+04apr@adobetest.com");
        loginPage.clickContinue();

        loginPage.enterPassword("Tester@123");
WaitUtils.waitForSeconds(1);   // 👈 add this
loginPage.clickContinue();

// 🔥 ADD THIS
WaitUtils.waitForPageLoad();
WaitUtils.waitForSeconds(2);
        loginPage.clickContinue();

        WaitUtils.waitForPageLoad();
    }

    // 🔥 STEP 1
    @Then("user clicks on All Tools")
    public void user_clicks_on_all_tools() {

        homePage = new HomePage();
        homePage.clickAllTools();
    }

    // 🔥 STEP 2
    @Then("user verifies Create PDF Space feature")
    public void user_verifies_create_pdf_space_feature() {

        pdfspacePage = new PdfSpacesPage();
        pdfspacePage.verifyCreatePDFSpace();
    }

    // 🔥 STEP 3
    @Then("user navigates to PDF Spaces")
public void user_navigates_to_pdf_spaces() {

    System.out.println("➡️ Already inside All Tools, skipping navigation");

}

    // 🔥 STEP 4
    @Then("user opens curated section")
    public void user_opens_curated_section() {

        pdfspacePage.openCurated();
    }

    // 🔥 STEP 5
    @Then("user validates curated pdf spaces")
    public void user_validates_curated_pdf_spaces() {

        pdfspacePage.validateCuratedFlow();

        // 🔥 Go back to home (3 times)
        for (int i = 0; i < 3; i++) {
            driver.navigate().back();
            WaitUtils.waitForPageLoad();
        }

        homePage.verifyHomePage();
    }

    // 🔥 STEP 6
    @Then("user verifies profile email")
    public void user_verifies_profile_email() {

        homePage.openProfile();
        String email = homePage.getUserEmail();

        System.out.println("👤 User Email: " + email);
    }
}