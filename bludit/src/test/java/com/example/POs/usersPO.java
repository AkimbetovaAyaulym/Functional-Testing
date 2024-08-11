package com.example.POs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class usersPO {
    private WebDriver driver;
    WebDriverWait wait;
    public usersPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By addNewUserLink = By.xpath("//*[@id=\"bl-view\"]/a");
    public void clickAddNewUser(){
        driver.findElement(addNewUserLink).click();
    }

    By userRowsBy = By.cssSelector("table.uk-table.uk-table-striped tbody tr");
   public boolean isUserPresent(String username) {
        List<WebElement> userRows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(userRowsBy));
        for (WebElement row : userRows) {
            if (row.findElement(By.xpath("./td[1]")).getText().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void clickUser(String username) {
        List<WebElement> userRows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(userRowsBy));
        for (WebElement row : userRows) {
            if (row.findElement(By.xpath("./td[1]")).getText().equals(username)) {
                row.findElement(By.xpath("./td[1]/a")).click();
                break;
            }
        }
    }
    By successAlertBy = By.id("alert");
    public boolean isPasswordChanged() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successAlertBy)).isDisplayed();
    }
    By facebookField = By.id("jsfacebook");
    By instagramField = By.id("jsinstagram");

    public void enterSocialLinks(String facebookLink, String instagramLink) {
        WebElement facebookInput = wait.until(ExpectedConditions.visibilityOfElementLocated(facebookField));
        facebookInput.clear();
        facebookInput.sendKeys(facebookLink);
        WebElement instagramInput = wait.until(ExpectedConditions.visibilityOfElementLocated(instagramField));
        instagramInput.clear();
        instagramInput.sendKeys(instagramLink);
    }
    public void clickSaveBtn(){
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public String getFacebookLink() {
        WebElement facebookInput = wait.until(ExpectedConditions.visibilityOfElementLocated(facebookField));
        return facebookInput.getAttribute("value");
    }

    public String getInstagramLink() {
        WebElement instagramInput = wait.until(ExpectedConditions.visibilityOfElementLocated(instagramField));
        return instagramInput.getAttribute("value");
    }


}
