package com.vadidra.learn.selenium.orangehrm.dev;

import com.vadidra.learn.selenium.orangehrm.pom.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class DevLoginPage {

    public static void testLoginPage(){

        WebDriver driver;
        WebDriverWait wait;

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);

        try {

            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.id("txtUsername")).clear();
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).clear();
            driver.findElement(By.id("txtPassword")).sendKeys("admin123");
            driver.findElement(By.id("btnLogin")).click();
            wait.until(titleIs("OrangeHRM"));
            System.out.println("Logged in");
        }
        catch (Exception e) {
            System.out.println("Exception " + e);
        }
        finally{

            driver.quit();
            driver = null;

        }

    }

    public static void testLoginPagePom(){

        WebDriver driver;
        WebDriverWait wait;
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        LoginPage loginPage;

        try {

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

            driver.quit();
            driver = null;

        }

    }

    public static void main(String[] args){
        //testLoginPage();
        testLoginPagePom();
    }

}
