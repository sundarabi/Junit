package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/FileDownload.html");
    }

    @Test
    public void testDownloadFile() {
        // Locate the download link
        WebElement downloadLink = driver.findElement(By.id("downloadButton"));

        // Click the download link to start the download
        downloadLink.click();

        // Define the download folder and file name (assumes default download folder)
        String downloadPath = System.getProperty("user.home") + "/Downloads";  // Default path for many OS
        String downloadedFilePath = downloadPath + "/sample.txt";

        // Wait for the file to be downloaded
        try {
            Thread.sleep(2000);  // Sleep for 2 seconds (you can increase time if necessary)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the file exists in the download folder
        File downloadedFile = new File(downloadedFilePath);
        assertTrue("File should be downloaded", downloadedFile.exists());

        // Optionally, check the file content (if needed)
        try {
            String content = new String(Files.readAllBytes(Paths.get(downloadedFilePath)));
            assertTrue("File content should not be empty", !content.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
