package com.vadidra.learn.selenium.orangehrm;

import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import com.vadidra.learn.selenium.orangehrm.pom.Browser;
import com.vadidra.learn.selenium.orangehrm.pom.LoginPage;


import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = Browser.getDriver("chrome");
    }

    @AfterEach
    public void tearDown(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void login_With_Valid_Credentials(){
        LoginPage loginPage;
        try {
            // given
            loginPage = new LoginPage(driver);
            // when
            loginPage.navigateTo();
            loginPage.loginWithValidCredentials();
            // then
            assertTrue(loginPage.isAt());
        }
        catch (Exception e) {
            fail("Exception " + e);
        }
    }

    @Test
    public void login_With_Invalid_Credentials(){
        LoginPage loginPage;
        try {
            // given
            loginPage = new LoginPage(driver);
            // when
            loginPage.navigateTo();
            loginPage.loginWithInvalidCredentials();
            // then
            // this is wrong, need to check the error message
            assertTrue(loginPage.isAt());
        }
        catch (Exception e) {
            fail("Exception " + e);
        }
    }

}
