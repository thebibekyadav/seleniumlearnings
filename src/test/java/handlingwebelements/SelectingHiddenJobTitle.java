package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Homework to select the Automation Tester as a job title in OrangeHRM website under PIM section

public class SelectingHiddenJobTitle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordField.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type ='submit']"));
        loginButton.click();

        WebElement pimButton = driver.findElement(By.xpath("//span[text()='PIM']"));
        pimButton.click();

        WebElement jobTitle = driver.findElement(By.xpath("//label[text()='Job Title']/ancestor::div[@class= 'oxd-input-group oxd-input-field-bottom-space']//div[@class= 'oxd-select-text oxd-select-text--active']"));
        jobTitle.click();

        WebElement automationTester = driver.findElement(By.xpath("//span[text()='Automaton Tester']"));
        automationTester.click();
    }
}