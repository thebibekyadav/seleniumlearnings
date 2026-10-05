package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingiFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice-automation.com/iframes/");
        driver.switchTo().frame("iframe-1");

        WebElement docsButton = driver.findElement(By.xpath("//a[text()='Docs']"));
        docsButton.click();

        driver.switchTo().defaultContent();
        WebElement meToo = driver.findElement(By.xpath("//p[text()='Me too!']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",meToo);

        driver.switchTo().frame("iframe-2");
        WebElement downloadButton = driver.findElement(By.xpath("//span[text()='Downloads']"));
        downloadButton.click();
    }
}