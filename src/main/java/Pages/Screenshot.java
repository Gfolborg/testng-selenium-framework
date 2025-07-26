package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    WebDriver driver;
    public Screenshot(WebDriver driver){
        this.driver=driver;
    }

    public void screenshotOnFailure(String pageTitle){
        TakesScreenshot sc = (TakesScreenshot) driver;

        File src = sc.getScreenshotAs(OutputType.FILE);


        File folder = new File("screenshot");
        if(!folder.exists()){
            folder.mkdir();
        }
        String fileName = String.format("%sFailedScreenshot.png", pageTitle.replaceAll("[^a-zA-Z0-9]", "_"));

        File dest = new File(folder, fileName);

        try{
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved to:" + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot failed");
            throw new RuntimeException(e);
        }
    }
}
