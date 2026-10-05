package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingPaginationTable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement paginationWebTable = driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", paginationWebTable);

        for (int page = 1; page <= 4; page++) {

            WebElement currentPage = driver.findElement(By.xpath("//a[text()='" + page + "']"));
            currentPage.click();

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

            for (WebElement row : rows) {

                String name = row.findElement(By.xpath("./td[2]")).getText();

                if (name.equals("Router")) {
                    System.out.println("Router found on page " + page);
                }
            }
        }
    }
}