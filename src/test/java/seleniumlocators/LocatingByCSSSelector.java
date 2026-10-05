package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatingByCSSSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

//        WebElement username = driver.findElement(By.cssSelector("input#user-name"));   //Using ID
        WebElement username = driver.findElement(By.cssSelector("input.input_error"));   //Using Class
        WebElement password = driver.findElement(By.cssSelector("input#password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button")); //Using ID
        WebElement loginButton = driver.findElement(By.cssSelector("input.submit-button"));  //Using Class

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }
}
