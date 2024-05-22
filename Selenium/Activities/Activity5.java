import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());

        Actions builder = new Actions(driver);

        builder.click().pause(1000).build().perform();
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        builder.doubleClick().pause(1000).build().perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        builder.contextClick().pause(1000).build().perform();
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        driver.close();
    }}

//Import Action classes

//Initialize Actions Object
