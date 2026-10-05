package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingCheckBoxes {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

//        List<WebElement> days = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        List<WebElement> daysName = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']/following-sibling::label"));

        for (WebElement day : daysName) {

            String name = day.getText();

            if (name.equals("Sunday")) {
                day.click();
            }
            if (name.equals("Tuesday")) {
                day.click();
            }
            if (name.equals("Thursday")) {
                day.click();
            }
            if (name.equals("Saturday")) {
                day.click();
            }
        }
    }
}
