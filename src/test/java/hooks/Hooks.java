package hooks;

import io.cucumber.java.*;
import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void setup() {
        BaseTest.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (BaseTest.driver != null && scenario.isFailed()) {

            try {
                byte[] screenshot = ((TakesScreenshot) BaseTest.driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failure Screenshot",
                        new ByteArrayInputStream(screenshot)
                );

            } catch (Exception ignored) {}
        }

        BaseTest.tearDown();
    }
}