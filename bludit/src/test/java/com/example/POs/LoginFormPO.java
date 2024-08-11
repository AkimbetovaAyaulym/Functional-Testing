package com.example.POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO {
    private WebDriver driver;

     
    public LoginFormPO(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/admin");
    }

    public void loginTo(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
