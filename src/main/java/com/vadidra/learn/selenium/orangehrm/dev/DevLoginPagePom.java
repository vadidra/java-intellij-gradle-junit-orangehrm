package com.vadidra.learn.selenium.orangehrm.dev;

import com.vadidra.learn.selenium.orangehrm.pom.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class DevLoginPagePom {

    public static void testLoginPagePom(){

        WebDriver driver = null;
        WebDriverWait wait = null;
        LoginPage loginPage;

        try {

            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 20);

            loginPage = new LoginPage(driver, wait);
            loginPage.navigateTo();
            loginPage.login("Admin", "admin123");

            if (loginPage.isAt()) {
                System.out.println("Logged in");
            }


        }
        catch (Exception e) {
            System.out.println("Exception " + e);
        }
        finally{
            if (driver !=null) {
                driver.quit();
                driver = null;
            }
        }

    }

    public static void main(String[] args){
        testLoginPagePom();
        System.exit(0);
    }

}
