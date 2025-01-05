package com.demoautomation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationTest extends BaseTest {

    @Before
    public void setUpTest() {
        setUp();
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @Test
    public void testRegistration() {
        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstName.sendKeys("Anakin");

        WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastName.sendKeys("Skywalker");

        WebElement address = driver.findElement(By.cssSelector("textarea[ng-model='Adress']"));
        address.sendKeys("123 Main Street");

        WebElement email = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        email.sendKeys("anakin@gmail.com");

        WebElement phone = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
        phone.sendKeys("1234567890");

        WebElement gender = driver.findElement(By.cssSelector("input[value='Male']"));
        gender.click();

        WebElement hobby = driver.findElement(By.id("checkbox1"));
        hobby.click();

        WebElement skills = driver.findElement(By.id("Skills"));
        skills.sendKeys("Java");

        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        submitButton.click();
    }

    @After
    public void tearDownTest() {
        tearDown();
    }
}
