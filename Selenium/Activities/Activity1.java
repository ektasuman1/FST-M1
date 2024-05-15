import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("about-link")).click();
        System.out.print(driver.getTitle());
        driver.close();
    }
}
