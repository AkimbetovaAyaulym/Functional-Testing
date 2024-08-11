package com.example.POs;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class ManageContentPO {
    private WebDriver driver;
    By firstPublishedContent = By.xpath("//*[@id=\"bl-view\"]/table/tbody/tr[4]/td[1]/a");
    By logoutLink = By.xpath("//*[@id=\"bl-navbar\"]/div/a");
    By firstPublishedContentUrl = By.xpath("//*[@id=\"bl-view\"]/table/tbody/tr[4]/td[3]/a");
    By contentLink = By.linkText("Content");
    By addNewContent = By.xpath("//*[@id=\"bl-view\"]/div[1]/div/div[1]/div[1]/h4/a");
    By titleInput = By.name("title");
    By saveBtn = By.cssSelector("button[type='submit']");
    By saveDraftBtn = By.cssSelector("button[type='button']"); 
    By firstStickyContent = By.xpath("//*[@id=\"bl-view\"]/table/tbody/tr[10]/td[1]");
    By deletedBludit= By.xpath("//a[text()='Follow Bludit']");
   
    public ManageContentPO(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddNewContent(){
        driver.findElement(addNewContent).click();
    }
    public void clickSaveBtn(){
        driver.findElement(saveBtn).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleInput).sendKeys(title);
    }

    public String getFirstPublishedContentTitle() {
        return (driver.findElement(firstPublishedContent)).getText();
    }
    public String getFirstPublishedContentUrl() {
        return driver.findElement(firstPublishedContentUrl).getAttribute("href");
    }

    public void clickLogout(){
        driver.findElement(logoutLink).click();
    }
    public void clickContentLink(){
        driver.findElement(contentLink).click();
    }
    public void clickSaveDraftBtn(){
        driver.findElement(saveDraftBtn).click();
    }
    public String getFirstDraftContentTitle() {
         return driver.findElement(By.xpath("//*[@id=\"bl-view\"]/table/tbody/tr[2]")).getText().trim();
    }
    public String getFirstStickyContent(){
        return driver.findElement(firstStickyContent).getText().trim();
    }

    public void clickToContent(String contentTitle){
        driver.findElement(By.linkText(contentTitle)).click();
    }
    public boolean isFollowBluditPresent() {
        return !driver.findElements(deletedBludit).isEmpty();
    }
    By usersLink = By.linkText("Users");
    public void clickToUsersLink(){
        driver.findElement(usersLink).click();
    }

}

