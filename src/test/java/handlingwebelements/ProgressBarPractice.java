package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/progress-bar");

        WebElement startButton = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startStopButton")));
        startButton.click();

        ewait.until(driver1 -> {

            WebElement progressBar = driver1.findElement(By.xpath("//div[@role='progressbar']"));

            String percentage = progressBar.getAttribute("aria-valuenow");

            return Integer.parseInt(percentage) >= 50;
        });
        startButton.click();
    }
}