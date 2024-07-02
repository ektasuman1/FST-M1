package projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class Project1 {

    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void googleTasksSetup() throws MalformedURLException {
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
    public void addTasks() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Tasks")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();


        String  listdata1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Tasks\")")).getText();

        String  listdata2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Keep\")")).getText();

        String  listdata3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete the second Activity Google Keep\")")).getText();


        //Assertion

        Assert.assertEquals(listdata1,"Complete Activity with Google Tasks");

        Assert.assertEquals(listdata2,"Complete Activity with Google Keep");

        Assert.assertEquals(listdata3,"Complete the second Activity Google Keep");


    }
}

