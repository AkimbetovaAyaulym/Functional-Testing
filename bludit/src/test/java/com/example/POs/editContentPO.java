package com.example.POs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editContentPO {
    private WebDriver driver;
    WebDriverWait wait;
     By advancedBtn = By.xpath("//*[@id=\"bl-view\"]/form/div/div[2]/ul/li[7]/h2");
    By friendlyUrlInput = By.id("jsslug");
    By saveBtn = By.cssSelector("button[type='submit']");
    By positionField = By.id("jsposition");
    public editContentPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAdvancedBtn(){
        driver.findElement(advancedBtn).click();
    }
    public void clearFriendlyUrl(){
        driver.findElement(friendlyUrlInput).clear();
    }
    public void enterFriendlyUrl(String friendlyUrl){
        driver.findElement(friendlyUrlInput).sendKeys(friendlyUrl);
    }
    public void clickSaveBtn(){
        driver.findElement(saveBtn).click();
    }
    public void clearPositionField(){
        driver.findElement(positionField).clear();
    }
    public void enterPositionField(String positionValue){
        driver.findElement(positionField).sendKeys(positionValue);
    }
    public String getPosition(){
         WebElement getPositionValue = wait.until(ExpectedConditions.visibilityOfElementLocated(positionField));
        return getPositionValue.getAttribute("value");
    }
    By parentField = By.id("jsparent");
    public void selectParent(String parentValue) {
        WebElement parent = wait.until(ExpectedConditions.visibilityOfElementLocated(parentField));
        Select dropdown = new Select(parent);
        dropdown.selectByVisibleText(parentValue);
    } 
    public String getSelectedParent() {
        WebElement getParentValue = wait.until(ExpectedConditions.visibilityOfElementLocated(parentField));
       Select parentSelect = new Select(getParentValue);
       return parentSelect.getFirstSelectedOption().getText();
   }

   public void selectStatus(String statusValue) {
    WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jsstatus")));
    Select dropdown = new Select(status);
    dropdown.selectByVisibleText(statusValue);
    } 

    public void clickDeleteBtn(){
        driver.findElement(By.id("jsdelete")).click();
    }

    public void confirmAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
