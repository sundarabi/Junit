package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;

public class SliderTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Slider.html");
    }

    @Test
    public void testSliderMovement() {
        // Locate the slider element
        WebElement slider = driver.findElement(By.id("slider1"));

        // Get the initial position of the slider
        int initialValue = Integer.parseInt(slider.getAttribute("value"));
        System.out.println("Initial Slider Value: " + initialValue);

        // Use Actions class to move the slider to the right
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();

        // Verify the slider value after moving (this can be adjusted as needed)
        int newValue = Integer.parseInt(slider.getAttribute("value"));
        System.out.println("New Slider Value: " + newValue);
        assertTrue("Slider value should be greater than initial value", newValue > initialValue);
    }

    @Test
    public void testSliderEdgeValues() {
        // Locate the slider element
        WebElement slider = driver.findElement(By.id("slider1"));

        // Move slider to the minimum value
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-50, 0).release().perform();
        int minValue = Integer.parseInt(slider.getAttribute("value"));
        System.out.println("Slider Minimum Value: " + minValue);
        assertTrue("Slider minimum value should be 0", minValue == 0);

        // Move slider to the maximum value
        actions.clickAndHold(slider).moveByOffset(100, 0).release().perform();
        int maxValue = Integer.parseInt(slider.getAttribute("value"));
        System.out.println("Slider Maximum Value: " + maxValue);
        assertTrue("Slider maximum value should be 100", maxValue == 100);
    }

    @Test
    public void testSliderIntermediateValue() {
        // Locate the slider element
        WebElement slider = driver.findElement(By.id("slider1"));

        // Move slider to a middle value (for example, 50)
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
        int middleValue = Integer.parseInt(slider.getAttribute("value"));
        System.out.println("Slider Middle Value: " + middleValue);
        assertTrue("Slider value should be 50", middleValue == 50);
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
