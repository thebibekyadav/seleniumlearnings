package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandlingDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        WebElement firstFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(firstFrame);

        WebElement datePicker = driver.findElement(By.id("datepicker"));
//        datePicker.sendKeys("04/19/2001");
        datePicker.click();

        String day = "15";
        String month = "October";
        String year = "2026";

        while (true) {
            String calendarMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String calendarYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (calendarMonth.equals(month) && calendarYear.equals(year)) {
                break;
            } else {
                WebElement nextCalendarButton = driver.findElement(By.xpath("//span[text()='Next']"));
                nextCalendarButton.click();
            }
        }
        List<WebElement> noOfDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement calendarDay : noOfDays){
            String weekDate = calendarDay.getText();
            if (weekDate.equals(day)){
                calendarDay.click();
            }
        }
    }
}
