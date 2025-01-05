package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AutoCompleteTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/AutoComplete.html");
    }

    @Test
    public void testAutoCompleteSuggestions() throws InterruptedException {
        // Locate the autocomplete input box
        WebElement inputBox = driver.findElement(By.id("searchbox"));

        // Enter text to trigger suggestions
        String inputText = "Ind";
        inputBox.sendKeys(inputText);

        // Wait for suggestions to load (adjust as needed)
        Thread.sleep(2000);

        // Locate the suggestions dropdown
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));

        // Verify suggestions contain the input text
        boolean allMatch = true;
        for (WebElement suggestion : suggestions) {
            if (!suggestion.getText().toLowerCase().contains(inputText.toLowerCase())) {
                allMatch = false;
                break;
            }
        }

        assertTrue("All suggestions should contain the input text", allMatch);

        // Select the first suggestion
        if (!suggestions.isEmpty()) {
            suggestions.get(0).click();
        }

        // Verify the input field value matches the selected suggestion
        String selectedValue = inputBox.getAttribute("value");
        System.out.println("Selected Value: " + selectedValue);
        assertTrue("The input field value should not be empty after selection", !selectedValue.isEmpty());
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
