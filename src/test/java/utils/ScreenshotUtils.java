package utils;

import base.BaseTest;
import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils extends BaseTest {

    public static void capture(String name) {

        try {
            // clean name (remove spaces/special chars)
            String cleanName = name.replaceAll("[^a-zA-Z0-9]", "_");

            // timestamp add (avoid overwrite)
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String fileName = cleanName + "_" + time + ".png";

            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdir();
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File dest = new File(folder + "/" + fileName);
            FileUtils.copyFile(src, dest);

            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}