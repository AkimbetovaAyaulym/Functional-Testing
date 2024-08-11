package TestCases.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CreateNewUserPO {

    WebDriver driver;

    JavascriptExecutor js;

    Map<String, Object> vars;

    public CreateNewUserPO(WebDriver driver, JavascriptExecutor js, Map<String, Object> vars) {
        this.driver = driver;
        this.js = js;
        this.vars = vars;
    }

    public void set_ID_lastname(String key1) {
        By elem = By.id("lastname");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key1);
    }

    public void set_ID_firstname(String key2) {
        By elem = By.id("firstname");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key2);
    }

    public void set_ID_username(String key3) {
        By elem = By.id("username");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key3);
    }

    public void set_ID_password(String key4) {
        By elem = By.id("password");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key4);
    }

    public void set_ID_password_conf(String key5) {
        By elem = By.id("password_conf");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).clear();
        driver.findElement(elem).sendKeys(key5);
    }

    public void click_ID_student() {
        By elem = By.id("student");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void clickToOKBtn() {
        By elem = By.id("applyChange");
        MyUtils.WaitForElementLoaded(driver, elem);
        driver.findElement(elem).click();
    }

    public void set_CSSSELECTOR_msgSuccess() {
        By elem = By.cssSelector(".msgSuccess");
        MyUtils.WaitForElementLoaded(driver, elem);
    }

    public void enterNewUserDetails(String key1, String key2, String key3, String key4, String key5) {
        set_ID_lastname(key1);
        set_ID_firstname(key2);
        set_ID_username(key3);
        set_ID_password(key4);
        set_ID_password_conf(key5);
        click_ID_student();
        clickToOKBtn();
        set_CSSSELECTOR_msgSuccess();
    }

    public String set_CSSSELECTOR_msgSuccess_1() {
        By elem = By.cssSelector(".msgSuccess");
        MyUtils.WaitForElementLoaded(driver, elem);
        return driver.findElement(elem).getText();
    }
}
