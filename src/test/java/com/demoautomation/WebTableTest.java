package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class WebTableTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/WebTable.html");
    }

    @Test
    public void testTableData() {
        // Locate the table
        WebElement table = driver.findElement(By.xpath("//div[@class='ui-grid-canvas']"));

        // Validate the number of rows
        List<WebElement> rows = table.findElements(By.className("ui-grid-row"));
        System.out.println("Number of rows: " + rows.size());
        assertEquals("Row count should match", 4, rows.size()); 
        
        // Validate the number of columns
        List<WebElement> columns = rows.get(0).findElements(By.className("ui-grid-cell"));
        System.out.println("Number of columns: " + columns.size());
        assertEquals("Column count should match", 5, columns.size()); 
        
        // Search for a specific user by name
        String searchName = "Nova";
        boolean userFound = false;
        for (WebElement row : rows) {
            if (row.getText().contains(searchName)) {
                System.out.println("User found: " + row.getText());
                userFound = true;
                break;
            }
        }
        assertEquals("User should be found", true, userFound);

        // Verify data in a specific cell ( row 1, column 2)
        WebElement cell = rows.get(0).findElements(By.className("ui-grid-cell")).get(1);
        System.out.println("Cell data: " + cell.getText());
        assertEquals("Expected cell value", "SampleData", cell.getText()); 
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
