package com.vadidra.learn.selenium.orangehrm.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginPage extends BasePage {

    public static final String ADMIN_USER_NAME = "Admin";
    public static final String ADMIN_PWD = "admin123";
    public static final String TITLE = "OrangeHRM";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void navigateTo() throws Exception {
        this.driver.get(BasePage.BASE_URL);
    }

    @Override
    public boolean isAt() throws Exception{
        String title = this.driver.getTitle();
        return title.equals(TITLE);
    }

    public void login() throws Exception{

            driver.findElement(By.id("txtUsername")).clear();
            driver.findElement(By.id("txtUsername")).sendKeys(ADMIN_USER_NAME);
            driver.findElement(By.id("txtPassword")).clear();
            driver.findElement(By.id("txtPassword")).sendKeys(ADMIN_PWD);
            driver.findElement(By.id("btnLogin")).click();
            wait.until(titleIs(TITLE));

    }


}
