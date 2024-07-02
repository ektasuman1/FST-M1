package projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Project3 {
    AndroidDriver driver;
    WebDriverWait wait;
    // Set up method
    @BeforeClass
    public void googleKeepSetup() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");


        // Server Address
        URL serverURL = new URL("http://127.0.0.1:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void addKeeps() throws InterruptedException{
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Keep Notes\"]")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"New text note\"]")).click();

        driver.findElement(AppiumBy.id("editable_title")).sendKeys("NoteOne");

        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Please complete this activity");
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Later today\"]")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(500);
        String checkTime=driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Time reminder Today, 6.00 PM\"]")).getText();
        Assert.assertEquals(checkTime,"Today, 6.00 PM");
   }

}
