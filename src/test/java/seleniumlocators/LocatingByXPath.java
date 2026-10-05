package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// Using Absolute/Full XPath

public class LocatingByXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/input"));
        loginButton.click();
    }
}
