package com.vadidra.learn.selenium.orangehrm.tests;

import static org.junit.Assert.*;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import junit.framework.Assert;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @SuppressWarnings("deprecation")
    @Before
    public void setUp(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
    }

    @After
    public void tearDown(){

        driver.quit();
        driver = null;
    }

    @Test
    public void testLogin(){

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.id("txtUsername")).clear();
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).clear();
            driver.findElement(By.id("txtPassword")).sendKeys("admin123");
            driver.findElement(By.id("btnLogin")).click();
            wait.until(titleIs("OrangeHRM"));
        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }



    }

}
