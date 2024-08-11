package com.example.POs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginFormPO {
    private WebDriver driver;

    public LoginFormPO(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/administrator");
    }

    public void loginTo(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("submitLogin")).click();
    }

}
