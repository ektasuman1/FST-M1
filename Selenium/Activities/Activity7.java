import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity7 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());

        Actions builder = new Actions(driver);
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.dragAndDrop(ball,dropzone1).pause(1000).build().perform();

        String verifyDropZone1 = driver.findElement(By.tagName("p")).getText();
        if (verifyDropZone1.equals("Dropped!")){
            System.out.println("Ball entered Dropzone1");
        }

        builder.dragAndDrop(dropzone1,dropzone2).pause(1000).build().perform();

        if (verifyDropZone1.equals("Dropped!")){
            System.out.print("Ball entered Dropzone2");
        }

        driver.close();

    }
}