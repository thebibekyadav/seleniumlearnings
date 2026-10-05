package seleniumlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingById {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();         // Create an instance of Chrome browser

        driver.get("https://www.saucedemo.com/");  //Open the SauceDemo website
        driver.manage().window().maximize();    //Maximize the browser window

        WebElement usernameField = driver.findElement(By.id("user-name")); // Locate the username input field using its ID
        usernameField.sendKeys("standard_user");               // Enter the username into the username field

        WebElement passwordField = driver.findElement(By.id("password"));  // Locate the password input field using its ID
        passwordField.sendKeys("secret_sauce");                // Enter the password into the password field

        WebElement loginButton = driver.findElement(By.id("login-button"));  // Locate the Login button using its ID
        loginButton.click();    // Click the Login button

        driver.quit();
    }
}
