package genralized_utillity.Screenshot;

import BaseUtility.MobileBaseUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
----> This function used to capture screenshot
 */

public class Screenshot extends MobileBaseUtility {

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

        String dateName = new SimpleDateFormat("yyyy-MM-dd::hh-mm").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots"
        // under src/android folder
        String destination = System.getProperty("user.dir") + "FailedTestsScreenshots/" + screenshotName + "_" + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
