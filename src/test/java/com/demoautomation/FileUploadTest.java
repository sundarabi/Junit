package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;
import static org.junit.Assert.assertTrue;

public class FileUploadTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/FileUpload.html");
    }

    @Test
    public void testFileUpload() {
        // Locate the file input element for file upload
        WebElement fileInput = driver.findElement(By.id("input-4"));

        // Define the file path (make sure this file exists on your local machine)
        String filePath = "C:/path/to/your/file.txt"; // Adjust the file path as needed

        // Upload the file
        fileInput.sendKeys(filePath);

        // Locate the 'Upload' button and click it
        WebElement uploadButton = driver.findElement(By.id("buttonUpload"));
        uploadButton.click();

        // Locate the element that displays the uploaded file name
        WebElement fileName = driver.findElement(By.xpath("//span[@class='filename']"));

        // Verify that the uploaded file name matches the selected file
        assertTrue("The uploaded file name should match the selected file", fileName.getText().contains("file.txt"));
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
