package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

public class AlertsTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void testSimpleAlert() {
        // Click the button to trigger the simple alert
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an alert box:')]")).click();

        // Switch to alert and get text
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Simple Alert Text: " + alertText);

        // Assert the alert text
        assertEquals("Expected alert message", "I am an alert box!", alertText);

        // Accept the alert
        alert.accept();
    }

    @Test
    public void testConfirmationAlert() {
        // Navigate to the confirmation alert tab
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]")).click();

        // Click the button to trigger the confirmation alert
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();

        // Switch to alert and get text
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Confirmation Alert Text: " + alertText);

        // Assert the alert text
        assertEquals("Expected alert message", "Press a Button !", alertText);

        // Cancel the alert
        alert.dismiss();

        // Verify the cancel action result
        String resultText = driver.findElement(By.id("demo")).getText();
        System.out.println("Result after cancel: " + resultText);
        assertEquals("Expected result after cancel", "You Pressed Cancel", resultText);
    }

    @Test
    public void testPromptAlert() {
        // Navigate to the prompt alert tab
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]")).click();

        // Click the button to trigger the prompt alert
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();

        // Switch to alert and enter text
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("John Doe");
        alert.accept();

        // Verify the result text
        String resultText = driver.findElement(By.id("demo1")).getText();
        System.out.println("Result after entering text: " + resultText);
        assertEquals("Expected result text", "Hello John Doe How are you today", resultText);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
