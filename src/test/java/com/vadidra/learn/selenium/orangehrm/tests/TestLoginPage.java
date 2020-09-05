package com.vadidra.learn.selenium.orangehrm.tests;

import com.vadidra.learn.selenium.orangehrm.pom.LoginPage;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestLoginPage {

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
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void testLogin(){

        LoginPage loginPage;

        try {


            loginPage = new LoginPage(driver, wait);
            loginPage.navigateTo();
            loginPage.login("Admin", "admin123");
            Assert.assertTrue(loginPage.isAt());

        }
        catch (Exception e) {
            Assert.fail("Exception " + e);
        }



    }

}
