package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeHandlingAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.automationtesting.in/Frames.html");

        WebElement withinIframe = driver.findElement(By.xpath("//a[@href='#Multiple']"));
        withinIframe.click();

        WebElement innerIframe1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(innerIframe1);

        WebElement innerIframe2 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerIframe2);

        WebElement inputField1 = driver.findElement(By.xpath("//input[@type='text']"));
        inputField1.sendKeys("Broadway Infosys");

        driver.switchTo().defaultContent();

        WebElement singleFrame = driver.findElement(By.xpath("//a[@href='#Single']"));
        singleFrame.click();

        WebElement anotherIframe = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(anotherIframe);

        WebElement inputField2 = driver.findElement(By.xpath("//input[@type='text']"));
        inputField2.sendKeys("Broadway Infosys");
    }
}
