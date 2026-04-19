package utils;

import base.BaseTest;
import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils extends BaseTest {

    public static void capture(String name) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" + name + ".png");
            FileUtils.copyFile(src, dest);

            System.out.println("📸 Screenshot saved: " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}