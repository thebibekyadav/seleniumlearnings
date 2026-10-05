package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDynamicTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/dynamic-table");

        WebElement taskManagerText = driver.findElement(By.xpath("//div[text()='Task Manager']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", taskManagerText);

        List<WebElement> numberOfColumns = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
        System.out.println("Total number of columns: " + numberOfColumns.size());

        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
        System.out.println("Total number of rows: " + numberOfRows.size());

        for (int row = 1; row <= numberOfRows.size(); row++) {
            String rowValue = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + row + "]/td[1]")).getText();
            if (rowValue.equals("Chrome")) {
                String cpuLoadValue = driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::td[contains(text(),'%')]")).getText();
                String yellowColorText = driver.findElement(By.id("chrome-cpu")).getText();

                if (yellowColorText.contains((cpuLoadValue))) {
                    System.out.println("Both have the same CPU Load Value and it is "+cpuLoadValue);
                }
            }
        }
    }
}