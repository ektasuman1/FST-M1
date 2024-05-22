//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class Activity13 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title : "+driver.getTitle());

        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'striped')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

        List<WebElement> thirdRowData = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        System.out.println("Third Row Data: ");
         for(WebElement data:thirdRowData){
             System.out.println(data.getText());
         }

        WebElement secondRowSecondData =  driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row second data: "+secondRowSecondData.getText());

        driver.close();
    }
}