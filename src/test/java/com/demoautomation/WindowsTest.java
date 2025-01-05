package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class WindowsTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Windows.html");
    }

    @Test
    public void testOpenNewTab() {
        // Click on the "Open New Tabbed Windows" option
        driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();

        // Click on the button to open a new tab
        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();

        // Get the current window handle
        String mainWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the new tab
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Verify the new tab title or content
        String newTabTitle = driver.getTitle();
        System.out.println("New Tab Title: " + newTabTitle);
        assertTrue("The new tab title should contain 'Selenium'", newTabTitle.contains("Selenium"));

        // Close the new tab and switch back to the main window
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    @Test
    public void testOpenNewWindow() {
        // Click on the "Open New Seperate Windows" option
        driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]")).click();

        // Click on the button to open a new window
        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();

        // Get the current window handle
        String mainWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the new window
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Verify the new window title or content
        String newWindowTitle = driver.getTitle();
        System.out.println("New Window Title: " + newWindowTitle);
        assertTrue("The new window title should contain 'Selenium'", newWindowTitle.contains("Selenium"));

        // Close the new window and switch back to the main window
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
