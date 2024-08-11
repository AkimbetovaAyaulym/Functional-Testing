package com.example.POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentPagePO {
 private WebDriver driver;
    By testContent = By.linkText("Test Content");

    public ContentPagePO(WebDriver driver) {
        this.driver = driver;
    }
    public void clickTestContent(){
        driver.findElement(testContent).click();
    }
}
