package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingProgressBar {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/progress-bar");

        WebElement startButton = explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Start']")));
        startButton.click();

        WebElement resetButton = explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Reset']")));
        resetButton.click();
    }
}
