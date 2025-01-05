package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class SelectableTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Selectable.html");
    }

    @Test
    public void testSelectItems() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='selectable']/li"));

        WebElement firstItem = items.get(0);
        firstItem.click();

        // Verify the first item is selected by checking its class or style
        assertTrue("First item should be selected", firstItem.getAttribute("class").contains("ui-selected"));

        WebElement thirdItem = items.get(2);
        thirdItem.click();

        // Verify the third item is selected
        assertTrue("Third item should be selected", thirdItem.getAttribute("class").contains("ui-selected"));
    }

    @Test
    public void testSelectMultipleItems() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='selectable']/li"));

        items.get(0).click();
        items.get(1).click();
        items.get(2).click();

        // Verify that all selected items have the 'ui-selected' class
        for (int i = 0; i < 3; i++) {
            assertTrue("Item " + (i + 1) + " should be selected", items.get(i).getAttribute("class").contains("ui-selected"));
        }
    }

    @Test
    public void testDeselectItem() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='selectable']/li"));

        WebElement firstItem = items.get(0);
        firstItem.click();

        // Deselect 
        firstItem.click();

        // Verify the item is deselected 
        assertTrue("First item should be deselected", !firstItem.getAttribute("class").contains("ui-selected"));
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
