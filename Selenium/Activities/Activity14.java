//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title : "+driver.getTitle());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of columns: " + cols.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'sortableTable')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());

        WebElement secondRowSecondData =  driver.findElement(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row second data: "+secondRowSecondData.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();

        WebElement againSecondRowSecondData =  driver.findElement(By.xpath("//table[contains(@id,'sortableTable')]/tbody/tr[2]/td[2]"));
        System.out.println("Again Second row second data: "+againSecondRowSecondData.getText());

        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement data:footer){
            System.out.println("Footer Data "+data.getText());
        }
       driver.close();
    }
}