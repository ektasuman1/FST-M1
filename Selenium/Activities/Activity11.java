import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: "+driver.getTitle());

        WebElement checkbox = driver.findElement(By.cssSelector("input.willDisappear"));

        checkbox.click();

        System.out.println("Checkbox is selected"+checkbox.isSelected());

        checkbox.click();

        System.out.println("Checkbox is selected"+checkbox.isSelected());

        driver.close();
    }
}
