package com.example.POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editUserPO {
    private WebDriver driver;
    WebDriverWait wait;
    public editUserPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   By roleField = By.id("jsrole"); 
    public void enterDetails(String username, String password, String confirmPassword, String email, String role){
        driver.findElement(By.id("jsnew_username")).sendKeys(username);
        driver.findElement(By.id("jsnew_password")).sendKeys(password);
        driver.findElement(By.id("jsconfirm_password")).sendKeys(confirmPassword);

        WebElement roleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(roleField));
        Select dropdown = new Select(roleInput);
        dropdown.selectByVisibleText(role);

        driver.findElement(By.id("jsemail")).sendKeys(email);
    }
    By saveBtn = By.cssSelector("button[type='submit']");
    public void clickSaveBtn(){
        driver.findElement(saveBtn).click();
    }

    public void clickToChangePwd(){
        driver.findElement(By.linkText("Change password")).click();
    }


}
