package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity7 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException{
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
        driver.get("https://v1.training-support.net/selenium/lazy-loading");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void loadTest() throws InterruptedException{
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Lazy Loading\"]")));
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward().getChildByText(className(\"android.widget.Image\"),\"helen\")"));
        List<WebElement> imageAfterScroll = driver.findElements(AppiumBy.xpath("//android.widget.Image"));
        Assert.assertEquals(((List<?>) imageAfterScroll).size(),2);
    }


@AfterClass
public void tearDown(){
    driver.quit();
}
}
