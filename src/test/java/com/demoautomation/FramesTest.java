package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Frames.html");
    }

    @Test
    public void testSingleFrame() {
        // Navigate to Single Frame
        driver.findElement(By.xpath("//a[contains(text(),'Single Iframe')]")).click();

        // Switch to the frame
        WebElement singleFrame = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(singleFrame);

        // Interact with the element inside the frame
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        inputField.sendKeys("Testing Single Frame");

        // Verify the entered text
        String enteredText = inputField.getAttribute("value");
        assertEquals("Testing Single Frame", enteredText);

        // Switch back to the main page
        driver.switchTo().defaultContent();
    }

    @Test
    public void testNestedFrames() {
        // Navigate to Nested Frames
        driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();

        // Switch to the outer frame
        WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerFrame);

        // Switch to the inner frame
        WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(innerFrame);

        // Interact with the element inside the nested frame
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
        inputField.sendKeys("Testing Nested Frames");

        // Verify the entered text
        String enteredText = inputField.getAttribute("value");
        assertEquals("Testing Nested Frames", enteredText);

        // Switch back to the main page
        driver.switchTo().defaultContent();
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
