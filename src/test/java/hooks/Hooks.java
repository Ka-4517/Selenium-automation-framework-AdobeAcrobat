package hooks;

import io.cucumber.java.*;
import base.BaseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class Hooks extends BaseTest {

    @Before
    public void setup() {

        BaseTest.getDriver();
        System.out.println("🚀 Test Started");
    }

    @After
    public void tearDown(Scenario scenario) {

        // 🔥 Screenshot on failure (Allure + console)
        if (scenario.isFailed()) {

            System.out.println("❌ Test Failed: " + scenario.getName());

            try {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                // 🔥 Attach in Allure Report
                Allure.addAttachment(
                        "Failure Screenshot",
                        new ByteArrayInputStream(screenshot)
                );

                System.out.println("📸 Screenshot attached in Allure");

            } catch (Exception e) {
                System.out.println("⚠️ Screenshot capture failed");
                e.printStackTrace();
            }
        } else {
            System.out.println("✅ Test Passed: " + scenario.getName());
        }

        // 🔥 Close browser
        BaseTest.tearDown();

        System.out.println("🛑 Browser Closed");
    }
}