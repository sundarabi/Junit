package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;

public class ResizableTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Resizable.html");
    }

    @Test
    public void testResizeElement() {
        WebElement resizableElement = driver.findElement(By.id("resizable"));
        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizable']//div[@class='ui-icon ui-icon-gripsmall-diagonal-se']"));

        // Get the initial size of the resizable element
        int initialWidth = resizableElement.getSize().getWidth();
        int initialHeight = resizableElement.getSize().getHeight();
        System.out.println("Initial Width: " + initialWidth + ", Initial Height: " + initialHeight);

        // Resize the element by dragging the handle
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(50, 50).release().perform();

        // Get the new size of the resizable element
        int newWidth = resizableElement.getSize().getWidth();
        int newHeight = resizableElement.getSize().getHeight();
        System.out.println("New Width: " + newWidth + ", New Height: " + newHeight);

        // Verify that the element has been resized
        assertTrue("Element width should be greater than initial width", newWidth > initialWidth);
        assertTrue("Element height should be greater than initial height", newHeight > initialHeight);
    }

    @Test
    public void testResizeToMax() {
        WebElement resizableElement = driver.findElement(By.id("resizable"));
        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizable']//div[@class='ui-icon ui-icon-gripsmall-diagonal-se']"));

        // Get the initial size of the resizable element
        int initialWidth = resizableElement.getSize().getWidth();
        int initialHeight = resizableElement.getSize().getHeight();

        // Resize the element by dragging the handle to maximum possible size
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(200, 200).release().perform();

        // Get the new size of the resizable element
        int newWidth = resizableElement.getSize().getWidth();
        int newHeight = resizableElement.getSize().getHeight();

        // Verify the element is resized to a larger size
        assertTrue("Element should have increased in size", newWidth > initialWidth);
        assertTrue("Element should have increased in height", newHeight > initialHeight);
    }

    @Test
    public void testResizeToMin() {
        WebElement resizableElement = driver.findElement(By.id("resizable"));
        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizable']//div[@class='ui-icon ui-icon-gripsmall-diagonal-se']"));

        int initialWidth = resizableElement.getSize().getWidth();
        int initialHeight = resizableElement.getSize().getHeight();

        // Resize the element by dragging the handle to minimum size
        Actions actions = new Actions(driver);
        actions.clickAndHold(resizeHandle).moveByOffset(-100, -100).release().perform();

        int newWidth = resizableElement.getSize().getWidth();
        int newHeight = resizableElement.getSize().getHeight();

        // Verify the element has been resized to smaller dimensions
        assertTrue("Element should have decreased in width", newWidth < initialWidth);
        assertTrue("Element should have decreased in height", newHeight < initialHeight);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
