import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Page title is: "+driver.getTitle());

        WebElement confirm_alert = driver.findElement(By.id("confirm"));
        confirm_alert.click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

//             alert.dismiss();

        driver.close();
}
}
