package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatingByRelativeXPath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));

        WebElement password = driver.findElement(By.xpath("//input[contains(@placeholder,'Pas')]"));

//        WebElement loginButton = driver.findElement(By.xpath("//*[@data-test='login-button']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[starts-with(@id,'login')]"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }
}