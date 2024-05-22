import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        String confirm = driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
        System.out.println("Login message: " + confirm);
        driver.close();
    }
}
