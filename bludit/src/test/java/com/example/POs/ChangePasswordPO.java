package com.example.POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPO {
     private WebDriver driver;
    WebDriverWait wait;
    public ChangePasswordPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterNewPassword(String newPassword, String confirmPassword){
        driver.findElement(By.id("jsnew_password")).sendKeys(newPassword);
        driver.findElement(By.id("jsconfirm_password")).sendKeys(confirmPassword);
    }

    public void clickSaveBtn(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
