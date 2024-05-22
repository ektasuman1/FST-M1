import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Page title is: "+driver.getTitle());

        WebElement textbox = driver.findElement(By.id("input-text"));

        WebElement textbox_toggle = driver.findElement(By.id("toggleInput"));

        System.out.println("Text box is enabled: "+textbox.isEnabled());

        textbox_toggle.click();

        System.out.println("Text box is enabled: "+textbox.isEnabled());
        textbox.sendKeys("Hello");

        driver.close();
    }
}
