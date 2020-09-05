package com.vadidra.learn.selenium.orangehrm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends BasicPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    public void navigateTo() throws Exception {
        this.driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Override
    public boolean isAt() throws Exception{
        String title = this.driver.getTitle();
        boolean isAt = title.equals("OrangeHRM");
        System.out.println("LoginPage, isAt starting");
        System.out.println("title " + title);
        System.out.println("isAt " + isAt);
        System.out.println("LoginPage, isAt ending");
        return isAt;
    }

    public void login(String user, String pwd) throws Exception{

            driver.findElement(By.id("txtUsername")).clear();
            driver.findElement(By.id("txtUsername")).sendKeys("Admin");
            driver.findElement(By.id("txtPassword")).clear();
            driver.findElement(By.id("txtPassword")).sendKeys("admin123");
            driver.findElement(By.id("btnLogin")).click();
            wait.until(titleIs("OrangeHRM"));

    }


}
