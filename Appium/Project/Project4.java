package projects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Project4
{
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void asetUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://127.0.0.1:4723/");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Open the page in Chrome
        driver.get("https://v1.training-support.net/selenium");
    }


    @Test
    public void bscrollIntoViewTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to loadH
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.webkit.WebView")));

        // Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();


//        Assertion
        String firstText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).getText();
        Assert.assertEquals(firstText,"Add tasks to list");

        String secondText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).getText();
        Assert.assertEquals(secondText,"Get number of tasks");

        String thirdText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).getText();
        Assert.assertEquals(thirdText,"Clear the list");


        //Striking
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add tasks to list\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get number of tasks\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Clear the list\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();

    }}