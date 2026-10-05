package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFileUploads {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement uploadFiles = driver.findElement(By.xpath("//h2[text()='Upload Files']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", uploadFiles);

        WebElement chooseFileButton = driver.findElement(By.id("singleFileInput"));
        chooseFileButton.sendKeys("C:\\Users\\Bibek Yadav\\Downloads\\krishna.png");

        WebElement fileUploadButton = driver.findElement(By.xpath("//button[text()='Upload Single File']"));
        fileUploadButton.click();
    }
}
