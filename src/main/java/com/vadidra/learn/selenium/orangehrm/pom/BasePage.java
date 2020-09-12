package com.vadidra.learn.selenium.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    abstract public boolean isAt() throws Exception;

    public String getTitle(){
        return this.driver.getTitle();
    }


}
