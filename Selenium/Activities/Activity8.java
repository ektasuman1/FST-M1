import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());

        WebElement toggleCheckbox = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        toggleCheckbox.click();
        System.out.println("Clicked on toggle button to Disappear");

        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        toggleCheckbox.click();
        System.out.println("Clicked on toggle button to Appeared");

        checkbox.click();
        driver.close();
    }
}