package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;

public class DragAndDropTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Static.html");
    }

    @Test
    public void testDragAndDrop() {
        // Locate the element to drag
        WebElement dragElement = driver.findElement(By.id("draggable"));

        // Locate the target element where it should be dropped
        WebElement dropTarget = driver.findElement(By.id("droppable"));

        // Create Actions object for drag-and-drop operation
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropTarget).perform();

        // Verify if the dragged element is correctly dropped
        String droppedText = dropTarget.getText();
        assertTrue("The target should contain the text 'Dropped!'", droppedText.contains("Dropped!"));
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
