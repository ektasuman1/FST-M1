import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Page title is: "+driver.getTitle());

        WebElement dropdown_element = driver.findElement(By.tagName("select"));
        Select dropdown_object = new Select(dropdown_element);

//     Select Element By Visible Text
        dropdown_object.selectByVisibleText("Option 2");
        System.out.println("Selected option"+dropdown_object.getFirstSelectedOption().getText());

//    Select Element By Index
        dropdown_object.selectByIndex(3);
        System.out.println("Selected option"+dropdown_object.getFirstSelectedOption().getText());

//    Select Element By Value
        dropdown_object.selectByValue("4");
        System.out.println("Selected option"+dropdown_object.getFirstSelectedOption().getText());

//    Get all options inside the select as a list
        List<WebElement> all_options = dropdown_object.getOptions();
        for(WebElement option : all_options) {
            System.out.println("Selected option All"+option.getText());
        }
        driver.quit();
    }
}
