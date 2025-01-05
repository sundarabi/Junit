package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatepickerTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Datepicker.html");
    }

    @Test
    public void testSelectDate() {
        // Open the date picker
        WebElement dateInput = driver.findElement(By.id("datepicker1"));
        dateInput.click();

        // Desired date
        String targetDate = "15";
        String targetMonth = "December";
        String targetYear = "2025";

        // Navigate to the desired month and year
        while (true) {
            String currentMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            if (currentMonthYear.contains(targetMonth) && currentMonthYear.contains(targetYear)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        // Select the desired date
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
        for (WebElement date : dates) {
            if (date.getText().equals(targetDate)) {
                date.click();
                break;
            }
        }

        // Verify the selected date
        String selectedDate = dateInput.getAttribute("value");
        String expectedDate = "12/15/2025"; // Expected format: MM/dd/yyyy
        assertEquals("Selected date should match", expectedDate, selectedDate);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
