package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingAlerts {
    WebDriver driver;

    public static void main(String[] args) {
        HandlingAlerts alerts = new HandlingAlerts();
        alerts.setUp();
        alerts.simpleAlert();
        alerts.confirmationAlert();
        alerts.promptAlert();
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    public void simpleAlert() {
        WebElement simpleAlert = driver.findElement(By.xpath("//button[text()='Simple Alert']"));
        simpleAlert.click();

        driver.switchTo().alert().accept();
    }

    public void confirmationAlert() {
        WebElement confAlert = driver.findElement(By.xpath("//button[text()='Confirmation Alert']"));
        confAlert.click();

        driver.switchTo().alert().dismiss();
    }

    public void promptAlert() {
        WebElement prmptAlrt = driver.findElement(By.xpath("//button[text()='Prompt Alert']"));
        prmptAlrt.click();

        driver.switchTo().alert().sendKeys("Bibek");
        driver.switchTo().alert().accept();
    }
}
