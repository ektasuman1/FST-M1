import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println(driver.getTitle());

        String thirdHeader = driver.findElement(By.xpath("//h3[@class='ui yellow header']")).getText();
        System.out.println("Third Header: " + thirdHeader);

        String fifthheader = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
        System.out.println("Fifth Header: " + fifthheader);

        String violet_button = driver.findElement(By.className("violet")).getAttribute("class");
        System.out.println("Violet button's classes are: " + violet_button);

        String greytext = driver.findElement(By.className("grey")).getText();
        System.out.println("Grey text: " + greytext);
        driver.close();
    }}